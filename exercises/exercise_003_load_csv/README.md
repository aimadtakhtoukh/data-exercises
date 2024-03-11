# Exercise 3 : Load a CSV

### Setup

We've added a data file : `data/food-price-index-march-2022-index-numbers-csv-tables.csv`, describing the evolution of the food price index, by months.

### Exercise

We're going to connect to a Spark cluster.

First, run the Spark cluster using `docker compose up` in your terminal.

Then, create `example.SparkApp.spark`, a function that creates a remote `SparkSession`.

You can find out how reading here : https://sparkbyexamples.com/spark/sparksession-explained-with-examples/

### Clean-up

You can see a correction by running `cmtc pull-solution`.

Don't forget to run `docker compose down` before running `cmtc next-exercise`.