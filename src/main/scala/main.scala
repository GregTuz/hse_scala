
@main
def main(): Unit = {

  println("Merge sort")
  println(MergeSort.mergeSort(Vector()))
  println(MergeSort.mergeSort(Vector(1)))
  println(MergeSort.mergeSort(Vector(3, 2, 4, 1)))
  println("")

  println("Top n sort")
  println(TopNSort.topN(Vector(5, 1, 3, 2, 1, 4), 3))
  println(TopNSort.topN(Vector(10, 20, 30), 3))
  println(TopNSort.topN(Vector(), 123))
  println(TopNSort.topN(Vector(5, 4, 3, 2, 1), 1))
  println("")

  println("Unique merge sort")
  println(UniqueMergeSort.mergeSort(Vector()))
  println(UniqueMergeSort.mergeSort(Vector(1, 1, 41, 21)))
  println(UniqueMergeSort.mergeSort(Vector(3, 2, 4, 1)))
  println("")
}

