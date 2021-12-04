package usecase.port

import org.atnos.eff.future._future
import org.atnos.eff.Eff
import domain.eff._domainEither

trait InputData  extends Any
trait OutputData extends Any

trait Port[Input <: InputData, Output <: OutputData] {
  def program[R: _future: _domainEither](in: Input): Eff[R, Output];
}
