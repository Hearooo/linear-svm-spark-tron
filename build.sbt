name := "Spark Kernel SVM"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies ++=  Seq(
"org.apache.spark" %% "spark-core" % "1.6.0" % "provided",
"org.apache.spark"  %% "spark-mllib" % "1.6.0" % "provided",
"org.scalanlp" % "jblas" % "1.2.1"
)
