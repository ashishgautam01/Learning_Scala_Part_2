
import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap

object HAM101 extends App{  
  var x  = Map(0->Array(1),1-> Array(2,5),  //Graph represented as a Map
        2-> Array(1,3),
        3-> Array(2,4,6),
        4-> Array(3,5,8),
        5-> Array(1,6),
        6-> Array(3,7),
        7-> Array(6,8),
        8-> Array(4,0)) 
  //var x = Map(0->Array(1),1->Array(2,0,1),2->Array(1,2))
  var obj = new HAM(x,0)
  obj.dfs()


}
class HAM(m: Map[Int,Array[Int]],start: Int) {    
  
  def dfs(){
    var size = m.size
    var visitlist: Array[Boolean] =(0 until size map(_ => false)).toArray
    visit(start,visitlist)
  }

  def visit(curr: Int,visitlist: Array[Boolean]){
    
    visitlist(curr) = true
    println("Visited : " + curr )     
      
    for((lst)<- m.get(curr); i<- lst){
      if(visitlist(i) != true){           
        visit(i,visitlist)
      }else {

        cycle_check(i,visitlist)
      }       
    }     
  } 

  def cycle_check(i: Int, visitlist: Array[Boolean]){
    
    if(start == i && visitlist.size == m.size) {
      println("Hamiltonian Cycle Found.")
    } 
  }
}
/*
object HamiltonianCycle {

  def main(args: Array[String]): Unit = {
    val hamiltonian: HamiltonianCycle = new HamiltonianCycle()
   
    val graph1: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 1),
                                          Array(0, 1, 1, 1, 0))

    hamiltonian.hamCycle(graph1)
  }

class HamiltonianCycle {

  val V: Int = 5

  var path = Array[Int]() 
    def isSafe(v: Int,graph: Array[Array[Int]],path: Array[Int],pos: Int): Boolean = {
    if (graph(path(pos - 1))(v) == 0) false
    for (i <- 0 until pos if path(i) == v) false
    true
  }
  def hamCycleUtil(graph: Array[Array[Int]],path: Array[Int],pos: Int): Boolean = {
    if (pos == V) {
      if (graph(path(pos - 1))(path(0)) == 1) true else false
    }
    for (v <- 1 until V if isSafe(v, graph, path, pos)) {
      path(pos) = v
      
      if (hamCycleUtil(graph, path, pos + 1) == true) true
     
      path(pos) = -1
    }
    false
  }
  def hamCycle(graph: Array[Array[Int]]): Int = {
    var path = Array.ofDim[Int](V)
    for (i <- 0 until V) path(i) = -1
    path(0) = 0
    if (hamCycleUtil(graph, path, 1) == false) {
      println("Solution does not exist")
      0
    }
    printSolution(path)
    1
  }
  def printSolution(path: Array[Int]): Unit = {
    println("Solution Exists: Following is one Hamiltonian Cycle")
    for (i <- 0 until V) println(" " + path(i) + " ")

    println(" " + path(0) + " ")
  }

}
*/