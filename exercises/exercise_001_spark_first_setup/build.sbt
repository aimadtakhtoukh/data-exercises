import sbt._

mainClass := Some("example.SparkApp")

javacOptions ++= Seq("-source", "11", "-target", "11")

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion     := "2.12.15"
ThisBuild / organization     := "com.mind7"
ThisBuild / organizationName := "mind7"

lazy val root = (project in file("."))
  .settings(
    name := "spark",
    libraryDependencies ++= Seq(
//      "org.apache.spark" %% "spark-sql" % "3.5.0" % "provided",
      "org.apache.spark" %% "spark-sql" % "3.5.0",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    )
  )

ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}