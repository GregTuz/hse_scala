case class User(id: Int, name: String)
case class Order(userId: Int, amount: Double)

object Task2 extends App {
  def findUser(id: Int): Option[User] = {
    if (id > 0) Some(User(id, s"User$id")) else None
  }

  def getActiveOrder(user: User): Option[Order] = {
    if (user.id % 2 == 0) Some(Order(user.id, 600.0)) else Some(Order(user.id, 300.0))
  }

  def calculateDiscount(order: Order): Either[String, Double] = {
    if (order.amount < 500) Left("Слишком маленькая сумма для скидки")
    else Right(order.amount * 0.1)
  }

  def getUserDiscount(userId: Int): Either[String, Double] = {
    val result = for {
      user <- findUser(userId).toRight("Пользователь не найден")
      order <- getActiveOrder(user).toRight("Активный заказ не найден")
      discount <- calculateDiscount(order)
    } yield discount

    result
  }

  println(getUserDiscount(2))
  println(getUserDiscount(3))
  println(getUserDiscount(-1))
}
