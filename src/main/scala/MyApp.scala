import tw.edu.ntu.csie.liblinear._

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object MyApp {
	def main(args: Array[String]){
	  	// open file read data
	    val conf = new SparkConf().setAppName("SMO-SVM")  
	    conf.setMaster("local[4]")  

	    val sc = new SparkContext(conf)
	    val prob = new Problem()
	   	val data = Utils.loadLibSVMData(sc, args(0)) 
	   	var model = SparkLiblinear.train(data)
	   	println("program over!")
  	}  

	
}