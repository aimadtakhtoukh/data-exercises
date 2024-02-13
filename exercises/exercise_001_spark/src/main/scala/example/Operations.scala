package example

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{split, col}

object Operations {

  def averageFoodPriceIndexByYear(df: DataFrame) : DataFrame =
    df
      .where("Series_reference == 'CPIM.SE901'") // Filter for the "Food" series
      .withColumn("year", split(col("Period"), "\\.").getItem(0)) // Extract the year from the Period column
      .withColumn("value", col("Data_value").cast("Double")) // Properly cast the Data_value column
      .groupBy("year").avg("value").sort("year") // Gives us the average

}
