package utils

import org.apache.spark.sql.{DataFrame, SparkSession}

object ExerciseUtils {

  def csvPath: String = "data/food-price-index-march-2022-index-numbers-csv-tables.csv"

  def sparkSession(appName: String = "Simple Application") : SparkSession =
    SparkSession
      .builder
      .appName(appName)
      .getOrCreate()

  def localSparkSession: SparkSession =
    SparkSession
      .builder
      .config("spark.master", "local[2]") //for local testing
      .appName("Simple Application")
      .getOrCreate()

  def csvDataFrame(csvPath: String = ExerciseUtils.csvPath)(implicit sparkSession: SparkSession): DataFrame =
    sparkSession.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(csvPath)
      .repartition(2) // Repartition the DataFrame into two partitions

}
