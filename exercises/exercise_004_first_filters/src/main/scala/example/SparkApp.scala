package example

import org.apache.spark.sql.{DataFrame, SparkSession}
import utils.ExerciseUtils._

object SparkApp extends App {

  implicit val spark: SparkSession = sparkSession()
  private val dataFrame: DataFrame = csvDataFrame()

  Operations.averageFoodPriceIndexByYear(dataFrame).show()
}
