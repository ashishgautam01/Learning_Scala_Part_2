
import scala.util._
import scala.io._

object dijkstra {

  def main(args: Array[String]): Unit = {

    val V: Int = 5
    val graph: Array[Array[Int]] = Array(
      Array(0, 4, 0,8,0),
      Array(4,0,3,0,0),
      Array(0,3,0,4,0),
      Array(8,0,4,0,7),
      Array(0,0,0,7,0)
    )

    val t: ShortestPath = new ShortestPath()
    t.dijkstra(graph, 0)
  }

}

class ShortestPath {
	val V: Int = 5
	var MAX_VALUE = 100000

    def minDistance(dist: Array[Int], sptSet: Array[Boolean]): Int = {
   		var min: Int = MAX_VALUE
   		var min_index: Int = 0

    	for (v <- 0 until V) 
    		if (sptSet(v) == false && dist(v) <= min) {
      			min = dist(v)
     			min_index = v
    		}

    	min_index
  	}

 	 def printSolution(dist: Array[Int]): Unit = {
 	   println("Vertex \t\t Distance from Source")
 	   for (i <- 0 until V) println(i + " \t\t " + dist(i))
 	 }

  def dijkstra(graph: Array[Array[Int]], src: Int): Unit = {

    val dist: Array[Int] = Array.ofDim[Int](V)
    val sptSet: Array[Boolean] = Array.ofDim[Boolean](V) //false if not included in final result

    for (i <- 0 until V) {
      dist(i) = MAX_VALUE
      sptSet(i) = false
    }

    dist(src) = 0

    for (count <- 0 until V - 1) {

      val u: Int = minDistance(dist, sptSet)
      sptSet(u) = true
      
      for (v <- 0 until V)
           if (!sptSet(v) && graph(u)(v) != 0 && dist(u) != MAX_VALUE &&
             dist(u) + graph(u)(v) < dist(v)) dist(v) = dist(u) + graph(u)(v)
    }
    printSolution(dist) 	 	 	
  }

}