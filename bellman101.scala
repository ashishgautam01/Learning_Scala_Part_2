import scala.collection.mutable.Map
import scala.collection.mutable.Stack

object Bellman {
  def main(args: Array[String]): Unit = {
    val V: Int = 5
    val E: Int = 8
    val graph: Array[Array[Int]] = Array(Array(0, 1, -1),
                                         Array(0, 2, 4),
                                         Array(1, 2, 3),
                                         Array(1, 3, 2),
                                         Array(1, 4, 2),
                                         Array(3, 2, 5),
                                         Array(3, 1, 1),
                                         Array(4, 3, -3))
    printgrp(graph,V)
    BellmanFord(graph, V, E, 0)
  }

  def BellmanFord(graph: Array[Array[Int]], V: Int, E: Int, src: Int): Unit = {
    val dis: Array[Int] = Array.ofDim[Int](V)
    for (i <- 0 until V) dis(i) = java.lang.Integer.MAX_VALUE
    dis(src) = 0
    for (i <- 0 until V - 1; j <- 0 until E if dis(graph(j)(0)) + graph(j)(2) < dis(graph(j)(1)))
      dis(graph(j)(1)) = dis(graph(j)(0)) + graph(j)(2)
    for (i <- 0 until E) {
      val x: Int = graph(i)(0)
      val y: Int = graph(i)(1)
      val weight: Int = graph(i)(2)
      if (dis(x) != java.lang.Integer.MAX_VALUE && dis(x) + weight < dis(y))
        println("Graph contains negative weight cycle")
    }
    println("Vertex Distance from Source")
    for (i <- 0 until V) println(i + "\t\t" + dis(i))
  }

 def printgrp(g: Array[Array[Int]],V: Int){
  println("From    To    weight")
    for(i<- 0 until V){
      println(" ")
       for( j<- 0 until 3){
          print(g(i)(j)+"\t" )
      }
    }
    println(" \n")
  }

}
