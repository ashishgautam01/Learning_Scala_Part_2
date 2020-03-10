object Graph extends App {

    val g1: Graph = new Graph(4)
    g1.addEdge(0, 1)
    g1.addEdge(0, 2)
    g1.addEdge(1, 2)
    g1.addEdge(2, 3)
    g1.printEulerTour()
   

}

class Graph (numOfVertices: Int) {

  var vertices: Int = numOfVertices

  var adj = Array[Array[Int]]()

  initGraph()

  def initGraph(): Unit = {
    adj = Array[Array[Int]]()
    for (i <- 0 until vertices) {
      adj(i) = Array[Int]()
    }
  }

  def addEdge(u: Int, v: Int): Unit = {
    adj(u)(v) = 0
    adj(v)(u) = 0
  }
  def removeEdge(u: Int, v: Int): Unit = {
    adj(u)(v) = 0
    adj(v)(u) = 0
  }
  def printEulerTour(): Unit = {
    var u: Int = 0
    for (i <- 0 until vertices if adj(i).size % 2 == 1) {
      u = i
    }
    printEulerUtil(u)
    println()
  }

  def printEulerUtil(u: Int): Unit = {
    for (i <- 0 until adj(u).size) {
      val v: Int = adj(u)(i)
      if (isValidNextEdge(u, v)) {
        print(u + "-" + v + " ")
        removeEdge(u, v)
        printEulerUtil(v)
      }
    }
  }

  def isValidNextEdge(u: Int,v: Int): Boolean = {

    if (adj(u).size == 1) {
      true
    }
    var isVisited: Array[Boolean] = Array.ofDim[Boolean](this.vertices)
    val count1: Int = dfsCount(u, isVisited)
    removeEdge(u, v)
    isVisited = Array.ofDim[Boolean](this.vertices)
    val count2: Int = dfsCount(u, isVisited)

    addEdge(u, v)
    if ((count1 > count2)) false 
    else true
  }

  def dfsCount(v: Int, isVisited: Array[Boolean]): Int = {

    isVisited(v) = true
    var count: Int = 1
    for (adj <- adj(v) if !isVisited(adj)) {
      count = count + dfsCount(adj, isVisited)
    }
    count
  }

}
