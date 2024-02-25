package example

import org.apache.spark.sql.SparkSession

object SparkApp extends App {

  def spark: SparkSession =
    SparkSession
      .builder
      .appName("Simple Application")
      .config("spark.master", "local[2]")
      .getOrCreate()

  println(spark.version)
}
