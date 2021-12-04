package interface.controller.scalapic.v1

import api.scalapic.v1._

import org.atnos.eff.{Fx, TimedFuture}
import org.atnos.eff.ExecutorServices
import org.atnos.eff.concurrent.Scheduler
import org.atnos.eff.syntax.all.toEitherEffectOps
import org.atnos.eff.syntax.future.toFutureOps
import usecase.port.{SimulatePlasmasPort, SimulatePlasmasInputData}
import domain.eff.DomainEither
import domain.error.DomainError

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class ParticleInCellSimulationController(
    simulate: SimulatePlasmasPort
)(implicit ec: ExecutionContext)
    extends ParticleInCellSimulatorService {
  type Stack = Fx.fx2[TimedFuture, DomainEither]

  override def simulate(_request: SimulateRequest): Future[SimulateResponse] = {
    implicit val scheduler: Scheduler = ExecutorServices.schedulerFromGlobalExecutionContext

    simulate
      .program[Stack](SimulatePlasmasInputData.apply())
      .runEither[DomainError]
      .runAsync
      .flatMap {
        case Right(out) =>
          Future.successful(
            SimulateResponse()
          )
        case Left(e) => Future.failed(new Exception())
      }
  }
}
