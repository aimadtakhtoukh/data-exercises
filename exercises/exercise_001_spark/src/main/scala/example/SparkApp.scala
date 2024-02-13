package example

import org.apache.spark.sql.SparkSession

object SparkApp extends App {
  val csvFile = "data/food-price-index-march-2022-index-numbers-csv-tables.csv"
  val spark = SparkSession
    .builder
    //.config("spark.master", "local") //for local testing
    .appName("Simple Application")
    .getOrCreate()
  val df = spark.read
    .option("header", "true") // If your CSV file has a header
    .option("inferSchema", "true") // Infer data types
    .csv(csvFile)

  // Repartition the DataFrame into two partitions
  val repartitionedDf = df.repartition(2)

  import org.apache.spark.sql.functions.col
  val result = repartitionedDf
    .where("Series_title_1 == 'Food'")
    .sort(col("Period"))

  // Perform operations on the DataFrame (e.g., show, write, or any other transformations)
  result.show()
}
