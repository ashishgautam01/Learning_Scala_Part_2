
class Solution {

  private var timestamp: Int = _

  def criticalConnections(n: Int,connections: List[List[Integer]]): List[List[Integer]] = {
    

    val graph: Map[Integer, List[Integer]] = new HashMap[Integer, List[Integer]]()
    for (i <- 0 until n) graph.put(i, new ArrayList[Integer]())
    for (edge <- connections) {
      val v0: Int = edge.get(0)
      val v1: Int = edge.get(1)
      graph.get(v0).add(v1)
      graph.get(v1).add(v0)
    }
    val parent: Array[Int] = Array.ofDim[Int](n)
    val low: Array[Int] = Array.ofDim[Int](n)
    val disc: Array[Int] = Array.ofDim[Int](n)
    for (i <- 0 until n) parent(i) = i
    val visited: Array[Boolean] = Array.ofDim[Boolean](n)
    val res: List[List[Integer]] = new ArrayList[List[Integer]]()
    this.timestamp = 0
    DFS(0, graph, visited, parent, low, disc, res)
    res
  }

  private def DFS(i: Int,graph: Map[Integer, List[Integer]],visited: Array[Boolean],parent: Array[Int],low: Array[Int],disc: Array[Int],res: List[List[Integer]]): Unit = {
    visited(i) = true
    low(i) = timestamp
    disc(i) = timestamp { timestamp += 1; timestamp - 1 }
    for (j <- graph.get(i)) {
      if (!visited(j)) {
        parent(j) = i
        DFS(j, graph, visited, parent, low, disc, res)
        low(i) = Math.min(low(j), low(i))
        if (disc(i) < low(j)) {
          val sol: List[Integer] = new ArrayList[Integer]()
          sol.add(i)
          sol.add(j)
          res.add(sol)
        }
      } else {
        if (j != parent(i)) {
          low(i) = Math.min(low(i), disc(j))
        }
      }
    }
  }

}
