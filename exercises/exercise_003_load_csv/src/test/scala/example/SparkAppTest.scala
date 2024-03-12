package example

import org.apache.spark.sql.SparkSession
import org.scalatest.flatspec.AnyFlatSpec
import SparkApp.dataframeFromCSV

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

}
