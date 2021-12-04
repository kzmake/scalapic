package com.github.kzmake.scalapic

import api.scalapic.v1._

import usecase.business.BusinessLogger
import usecase.interactor.SimulatePlasmasInteractor
import usecase.port.SimulatePlasmasPort
import interface.controller.scalapic.v1.ParticleInCellSimulationController
import infrastructure.logging.BusinessLogging

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.model.HttpResponse
import akka.grpc.scaladsl.ServerReflection
import akka.grpc.scaladsl.ServiceHandler
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

object Main extends App {
  val conf: Config = ConfigFactory
    .parseString("akka.http.server.preview.enable-http2 = on")
    .withFallback(ConfigFactory.defaultApplication())

  implicit val sys: ActorSystem[Nothing]      = ActorSystem[Nothing](Behaviors.empty, "Osaifu", conf)
  implicit val ec: ExecutionContext           = sys.executionContext
  implicit val businessLogger: BusinessLogger = new BusinessLogging()

  val simulate: SimulatePlasmasPort              = new SimulatePlasmasInteractor()
  val controller: ParticleInCellSimulatorService = new ParticleInCellSimulationController(simulate)

  val service: PartialFunction[HttpRequest, Future[HttpResponse]] =
    ParticleInCellSimulatorServiceHandler.partial(controller)
  val reflection: PartialFunction[HttpRequest, Future[HttpResponse]] =
    ServerReflection.partial(List(ParticleInCellSimulatorService))
  val handlers: HttpRequest => Future[HttpResponse] =
    ServiceHandler.concatOrNotFound(service, reflection)

  Http()
    .newServerAt("0.0.0.0", 50051)
    .bind(handlers)
    .foreach { binding => println(s"gRPC server bound to: ${binding.localAddress}") }
}
