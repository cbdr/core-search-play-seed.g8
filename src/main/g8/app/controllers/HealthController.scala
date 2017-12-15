package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class HealthController @Inject()(configuration: play.api.Configuration, cc: ControllerComponents) extends AbstractController(cc) {
  def get = Action {
    Ok
  }
}
