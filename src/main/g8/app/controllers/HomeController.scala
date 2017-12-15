package controllers

import javax.inject._

import customerkey.model.{CustomerKeyDAO}
import play.api.mvc._
import play.api.libs.json._
import customerkey.model.CustomerKeyJsonMaps._

import scala.concurrent.{ExecutionContext, Future}

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, customerKeyDAO: CustomerKeyDAO)(implicit val ec: ExecutionContext)
  extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action.async { implicit request: Request[AnyContent] =>
    val res = for {
      keys <- customerKeyDAO.getCustomerKeys
    } yield Ok(Json.toJson(keys))
    res recover {
      case ex: Exception => InternalServerError(ex.getMessage)
    }
  }
}