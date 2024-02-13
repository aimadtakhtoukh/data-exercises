
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization     := "com.mind7"
ThisBuild / organizationName := "mind7"

lazy val root = (project in file("."))
  .settings(
    name := "setup",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.15" % Test
    )
  )
