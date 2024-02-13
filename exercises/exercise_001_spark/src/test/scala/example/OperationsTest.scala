package example

import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import utils.ExerciseUtils.{csvDataFrame, localSparkSession}

class OperationsTest extends AnyFlatSpec with BeforeAndAfterAll {

  @transient implicit var spark: SparkSession = localSparkSession
  @transient var sourceDataframe: DataFrame = csvDataFrame()

  "The average food price index per year" should "contain two columns" in {
    val result = Operations.averageFoodPriceIndexByYear(sourceDataframe)
    assert(result.columns sameElements Array("year", "avg(value)"))
    assert(result.schema("avg(value)").dataType == DoubleType)
  }

}
