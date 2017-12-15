package customerkey.model

import scala.concurrent.Future

trait CustomerKeyDAO {
  def getCustomerKeys: Future[Seq[CustomerKey]]
}