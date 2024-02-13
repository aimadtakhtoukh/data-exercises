# Exercise 1 : Spark

### Setup

First, build.sbt has been updated, so run `sbt reload` to get the spark library.

Then run `docker compose up -d` to load a small Spark cluster, with a master and two workers.
Once it's running, you can see the web UI at http://localhost:8080.

To see your code run, you can run these commands:

    sbt assembly
    docker cp target/scala-2.12/spark-assembly-0.1.0-SNAPSHOT.jar ras-spark:opt/bitnami/spark/app.jar
    docker exec ras-spark spark-submit --master spark://spark:7077 app.jar
    
### Exercise

You're provided, in data/food-price-index-march-2022-index-numbers-csv-tables.csv, a set of month-per-month data on the food price index evolution in New Zealand from January 1960 to March 2022, split by series. We want an average of the food price index for the "Food" series, averaged by year.

Please load the CSV in a Dataframe and discover the methods it gives you to split the work between the workers and obtain the info we need.

### Clean-up

You can see a correction by running `cmtc pull-solution`.

Don't forget to run `docker compose down` before running `ctmc next-exercise`.