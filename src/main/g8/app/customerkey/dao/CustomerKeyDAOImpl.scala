package customerkey.dao

import javax.inject.Inject

import customerkey.dao.table.CustomerKeyTable
import customerkey.model.{CustomerKey, CustomerKeyDAO}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

class CustomerKeyDAOImpl @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider)
(implicit executionContext: ExecutionContext)
  extends CustomerKeyDAO with HasDatabaseConfigProvider[MySQLProfile] {

  val CustomerKeys = TableQuery[CustomerKeyTable]

  def getCustomerKeys: Future[Seq[CustomerKey]] = {
    db.run(CustomerKeys.result)
  }
}