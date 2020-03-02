
object HamiltonianCycle {

  def main(args: Array[String]): Unit = {
    val ham = new Hamm()
  
    val graph1: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 1),
                                          Array(0, 1, 1, 1, 0))

    ham.hamCycle(graph1)
  
    val graph2: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 0),
                                          Array(0, 1, 1, 0, 0))

    ham.hamCycle(graph2)
  }

}

class Hamm {

  val V: Int = 5

  //var path: Int = 0

  def isSafe(v: Int,graph: Array[Array[Int]],path: Array[Int],pos: Int): Boolean = {
    
    if (graph(path(pos - 1))(v) == 0) false
    
    for (i <- 0 until pos if path(i) == v) false
    
    true
  }

  def Loop(graph: Array[Array[Int]],path: Array[Int],pos: Int): Boolean = {

    if (pos == V) {
      if (graph(path(pos - 1))(path(0)) == 1) true else false
    }

    for (x <- 1 until V)
      if (isSafe(x, graph, path, pos)) {
          path(pos) = x     
      if (Loop(graph, path, pos + 1) == true) true
          path(pos) = -1
    }
    false
  }

  def hamCycle(graph: Array[Array[Int]]): Int = {
    var path = Array.ofDim[Int](V)
    for (i <- 0 until V) 
      path(i) = -1 //set path as itself
   
      path(0) = 0 // start path visited
   
    if (Loop(graph, path, 1) == false) { // check if a Ham cycle exists
      println("\nSolution does not exist")
      0
    }
    show(path)
    1
  }

  def show(path: Array[Int]): Unit = {
    println("Solution Exists: Following is one Hamiltonian Cycle")

    for (i <- 0 until V) 
      println(" " + path(i) + " ")

    println(" " + path(0) + " ")
  }

}








