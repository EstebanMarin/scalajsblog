import Dependencies._

ThisBuild / organization := "com.esteban"
ThisBuild / scalaVersion := "3.1.3"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-explain",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
    "-Ykind-projector",
    "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val `blog` =
  project
    .in(file("."))
    .settings(name := "blog")
    .settings(commonSettings)
    .settings(dependencies)

lazy val `frontend` =
  project
    .in(file("frontend"))
    .enablePlugins(ScalaJSPlugin)
    .settings(name := "frontend")
    .settings(commonSettings)
    .settings(dependencies)
    .settings(scalaJSUseMainModuleInitializer := true)


lazy val commonSettings = commonScalacOptions ++ Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty
)

lazy val commonScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
    org.typelevel.cats
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
  ).map(_ % Test),
)
