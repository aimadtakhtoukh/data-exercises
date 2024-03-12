# Big Data Exercises

The goal is to explore classic tools for big data jobs.

### Prerequisites

To run the project, your environment must have these prerequisites:

- java 11 (more recent versions may not work with Sparkv)
- docker
- scala
- sbt
- cmtc

# First checks

### Docker

The exercises will depend on Docker and Docker Compose, via docker-compose.yml files in the exercises. They'll allow us to run a Spark cluster and other parts of the stack we'll need.

Check if everything is working by running `docker --version`. The command should return

    Docker version 25.0.2, build 29cf629

Docker Compose now is installed by default with Docker, so you can run `docker compose version`. The command should return 

    Docker Compose version v2.24.3-desktop.1

### Scala and SBT

If Scala and sbt aren't installed yet, get Coursier at https://get-coursier.io/

Exercises are written in Scala, and SBT is what we'll use to build, get dependencies and run tests.

Check if everything is working by running `sbt test`.

After a while pulling, compiling and running the test, you should see :

    [info] BasicCheck:
    [info] 1
    [info] - should not equal 2
    [info] Run completed in 408 milliseconds.
    [info] Total number of tests run: 1
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.

Run the tests during the exercises to see what results are expected.

### CMTC

Finally, if you don't have cmtc installed yet, install Coursier (or use it from earlier) and run `cs install --contrib cmtc`

You'll need to run `cmtc set-current-course -s .` to start the course.

When you're ready, run `cmtc next-exercise` to load the next exercise.
