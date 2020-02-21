import scala.util._

object GFG {

  var V: Int = 5

  var parent: Array[Int] = new Array[Int](V)

  var INFY: Int = java.lang.Integer.MAX_VALUE

// this is to Find set of vertex i
  def find(i: Int): Int = {
    var x = i
    while (parent(i) != i) x = parent(i)
    x
  }

// we union tye set here.
  def union1(i: Int, j: Int): Unit = {
    val a: Int = find(i)
    val b: Int = find(j)
    parent(a) = b
  }

// Finding MST using Kruskal's algorithm
  def kruskalMST(cost: Array[Array[Int]]): Unit = {
// Cost of min MST.
    var mincost: Int = 0
    for (i <- 0 until V) parent(i) = i
// Include minimum weight edges one by one
    var edge_count: Int = 0
    while (edge_count < V - 1) {
      var min: Int = INFY
      var a: Int = -1
      var b: Int = -1

      for (i <- 0 until V; j <- 0 until V
           if find(i) != find(j) && cost(i)(j) < min) {
        min = cost(i)(j)
        a = i
        b = j
      }
      union1(a, b)
      println(s"Edge "+ { edge_count += 1; edge_count - 1 } +":("+  a +", "+b+") cost: "+ min)
      mincost += min
    }
    println("\n Minimum cost= \n"+ mincost)
  }

  def main(args: Array[String]){
 

    val cost: Array[Array[Int]] = Array(Array(INFY, 2, INFY, 6, INFY),
                                        Array(2, INFY, 3, 8, 5),
                                        Array(INFY, 3, INFY, INFY, 7),
                                        Array(6, 8, INFY, INFY, 9),
                                        Array(INFY, 5, 7, 9, INFY))
    kruskalMST(cost)
  }

}