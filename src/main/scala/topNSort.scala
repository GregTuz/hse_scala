object TopNSort extends App {

  def topN(vector: Vector[Int], n: Int): Vector[Int] = {
    if (n <= 0) Vector.empty
    else {
      var buffer = Vector.empty[Int]
      for (x <- vector) {
        val withNew = buffer :+ x
        buffer = withNew.sorted.take(n)
      }
      buffer
    }
  }
}
