import Settings._

val projectName = "scalapic"

ThisBuild / organization               := "com.github.kzmake"
ThisBuild / scalaVersion               := "2.13.6"
ThisBuild / semanticdbEnabled          := true
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)
ThisBuild / semanticdbVersion          := scalafixSemanticdb.revision // only required for Scala 2.x
ThisBuild / scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Wunused:imports" // Scala 2.x only, required by `RemoveUnused`
)

Docker / packageName        := s"${projectName}"
Docker / dockerRepository   := Some("ghcr.io/kzmake")
Docker / maintainer         := "kzmake <kamake.i3a@gmail.com>"
Docker / dockerExposedPorts := List(50051)

lazy val root = (project in file("."))
  .settings(
    name := projectName
  )
  .enablePlugins(JavaAppPackaging)
  .settings(coreSettings)
