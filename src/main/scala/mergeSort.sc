object MergeSort extends App {

  def mergeSort(vector: Vector[Int]): Vector[Int] = {
    if (vector.length <= 1) {
      vector
    } else {
      val middle = vector.length / 2
      val (left, right) = vector.splitAt(middle)

      merge(mergeSort(left), mergeSort(right))
    }
  }

  def merge(left: Vector[Int], right: Vector[Int]): Vector[Int] = {
    if (left.isEmpty) right
    else if (right.isEmpty) left
    else if (left.head <= right.head) {
      left.head +: merge(left.tail, right)
    } else {
      right.head +: merge(left, right.tail)
    }
  }
}


MergeSort.mergeSort(Vector())
MergeSort.mergeSort(Vector(1))
MergeSort.mergeSort(Vector(3, 2, 4, 1))
