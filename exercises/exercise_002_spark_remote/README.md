# Exercise 2 : Spark remote cluster

### Setup

We've added a docker-compose.yml file! You can check it out, it creates a local Spark cluster with a master and two workers.

### Exercise

We're going to connect to a Spark cluster.

First, run the Spark cluster using `docker compose up` in your terminal.

Then, create `example.SparkApp.spark`, a function that creates a remote `SparkSession`.

You can find out how reading here : https://sparkbyexamples.com/spark/sparksession-explained-with-examples/

### Clean-up

You can see a correction by running `cmtc pull-solution`.

Don't forget to run `docker compose down` before running `ctmc next-exercise`.