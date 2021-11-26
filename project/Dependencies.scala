import sbt._

object Breeze {
  val version = "2.0"
  val core    = "org.scalanlp" %% "breeze"     % version
  val viz     = "org.scalanlp" %% "breeze-viz" % version
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
