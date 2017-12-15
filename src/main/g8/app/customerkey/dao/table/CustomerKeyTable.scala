package customerkey.dao.table

import customerkey.model.CustomerKey
import slick.jdbc.MySQLProfile.api._

class CustomerKeyTable(tag: Tag) extends Table[CustomerKey](tag, Some("searchdata"), s"customerfeedkeys") {
  def customerkey = column[String]("CustomerKey", O.AutoInc)

  def pool = column[String]("PoolName")

  override def * =
    (customerkey, pool) <> (CustomerKey.tupled, CustomerKey.unapply)
}