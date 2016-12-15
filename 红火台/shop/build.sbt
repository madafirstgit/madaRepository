name := """shop"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  jdbc,
  "org.mybatis" % "mybatis" % "3.3.0",
  "org.mybatis" % "mybatis-guice" % "3.6",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.google.inject.extensions" % "guice-multibindings" % "4.0",
  "com.alibaba" % "fastjson" % "1.2.20",
  "aopalliance"%"aopalliance"%"1.0",
  "commons-httpclient" % "commons-httpclient" % "3.0.1",
  "org.jdom" % "jdom" % "1.1.3"
)
routesGenerator := InjectedRoutesGenerator