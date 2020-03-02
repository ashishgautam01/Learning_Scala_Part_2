import scala.util._
import scala.io._

// BellmanFord is same as dijkstra but better as it also handles -ve values weights

class Graph(var V: Int, var e: Int) {

 class Edge(src: Int,dest:Int,weight: Int){
  this.src = src
  this.dest = dest
  this.weight = weight
 }

  var edge = new Edge()
  for (i <- 0 until e) 
    edge(i) = new Edge()

// function also detects negative weight cycle
  def BellmanFord(graph: Graph, src: Int): Unit = {
    val V: Int = graph.V
    val E: Int = graph.e
    val dist: Array[Int] = Array.ofDim[Int](V)

    for (i <- 0 until V) dist(i) = java.lang.Integer.MAX_VALUE
    dist(src) = 0

    for (i <- 1 until V; j <- 0 until E) {
      val u: Int = graph.edge(j).src
      val v: Int = graph.edge(j).dest
      val weight: Int = graph.edge(j).weight
      if (dist(u) != java.lang.Integer.MAX_VALUE && dist(u) + weight < dist(v))
        dist(v) = dist(u) + weight
    }
    for (j <- 0 until E) {
      val u: Int = graph.edge(j).src
      val v: Int = graph.edge(j).dest
      val weight: Int = graph.edge(j).weight

      if (dist(u) != java.lang.Integer.MAX_VALUE && dist(u) + weight < dist(v)) {
        println("Graph contains negative weight cycle")
        return
      }
    }
    printArr(dist, V)
  }

// function to print the solution found
  def printArr(dist: Array[Int], V: Int): Unit = {
    println("Vertex Distance from Source")
    for (i <- 0 until V) println(i + "\t\t" + dist(i))
  }

}
object Graph extends App{

    val V: Int = 5

    val E: Int = 8
    val graph: Graph = new Graph(V, E)

    graph.edge(0).src = 0
    graph.edge(0).dest = 1
    graph.edge(0).weight = -1

    graph.edge(1).src = 0
    graph.edge(1).dest = 2
    graph.edge(1).weight = 4

    graph.edge(2).src = 1
    graph.edge(2).dest = 2
    graph.edge(2).weight = 3

    graph.edge(3).src = 1
    graph.edge(3).dest = 3
    graph.edge(3).weight = 2

    graph.edge(4).src = 1
    graph.edge(4).dest = 4
    graph.edge(4).weight = 2

    graph.edge(5).src = 3
    graph.edge(5).dest = 2
    graph.edge(5).weight = 5

    graph.edge(6).src = 3
    graph.edge(6).dest = 1
    graph.edge(6).weight = 1

    graph.edge(7).src = 4
    graph.edge(7).dest = 3
    graph.edge(7).weight = -3

    graph.BellmanFord(graph, 0)
  

}
