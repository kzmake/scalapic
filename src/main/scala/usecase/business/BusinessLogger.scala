package usecase.business

import scala.concurrent.Future

trait BusinessLogger {
  def output(message: String): Future[Unit]
}
