package example

import org.apache.spark.sql.SparkSession
import org.scalatest.flatspec.AnyFlatSpec
import SparkApp.dataframeFromCSV

class SparkAppTest extends AnyFlatSpec {

  def spark: SparkSession =
    SparkSession
      .builder
      .appName("Tests")
      .master("local[2]")
      .getOrCreate()

  "dataframeFromCSV" should "return a non-empty dataframe" in {
    implicit val session: SparkSession = spark
    assert(!dataframeFromCSV().isEmpty)
  }

  it should "have the right schema" in {
    implicit val session: SparkSession = spark
    assert(dataframeFromCSV().schema.fieldNames sameElements Array("Series_reference", "Period", "Data_value", "STATUS", "UNITS", "Subject", "Group", "Series_title_1"))
  }

  it should "have every line in the CSV file" in {
    implicit val session: SparkSession = spark
    assert(dataframeFromCSV().count() == 12202)
  }

  it should "have the correct first line" in {
    implicit val session: SparkSession = spark
    val firstLine = dataframeFromCSV().take(1).head
    assert(firstLine.mkString(",") == "CPIM.SE901,1960.01,45.92346148,FINAL,Index,Consumers Price Index - CPI,Food Price Index for New Zealand,Food")
  }

}
