
object Main extends App{

  var P: Array[Array[Int]] = _

  val N: Int = 4

    val M: Array[Array[Int]] = Array(Array(0, 5, 999, 999),
                                     Array(50, 0, 15, 5),
                                     Array(30, 999, 0, 15),
                                     Array(15, 999, 5, 0))
    P = Array.ofDim[Int](N, N)
    var obj = new floyd(P,N)
    println("Matrix to find the shortest path of.")
    printMatrix(M)
    println("Shortest Path Matrix.")
    printMatrix(obj.FloydAlgo(M))
    println("Path Matrix")
    printMatrix(P)

  def printMatrix(Matrix: Array[Array[Int]]): Unit = {
    print("\n\t")
    for (j <- 0 until N) {
      print(j + "\t")
    }
    println()
    for (j <- 0.until(35)) {
      print("-")
    }
    println()
    for (i <- 0 until N) {
      print(i + " |\t")
      for (j <- 0 until N) {
        print(Matrix(i)(j))
        print("\t")
      }
      print("\n")
    }
    println("\n")
  }
}

class floyd(P: Array[Array[Int]],N: Int) {
  
  def FloydAlgo(M: Array[Array[Int]]): Array[Array[Int]] = {
    for (k <- 0 until N; i <- 0 until N; j <- 0 until N if M(i)(k) + M(k)(j) < M(i)(j)) {
      M(i)(j) = M(i)(k) + M(k)(j)
      P(i)(j) = k
    }
    M
  }

  def min(i: Int, j: Int): Int = {
    if (i > j) {
      j
    }
    i
  }

  

}
