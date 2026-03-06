import play.api.libs.json._
import play.api.libs.functional.syntax._

object Task4 extends App {
  case class Product(id: Long, name: String, price: Double, tags: List[String])

  implicit val productFormatManual: OFormat[Product] = (
    (JsPath \ "id").format[Long] and
      (JsPath \ "name").format[String] and
      (JsPath \ "price").format[Double] and
      (JsPath \ "tags").format[List[String]]
    )(
    Product.apply,
    p => (p.id, p.name, p.price, p.tags)
  )
  
  val jsonStr = """{"id": 1, "name": "Laptop", "price": 999.99, "tags": ["tech", "work"]}"""
  
  println(jsonStr)

  val json: JsValue = Json.parse(jsonStr)

  json.validate[Product] match {
    case JsSuccess(product, _) =>

      val updatedProduct: Product = product.copy(price = product.price * 1.1)
      val updatedJson: JsValue = Json.toJson(updatedProduct)
      val updatedJsonStr: String = Json.prettyPrint(updatedJson)
      
      println()
      println(s"Новая строка:\n$updatedJsonStr\n")

    case JsError(errors) =>
      println("Ошибка валидации JSON")
  }

}