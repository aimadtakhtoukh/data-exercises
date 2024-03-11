# Exercise 3 : Load a CSV

### Setup

We've added a data file : `data/food-price-index-march-2022-index-numbers-csv-tables.csv`, describing the evolution of the food price index, by months.

Starting now, the corrections are going to use a local cluster, but you can run your code in the cluster in Docker compose. To do so:

- Put the Spark dependency as "provided" in build.sbt.
- Build the deployable artifact with `sbt assembly`
- Send the artifact with `docker cp target/scala-2.12/spark-assembly-0.1.0-SNAPSHOT.jar ras-spark:opt/bitnami/spark/app.jar`
- Finally, run the job with `docker exec ras-spark spark-submit --master spark://spark:7077 app.jar`

### Exercise

We're going to load the CSV file in a Dataframe, and see what's inside.

Please create SparkApp.dataframeFromCSV, that takes an implicit SparkSession instance to read the csv file.

You can read up on how to do that here : https://spark.apache.org/docs/latest/sql-data-sources-csv.html

### Clean-up

You can see a correction by running `cmtc pull-solution`.

When you're ready, run `cmtc next-exercise` to load the next exercise.