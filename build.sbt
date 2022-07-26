import Dependencies._
import sbt._

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

lazy val `blog`: Project =
  project
    .in(file("."))
    .settings(
      name := "blog",
      commonSettings,
      commonDependencies,
    )

lazy val `frontend`: Project =
  project
    .in(file("frontend"))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      name := "frontend",
      scalaJSLinkerConfig ~= {
        _.withModuleKind(ModuleKind.ESModule)
      },
      scalaJSLinkerConfig ~= {
        _.withSourceMap(false)
      },
      scalaJSUseMainModuleInitializer := true,
      commonSettings,
//      commonDependencies,
      frontEndDependencies
    )

lazy val commonSettings
    : Seq[Def.Setting[_ >: EvictionWarningOptions with Task[Seq[String]] <: Object]] =
  commonScalacOptions ++ Seq(
    update / evictionWarningOptions := EvictionWarningOptions.empty
  )

lazy val commonScalacOptions: Seq[Def.Setting[Task[Seq[String]]]] = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val commonDependencies: Seq[Def.Setting[Seq[ModuleID]]] = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
    org.typelevel.cats
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
  ).map(_ % Test),
)

val zioVersion = "2.0.0"
val zioHttpVersion = "2.0.0-RC5"
val zioJsonVersion = "0.3.0-RC5"
val laminarVersion = "0.14.2"

lazy val frontEndDependencies = Seq(
  libraryDependencies ++= Seq(
    "io.github.cquiroz" %%% "scala-java-time" % "2.3.0",
    "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.3.0",
    "org.scala-js" %%% "scalajs-java-securerandom" % "1.0.0" cross CrossVersion.for3Use2_13,
    // zio
    "dev.zio" %%% "zio" % zioVersion,
    "dev.zio" %%% "zio-json" % zioJsonVersion,
    "dev.zio" %%% "zio-prelude" % "1.0.0-RC9",
    // laminar
    "com.raquo" %%% "laminar" % laminarVersion,
    "io.laminext" %%% "fetch" % "0.14.3",
    "io.laminext" %%% "tailwind" % "0.14.3",
    org.typelevel.cats
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
  ).map(_ % Test),
)
