
@main
def main(): Unit = {

  println("Задание 1")
  object MySum {
    def MySum(a: List[Int]): Int = {
      a.foldLeft(0)((acc, x) => acc + x)
    }
  }
  println(MySum.MySum(List(1, 2, 3, 4))) // –> 10
  println(MySum.MySum(List(-2, 5, 0))) // –> 3

  println("Задание 2")
  object MyRange {
    def MyRange(n: Int, m: Int): List[Int] = {
      n match {
        case n if n > m => Nil
        case n if n == m => List(n)
        case n => n :: MyRange(n + 1, m)
      }
    }
  }

  println(MyRange.MyRange(1, 5)) // –> List(1, 2, 3, 4, 5)
  println(MyRange.MyRange(3, 3)) // –> List (3)
  println(MyRange.MyRange(5, 1)) // –> Nil
}

