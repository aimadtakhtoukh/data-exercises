package example

import example.SparkApp.{dataframeFromCSV, filteredDataframe}
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{Column, DataFrame, SparkSession}
import org.scalatest.flatspec.AnyFlatSpec

class SparkAppTest extends AnyFlatSpec {

  implicit val spark: SparkSession =
    SparkSession
      .builder
      .appName("Tests")
      .master("local[2]")
      .getOrCreate()

  "dataframeFromCSV" should "return a non-empty dataframe" in {
    assert(!dataframeFromCSV().isEmpty)
  }

  it should "have the right schema" in {
    assert(dataframeFromCSV().schema.fieldNames sameElements Array("Series_reference", "Period", "Data_value", "STATUS", "UNITS", "Subject", "Group", "Series_title_1"))
  }

  it should "have every line in the CSV file" in {
    assert(dataframeFromCSV().count() == 12202)
  }

  it should "have the correct first line" in {
    val data = dataframeFromCSV().sort("Series_reference", "Period")
    val firstLine = data.take(1).head
    assert(firstLine.mkString(",") == "CPIM.SE901,1960.01,45.92346148,FINAL,Index,Consumers Price Index - CPI,Food Price Index for New Zealand,Food")
  }

  "filteredDataframe" should "return a non-empty dataframe" in {
    val data = dataframeFromCSV()
    assert(!filteredDataframe(data).isEmpty)
  }

  it should "have the right schema" in {
    val data = dataframeFromCSV()
    assert(filteredDataframe(data).schema.fieldNames sameElements Array("Series_reference", "Period", "Data_value", "STATUS", "UNITS", "Subject", "Group", "Series_title_1"))
  }

  it should "have a line for each month" in {
    val data = dataframeFromCSV()
    assert(filteredDataframe(data).count() == 12)
  }

  it should "have only lines from the 2008 period" in {
    val data = dataframeFromCSV()
    assert(filteredDataframe(data).allMatch(col("Period") startsWith "2008"))
  }

  it should "have only lines about fruits and vegetables" in {
    val data = dataframeFromCSV()
    assert(filteredDataframe(data).allMatch(col("Series_title_1") === "Fruit and vegetables"))
  }

  implicit class ExtendedDataframe(df: DataFrame) {
    def allMatch(pred: Column): Boolean =
      df.filter(!pred).isEmpty
  }

}
