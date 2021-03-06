package filters

import javax.inject.Inject

import akka.stream.Materializer
import play.api.{Configuration, Logger}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class LoggingFilter @Inject()(val configuration: Configuration)(implicit val mat: Materializer, ec: ExecutionContext) extends Filter {

  val REQUEST_ID_HEADER = "request_id"
  val currentEnvironment = configuration.get[String]("logging.environment")

  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>
      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime
      val requestId = requestHeader.headers.get(REQUEST_ID_HEADER).getOrElse("")
      val logString =
        s"""{ "applicationName":"$name$","environment":"\${currentEnvironment}","httpVerb":"\${requestHeader.method}","uri":"\${requestHeader.uri}","requestId":"\${requestId}","requestTimeMs":"\${requestTime}","statusCode":"\${result.header.status}"}"""

      if (result.header.status >= 300) {
        Logger.error(logString)
      }
      else {
        Logger.info(logString)
      }

      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}
