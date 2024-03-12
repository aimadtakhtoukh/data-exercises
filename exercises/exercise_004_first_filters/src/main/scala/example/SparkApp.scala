package example

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkApp extends App {

  def spark: SparkSession =
    SparkSession
      .builder
      .appName("Simple Application")
      .master("local[2]")
      .getOrCreate()

  implicit val sparkSession : SparkSession = spark

  private def csvPath: String = "data/food-price-index-march-2022-index-numbers-csv-tables.csv"

  def dataframeFromCSV(csvPath: String = csvPath)(implicit sparkSession: SparkSession): DataFrame =
    sparkSession.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(csvPath)
      .repartition(2)

  def filteredDataframe(dataFrame: DataFrame) : DataFrame =
    dataFrame
      .where(col("Series_reference") === "CPIM.SE9011")
      .filter(col("Period").startsWith("2008"))

  println(filteredDataframe(dataframeFromCSV()).show())
}
