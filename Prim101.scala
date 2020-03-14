import scala.util._
import scala.collection.SortedMap

object primerMST extends App {
    /*
    val graph: Array[Array[Int]] = Array(Array(0,11,0,2,3),
                                         Array(1,0,2,0,0),
                                         Array(0,2,0,3,1),
                                         Array(2,0,3,0,0),
                                         Array(3,0,1,0,0))
    */
    val graph: Array[Array[Int]] = Array(Array(0, 7, 0, 5, 0,0,0),
                                      Array(7, 0, 8, 9, 14,0,0),
                                      Array(0, 8, 0, 0, 5,0,0),
                                      Array(5, 9, 0, 0, 15,6,0),
                                      Array(0, 14, 5, 15, 0,10,9),
                                      Array(0,0,0,6,10,0,11),
                                      Array(0,0,0,0,9,11,0))

    val t: P_MST = new P_MST(graph)
    t.primMST()
  
}

class P_MST(graph: Array[Array[Int]]) {

  val V: Int = graph.size
  val max = Integer.MAX_VALUE
 
  def primMST(): Unit = {
    val parent: Array[Int] = Array.ofDim[Int](V)//This is to store The MST mde
    val key: Array[Int] = Array.ofDim[Int](V) // The key values for picking min weight edge
    val visitlist: Array[Boolean] = Array.ofDim[Boolean](V) //To check for vertices not yet visited
    for (i <- 0 until V) {
      key(i) = max
      visitlist(i) = false
    }
    key(0) = 0 //To make key as 0 for the source vertex
    parent(0) = -1 //Make the root as the first element

    for (count <- 0 until V - 1) { //Loop to check and update the key values to get min weight
      val u: Int = Key_check(key, visitlist) 
      visitlist(u) = true
      for (v <- 0 until V )
           if (graph(u)(v) != 0 && visitlist(v) == false && graph(u)(v) < key(v)) {
        parent(v) = u
        key(v) = graph(u)(v)
      }
    }
    printsol(graph,parent) // Print the edges in the MST and their weights
  }

  // Function to get the minimum Key value vertex each time that is not in visitlist
  def Key_check(key: Array[Int], visitlist: Array[Boolean]): Int = {
    var min: Int = max
    var curr_min: Int = -1

    for (v <- 0 until V)
     if (visitlist(v) == false && key(v) < min) {
      min = key(v)
      curr_min = v
    }
    curr_min //return the minimum key value
  }

  def printsol( graph: Array[Array[Int]],parent: Array[Int]): Unit = {

    println("Edge ->\tWeight")

    for (i <- 1 until V)
      println(parent(i) + " - " + i + "\t" + graph(i)(parent(i)))
    
    println("Total weight : ")
    var sum = 0
    for(i<- 1 until V){
       sum +=graph(i)(parent(i))
    }
    println(sum)
  }

}
