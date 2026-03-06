trait Validator[T] {
  def validate(value: T): Boolean
}

object Validator {
  implicit val stringValidator: Validator[String] = new Validator[String] {
    def validate(value: String): Boolean = value.nonEmpty
  }

  implicit val intValidator: Validator[Int] = new Validator[Int] {
    def validate(value: Int): Boolean = value > 0
  }
}

object ValidatorSyntax {
  implicit class ValidatorOps[T](value: T) {
    def isValid(implicit v: Validator[T]): Boolean = v.validate(value)
  }
}

object Task3 extends App {
  import Validator._
  import ValidatorSyntax._

  def check[T](value: T)(implicit v: Validator[T]): Unit = {
    if (v.validate(value)) println("OK") else println("Error")
  }

  check("")
  check(-1)
  check(123)
  check("hello_world")

  println("".isValid)
  println((-1).isValid)
  println(123.isValid)
  println("hello_world".isValid)
    
}