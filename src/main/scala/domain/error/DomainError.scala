package domain.error

import cats.data.NonEmptyList

case class DomainError(error: NonEmptyList[String]) extends Throwable

object DomainError {
  def create(message: String): DomainError             = apply(NonEmptyList.one(message))
  def create(error: NonEmptyList[String]): DomainError = apply(error)
}
