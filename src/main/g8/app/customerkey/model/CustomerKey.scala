package customerkey.model

import play.api.libs.json.Json

case class CustomerKey(customerkey: String, pool: String)

object CustomerKeyJsonMaps {
  implicit val customerKeyWrites = Json.writes[CustomerKey]
}