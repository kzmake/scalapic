package interface.controller.scalapic.v1

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

case class SimulateRequest(n: Long)
case class SimulateResponse(n: Long)

class ParticleInCellController(
    simulate: SimulatePlasmasPort
)(implicit ec: ExecutionContext) {
  type Stack = Fx.fx2[TimedFuture, DomainEither]

  def simulate(req: SimulateRequest): Future[SimulateResponse] = {
    implicit val scheduler: Scheduler = ExecutorServices.schedulerFromGlobalExecutionContext
    (
      for {
        s <- simulate.program[Stack](SimulatePlasmasInputData())
      } yield (s)
    ).runEither[DomainError].runAsync.flatMap {
      case Right(out) => Future.successful(SimulateResponse(req.n))
      case Left(e)    => Future.failed(new Exception())
    }
  }
}
