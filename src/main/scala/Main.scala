package com.github.kzmake.scalapic

import usecase.business.BusinessLogger
import usecase.interactor.SimulatePlasmasInteractor
import interface.controller.scalapic.v1._
import infrastructure.logging.BusinessLogging
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import scala.concurrent.ExecutionContext
import org.rogach.scallop._

case class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
  val n = opt[Long](default = Some(10L), validate = _ > 0)

  verify()
}

object Main extends App {
  val conf = new Conf(args.toSeq)

  implicit val ec: ExecutionContext   = ActorSystem[Nothing](Behaviors.empty, "scalapic").executionContext
  implicit val logger: BusinessLogger = new BusinessLogging()

  val controller: ParticleInCellController = new ParticleInCellController(new SimulatePlasmasInteractor())

  val res = controller.simulate(SimulateRequest(10L))

  println(res)
}
