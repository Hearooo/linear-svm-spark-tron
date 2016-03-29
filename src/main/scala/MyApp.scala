import tw.edu.ntu.csie.liblinear._

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import java.lang.System

object MyApp {
	def main(args: Array[String]){
	  	// open file read data
	    val conf = new SparkConf().setAppName("SMO-SVM-Lin")  
	    conf.setMaster("local[8]")  

	    val sc = new SparkContext(conf)
	    val prob = new Problem()
	   	val data = Utils.loadLibSVMData(sc, args(0)) 

	   	val t1 = System.currentTimeMillis
	   	var model = SparkLiblinear.train(data)

    	val t2 = System.currentTimeMillis
    	val runtime = (t2 - t1)/1000
    	print("time is ", runtime)

	   	val res = data.map{x => model.predict(x)}.persist

	   	val total = data.count
	   	val correct = data.zip(res).filter(x => x._1.y==x._2).count
	   	println("correct is ", correct)
	   	println("total number is ", total)
	   	println("Accuracy is ", correct.toDouble/total.toDouble)
  	}  

	
}