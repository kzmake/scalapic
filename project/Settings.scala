import sbt._
import sbt.Keys._

object Settings {
  val coreSettings: Def.SettingsDefinition = Seq(
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-Xfatal-warnings",
      "-language:_",
      // Warn if an argument list is modified to match the receiver
      // "-Ywarn-adapted-args",
      // Warn when dead code is identified.
      "-Ywarn-dead-code",
      // Warn about inaccessible types in method signatures.
      // "-Ywarn-inaccessible",
      // Warn when a type argument is inferred to be `Any`.
      // "-Ywarn-infer-any",
      // Warn when non-nullary `def f()' overrides nullary `def f'
      // "-Ywarn-nullary-override",
      // Warn when nullary methods return Unit.
      // "-Ywarn-nullary-unit",
      // Warn when numerics are widened.
      "-Ywarn-numeric-widen"
      // Warn when imports are unused.
      // "-Ywarn-unused-import"
    ),
    libraryDependencies ++= Seq(
      ScalaLogging.core,
      Logback.classic,
      Logstash.logbackEncoder,
      Jackson.scala,
      Eff.core,
      Cats.core,
      ULID.core,
      UUID7s.core,
      Shapeless.core,
      Scallop.core,
      ScalaTest.core % Test
    )
  )

  val akkaSettings: Def.SettingsDefinition = Seq(
    libraryDependencies ++= Seq(
      AkkaHttp.http,
      AkkaHttp.http2Support,
      Akka.actorTyped,
      Akka.stream,
      Akka.discovery,
      Akka.pki,
      Akka.actorTestkitTyped % Test,
      Akka.streamTestkit     % Test
    )
  )
}
