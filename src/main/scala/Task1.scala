object Task1 extends App {
  def main(): Unit = {

    def fibonacci: LazyList[BigInt] = {
      LazyList.iterate((BigInt(0), BigInt(1))) { case (a, b) => (b, a + b) }
        .map(_._1)
    }

    val result: Vector[BigInt] = fibonacci
      .filter(_ % 3 == 0)
      .take(10)
      .toVector

    println(result.mkString(", "))
  }
  main()
}