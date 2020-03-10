import java.util._
import scala.collection.mutable.Stack

object tarjan extends App{

    val NUM_NODES: Int = 10
    val adjMatrix: Array[Array[Boolean]] = Array.ofDim[Boolean](NUM_NODES, NUM_NODES)
    adjMatrix(0)(1) = true
    adjMatrix(1)(2) = true
    adjMatrix(2)(0) = true
    adjMatrix(5)(4) = true
    adjMatrix(5)(6) = true
    adjMatrix(3)(5) = true
    adjMatrix(4)(3) = true
    adjMatrix(4)(5) = true
    adjMatrix(6)(4) = true
    adjMatrix(7)(8) = true
    adjMatrix(8)(7) = true
    adjMatrix(1)(5) = true
    adjMatrix(1)(7) = true
    adjMatrix(2)(7) = true
    adjMatrix(6)(8) = true
    adjMatrix(9)(8) = true
    adjMatrix(9)(4) = true

    val obj: Tarjan = new Tarjan(adjMatrix)
    println("SSC count: " + obj.countStronglyConnectedComponents())
    println("Strong connected components:\n" + Arrays.toString(obj.getStronglyConnectedComponents))
  }

  class Tarjan(private var adj: Array[Array[Boolean]]) {

    var n: Int = adj.length
    var pre: Int = _
    var count: Int = 0
    var id = new Array[Int](n)
    var low = new Array[Int](n)
    var marked = new Array[Boolean](n)
    var stack = Stack[Int]()

    for (u <- 0 until n if !marked(u)) dfs(u)

    private def dfs(u: Int): Unit = {
      marked(u) = true
      low(u) = { pre += 1; pre - 1 }
      var min: Int = low(u)
      stack.push(u)
      
      for (v <- 0 until n if adj(u)(v)) {
        if (!marked(v))
           dfs(v)
        if (low(v) < min) 
           min = low(v)
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
      
      {
       count += 1
       count - 1 
     }
    }

    def getStronglyConnectedComponents(): Array[Int] = id.clone()

    def countStronglyConnectedComponents(): Int = count

  }

