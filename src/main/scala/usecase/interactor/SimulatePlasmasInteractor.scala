package usecase.interactor

import org.atnos.eff.Eff
import org.atnos.eff.future._future
import domain.eff.{_domainEither, FutureOps}
import domain.entity._
import domain.vo._
import usecase.port._
import usecase.business._
import scala.concurrent.ExecutionContext

class SimulatePlasmasInteractor()(implicit
    ec: ExecutionContext,
    businessLogger: BusinessLogger
) extends SimulatePlasmasPort {
  def program[R: _future: _domainEither](_in: SimulatePlasmasInputData): Eff[R, SimulatePlasmasOutputData] =
    for {
      _ <- businessLogger.output(s"hogehoge").raiseIfFutureFailed("").toEff
      p = Plasma.apply(3, Charge(1.0), Mass(1.0), 1, 1, 1)
      _ <- businessLogger.output(s"${p}").raiseIfFutureFailed("").toEff
    } yield SimulatePlasmasOutputData.apply()
}
