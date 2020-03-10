import java.util._

object TarjanAdjacencyMatrix {

  def main(args: Array[String]): Unit = {
    val NUM_NODES: Int = 10
    val adjMatrix: Array[Array[Boolean]] =
      Array.ofDim[Boolean](NUM_NODES, NUM_NODES)
// SCC 1 with nodes 0,1,2
    adjMatrix(0)(1) = true
    adjMatrix(1)(2) = true
    adjMatrix(2)(0) = true
// SCC 2 with nodes 3,4,5,6
    adjMatrix(5)(4) = true
    adjMatrix(5)(6) = true
    adjMatrix(3)(5) = true
    adjMatrix(4)(3) = true
    adjMatrix(4)(5) = true
    adjMatrix(6)(4) = true
// SCC 3 with nodes 7,8
    adjMatrix(7)(8) = true
    adjMatrix(8)(7) = true
// Add a few more edges to make things interesting
    adjMatrix(1)(5) = true
    adjMatrix(1)(7) = true
    adjMatrix(2)(7) = true
    adjMatrix(6)(8) = true
    adjMatrix(9)(8) = true
    adjMatrix(9)(4) = true
    val sccs: Tarjan = new Tarjan(adjMatrix)
    println(
      "Strong connected component count: " + sccs
        .countStronglyConnectedComponents())
    println(
      "Strong connected components:\n" +
        Arrays.toString(sccs.getStronglyConnectedComponents))
  }
// As an example we create a graph with four strongly connected components
// SCC 4 is node 9 all alone by itself
// Output:
// Strong connected component count: 4
// Strong connected components:
// [2, 2, 2, 1, 1, 1, 1, 0, 0, 3]
// As an example we create a graph with four strongly connected components
// SCC 4 is node 9 all alone by itself
// Output:
// Strong connected component count: 4
// Strong connected components:
// [2, 2, 2, 1, 1, 1, 1, 0, 0, 3]

  class Tarjan // Tarjan input requires an NxN adjacency matrix
  (private var adj: Array[Array[Boolean]]) {

    private var n: Int = adj.length

    private var pre: Int = _

    private var count: Int = 0

    private var id: Array[Int] = new Array[Int](n)

    private var low: Array[Int] = new Array[Int](n)

    private var marked: Array[Boolean] = new Array[Boolean](n)

    private var stack: Stack[Integer] = new Stack()

    for (u <- 0 until n if !marked(u)) dfs(u)

    private def dfs(u: Int): Unit = {
      marked(u) = true
      low(u) = { pre += 1; pre - 1 }
      var min: Int = low(u)
      stack.push(u)
      for (v <- 0 until n if adj(u)(v)) {
        if (!marked(v)) dfs(v)
        if (low(v) < min) min = low(v)
      }
      if (min < low(u)) {
        low(u) = min
        return
      }
      var v: Int = 0
      do {
        v = stack.pop()
        id(v) = count
        low(v) = n
      } while (v != u);
      { count += 1; count - 1 }
    }

// If id[i] == id[j] then nodes i and j are part of the same strongly connected component.
    def getStronglyConnectedComponents(): Array[Int] = id.clone()

// Returns the number of strongly connected components in this graph
    def countStronglyConnectedComponents(): Int = count

  }

}