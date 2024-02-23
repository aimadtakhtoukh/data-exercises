package example

import org.scalatest.flatspec.AnyFlatSpec

class SparkAppTest extends AnyFlatSpec {

  "A Spark Session" should "be at version 3.5.0" in {
    val session = SparkApp.spark
    assert(session.version == "3.5.0")
  }

  it should "have a local URL" in {
    val session = SparkApp.spark
    assert(session.conf.get("spark.master").startsWith("local"))
  }

}
