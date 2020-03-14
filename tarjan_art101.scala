import java.util._
import scala.collection.mutable.Stack

object tarjan extends App{

    println("Enter Number of Vertices :")
    val NUM_NODES: Int = scala.io.StdIn.readInt
    val arr: Array[Array[Boolean]] = Array.ofDim[Boolean](NUM_NODES, NUM_NODES)
    println("Enter Number of Edges :")
    var e = scala.io.StdIn.readInt
    for(i<- 0 until e){
      
      print("# " )
       var x = scala.io.StdIn.readInt 
       print( " -> " )
        var y = scala.io.StdIn.readInt
      arr(x)(y) = true
    }
    val obj: Tarjan = new Tarjan(arr)
    println("SSC count: " + obj.countStronglyConnectedComponents())
    println("Strong connected components:\n" + Arrays.toString(obj.getStronglyConnectedComponents))
  }

  class Tarjan(adj: Array[Array[Boolean]]) {

    var n: Int = adj.length
    var pre: Int = 0
    var count: Int = 0
    var id = new Array[Int](n)
    var low = new Array[Int](n)
    var marked = new Array[Boolean](n)
    var stack = Stack[Int]()

    for (u <- 0 until n if !marked(u)) 
      dfs(u)

    def dfs(u: Int): Unit = {
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

