# Exercise 2 : Spark remote cluster

### Setup

We've added a docker-compose.yml file! You can run `docker compose up -d` to load a small Spark cluster, with a master and two workers.
Once it's running, you can see the web UI at http://localhost:8080.

### Exercise

We're going to connect to a Spark cluster.

First, run the Spark cluster using `docker compose up` in your terminal.

Then, create `example.SparkApp.spark`, a function that creates a remote `SparkSession`.

You can find out how reading here : https://sparkbyexamples.com/spark/sparksession-explained-with-examples/

### Clean-up

You can see a correction by running `cmtc pull-solution`.

You can stop the cluster with `docker compose down`.

When you're ready, run `cmtc next-exercise` to load the next exercise.
