name := """$name$"""
organization := "$organization$"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "$scala_version$"

libraryDependencies += filters

libraryDependencies ++= Seq(
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.amazonaws" % "aws-java-sdk" % "1.0.002",
  "com.typesafe.play" % "play-slick_2.11" % "2.0.2",
  "com.typesafe.play" % "play-slick-evolutions_2.11" % "2.0.2",
  "mysql" % "mysql-connector-java" % "6.0.5",
  "org.scalaj" % "scalaj-http_2.11" % "2.3.0",
  "org.mockito" % "mockito-all" % "1.10.19",
  "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.16"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "$organization$.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "$organization$.binders._"
