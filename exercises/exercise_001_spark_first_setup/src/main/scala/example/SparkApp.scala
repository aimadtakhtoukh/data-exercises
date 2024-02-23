package example

import org.apache.spark.sql.{DataFrame, SparkSession}
import utils.ExerciseUtils._

object SparkApp extends App {

  def spark: SparkSession =
    SparkSession
      .builder
      .appName("Simple Application")
      .config("spark.master", "local[2]")
      .getOrCreate()

  println(spark.version)
}
