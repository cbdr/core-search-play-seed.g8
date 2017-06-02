name := """$name$""".toLowerCase

lazy val ecsRepoNamespace = """227029288974.dkr.ecr.us-east-1.amazonaws.com"""

organization := "careerbuilder"

version := "1.0"

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

enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

dockerfile in docker := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("java")
    entryPoint(s"\$targetDir/bin/\${executableScriptName.value}")
    copy(appDir, targetDir)
  }
}

imageNames in docker := Seq(
  ImageName(
    namespace = Some(ecsRepoNamespace),
    repository = name.value,
    tag = Some(version.value)
  )
)

addCommandAlias("dockerize", ";clean;stage;compile;docker")
