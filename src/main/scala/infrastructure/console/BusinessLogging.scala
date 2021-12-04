package infrastructure.logging

import usecase.business.BusinessLogger

import scala.concurrent.Future

class BusinessLogging extends BusinessLogger {
  def output(message: String): Future[Unit] = Future.successful(println(s"${message}"))
}
