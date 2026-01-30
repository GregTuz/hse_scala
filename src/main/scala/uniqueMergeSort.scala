object UniqueMergeSort extends App {

  def mergeSort(vector: Vector[Int]): Vector[Int] = {
    if (vector.length <= 1) {
      vector
    } else {
      val middle = vector.length / 2
      val (left, right) = vector.splitAt(middle)

      merge(mergeSort(left), mergeSort(right))
    }
  }

  private def merge(left: Vector[Int], right: Vector[Int]): Vector[Int] = {
    if (left.isEmpty) right
    else if (right.isEmpty) left
    else {
      val lh = left.head
      val rh = right.head

      if (lh < rh) {
        lh +: merge(left.tail, right)
      } else if (lh > rh) {
        rh +: merge(left, right.tail)
      } else {
        lh +: merge(left.tail, right.tail)
      }
    }
  }
}
