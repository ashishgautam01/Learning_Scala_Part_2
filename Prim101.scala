import scala.util._
import scala.io._
import scala.collection.SortedMap
object primerMST {
   def main(args: Array[String]): Unit = {
    val t: P_MST = new P_MST()
    val graph: Array[Array[Int]] = Array(Array(0,1,0,2,3),
                                         Array(1,0,2,0,0),
                                         Array(0,2,0,3,1),
                                         Array(2,0,3,0,0),
                                         Array(3,0,1,0,0))
    t.primMST(graph)
  }
}
class P_MST {
  val V: Int = 5
  val max_value = java.lang.Integer.MAX_VALUE
 
  def primMST(graph: Array[Array[Int]]): Unit = {
    val parent: Array[Int] = Array.ofDim[Int](V)//This is to store The MST mde
    val key: Array[Int] = Array.ofDim[Int](V) // The key values for picking min weight edge
    val mstSet: Array[Boolean] = Array.ofDim[Boolean](V) //To check for vertices not yet visited
    for (i <- 0 until V) {
      key(i) = max_value
      mstSet(i) = false
    }
    key(0) = 0 //To make key as 0 for the source vertex
    parent(0) = -1 //Make the root as the first element
    for (count <- 0 until V - 1) { //Loop to check and update the key values to get min weight
      val u: Int = Key_check(key, mstSet) 
      mstSet(u) = true
      for (v <- 0 until V )
           if (graph(u)(v) != 0 && mstSet(v) == false && graph(u)(v) < key(v)) {
        parent(v) = u
        key(v) = graph(u)(v)
      }
    }
    printsol(graph,parent) // Print the edges in the MST and their weights
  }

  // Function to get the minimum Key value vertex each time that is not in mstSet
  def Key_check(key: Array[Int], mstSet: Array[Boolean]): Int = {
    var min: Int = max_value
    var curr_min: Int = -1

    for (v <- 0 until V)
     if (mstSet(v) == false && key(v) < min) {
      min = key(v)
      curr_min = v
    }
    curr_min //return the minimum key value
  }

  def printsol( graph: Array[Array[Int]],parent: Array[Int]): Unit = {

    println("Edge ->\tWeight")

    for (i <- 1 until V)
      println(parent(i) + " - " + i + "\t" + graph(i)(parent(i)))
  }

}
