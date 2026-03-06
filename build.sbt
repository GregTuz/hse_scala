ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

lazy val root = (project in file("."))
  .settings(
    name := "hse_scala"
  )

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC7"
