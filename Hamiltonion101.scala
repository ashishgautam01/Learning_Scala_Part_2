
object kruskal {

  def main(args: Array[String]): Unit = {
   
  val matrix: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 1),
                                          Array(0, 1, 1, 1, 0))
   
    val parent: Array[Int] = Array.ofDim[Int](5)
    var min: Int = 0
    var u: Int = 0
    var v: Int = 0
    var noOfEdges: Int = 1
    var total: Int = 0
    for (i <- 0.until(5)) {
      parent(i) = 0
      for (j <- 0.until(5)) {
       
        if (matrix(i)(j) == 0) {
          matrix(i)(j) = 999
        }
      }
    }
    while (noOfEdges < 5) {
      min = 999
      for (i <- 0.until(5); j <- 0.until(5) if matrix(i)(j) < min) {
        min = matrix(i)(j)
        u = i
        v = j
      }
      while (parent(u) != 0) u = parent(u)
      while (parent(v) != 0) v = parent(v)
      if (v != u) {
        { noOfEdges += 1; noOfEdges - 1 }
        println("Edge Found: " + u + "->" + v + " Min : " + min)
        total += min
        parent(v) = u
      }
      matrix(u)(v) = 999
      matrix(v)(u) = 999
    }
    println("The weight of the minimum spanning tree is " + total)
  }

}
