import sbt._

object GoogleApiGrpc {
  val version = "2.6.0"
  val common  = "com.google.api.grpc" % "proto-google-common-protos" % version
}

object Akka {
  val version           = "2.6.16"
  val actorTyped        = "com.typesafe.akka" %% "akka-actor-typed"         % version
  val stream            = "com.typesafe.akka" %% "akka-stream"              % version
  val discovery         = "com.typesafe.akka" %% "akka-discovery"           % version
  val pki               = "com.typesafe.akka" %% "akka-pki"                 % version
  val actorTestkitTyped = "com.typesafe.akka" %% "akka-actor-testkit-typed" % version
  val streamTestkit     = "com.typesafe.akka" %% "akka-stream-testkit"      % version
}

object AkkaHttp {
  val version      = "10.2.6"
  val http         = "com.typesafe.akka" %% "akka-http"          % version
  val http2Support = "com.typesafe.akka" %% "akka-http2-support" % version
}

object Logback {
  val version = "1.2.6"
  val classic = "ch.qos.logback" % "logback-classic" % version
}

object ScalaLogging {
  val version = "3.9.4"
  val core    = "com.typesafe.scala-logging" %% "scala-logging" % version
}

object Logstash {
  val version        = "6.6"
  val logbackEncoder = "net.logstash.logback" % "logstash-logback-encoder" % version
}

object Jackson {
  val version = "2.13.0"
  val scala   = "com.fasterxml.jackson.module" %% "jackson-module-scala" % version
}

object Eff {
  val version = "5.10.0"
  val core    = "org.atnos" %% "eff" % version
}

object Cats {
  val version = "2.1.1"
  val core    = "org.typelevel" %% "cats-core" % version
}

object ScalaTest {
  val version = "3.2.10"
  val core    = "org.scalatest" %% "scalatest" % version
}
