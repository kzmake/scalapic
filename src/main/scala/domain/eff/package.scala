package domain

import org.atnos.eff.future.{_future, fromFuture}
import org.atnos.eff.{|=, either, Eff}
import domain.error.DomainError

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

package object eff {
  type DomainEither[T]  = Either[DomainError, T]
  type _domainEither[R] = DomainEither |= R

  implicit class FutureOps[T](futureValue: Future[T])(implicit ec: ExecutionContext) {
    def raiseIfFutureFailed(message: String): Future[T] =
      futureValue.transformWith {
        case Success(value) => Future.successful(value)
        case Failure(exception) =>
          Future.failed(DomainError.create(s"${message}: ${exception.getMessage}"))
      }

    def toEff[R: _future]: Eff[R, T] = fromFuture(futureValue)
  }

  // implicit class IndexedSeqOps[T](indexedSeqValues: IndexedSeq[T])(implicit ec: ExecutionContext) {
  //   def toEff[R: _domainEither]: Eff[R, IndexedSeq[T]] = either.right(indexedSeqValues)
  // }

  implicit class EitherDomainErrorOps[T](eitherValue: Either[DomainError, T]) {
    def toEff[R: _domainEither]: Eff[R, T] = either.fromEither(eitherValue)
  }
}
