
object kruskal extends App{

    val matrix: Array[Array[Int]] = Array(Array(0, 7, 0, 5, 0,0,0),
                                      Array(7, 0, 8, 9, 14,0,0),
                                      Array(0, 8, 0, 0, 5,0,0),
                                      Array(5, 9, 0, 0, 15,6,0),
                                      Array(0, 14, 5, 15, 0,10,9),Array(0,0,0,6,10,0,11),Array(0,0,0,0,9,11,0))

    /*val matrix: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                      Array(1, 0, 1, 1, 1),
                                      Array(0, 1, 0, 0, 1),
                                      Array(1, 1, 0, 0, 1),
                                      Array(0, 1, 1, 1, 0))*/
   var obj = new kruss()
   obj calc(matrix)

}

class kruss{

def calc(matrix: Array[Array[Int]]) {   
  
    val size = matrix.size
    val parent: Array[Int] = Array.ofDim[Int](size) // implement disjoint sets
    var min: Int = 0
    var u: Int = 0
    var v: Int = 0
    var noOfEdges: Int = 1
    var total: Int = 0

    for (i <- 0.until(size)) {
      parent(i) = 0
      for (j <- 0.until(size)) {
       
        if (matrix(i)(j) == 0) {
          matrix(i)(j) = 999
        }
      }
    }

    while (noOfEdges < size) {
      min = 999
      for (i <- 0.until(size); j <- 0.until(size) if matrix(i)(j) < min) {
        min = matrix(i)(j)
        u = i
        v = j
      }
      
      while (parent(u) != 0) u = parent(u)//  Self parent
      while (parent(v) != 0) v = parent(v)//   ""    ""

      if (v != u) {
        { 
          noOfEdges += 1
          noOfEdges - 1 
        }

        println("Edge Found: " + u + "->" + v + " Min : " + min)
        total += min
        parent(v) = u
      }
      matrix(u)(v) = 999
      matrix(v)(u) = 999
    }
    println("The weight of the minimum spanning tree is " + total)
  }

}