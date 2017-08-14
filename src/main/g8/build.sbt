name := """$name$""".toLowerCase

lazy val ecsRepoNamespace = """227029288974.dkr.ecr.us-east-1.amazonaws.com"""

organization := "cbdr"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "$scala_version$"

libraryDependencies += filters

libraryDependencies ++= Seq(
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test,
  "com.amazonaws" % "aws-java-sdk" % "1.11.48",
  "com.typesafe.play" % "play-slick_2.11" % "2.0.2",
  "com.typesafe.slick" %% "slick-extensions" % "3.1.0",
  "mysql" % "mysql-connector-java" % "6.0.5",
  "org.mockito" % "mockito-all" % "1.10.19",
  "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.16"
)
