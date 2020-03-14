import scala.util.control.Breaks._
object traveler extends App{
    /*
    val grph: Array[Array[Int]] = Array(Array(0, 10, 15, 20),
                                     Array(10, 0, 35, 25),
                                     Array(15, 35, 0, 30),
                                     Array(20, 25, 30, 0))
   */ 
    val grph: Array[Array[Int]] = Array(Array(0,7,0,2,15),Array(7,0,8,0,0),Array(0,8,0,2,1),Array(2,0,2,0,0))
  
  var obj = new TSP()
  //var grph = obj.getEdges()
  obj.printgrp(grph,grph.size)
  Init_fun()  
  def Init_fun(){
      val size: Int = grph.size
     val visited: Array[Boolean] = (0 until size map(_ => false)).toArray
     visited(0) = true //Visit start node
    
     var res: Int = Int.MaxValue // Distance : Infinity value to all the rest of the nodes
     
      res = obj.FindTSP(grph, visited, 0, size, 1, 0,res)
    println("The Minimum Solution is : "+res)
  }  
}

class TSP {

  def getEdges(): Array[Array[Int]] = { 

    println("Number of Vertices : ")
    var v = scala.io.StdIn.readInt()
    var g = Array.ofDim[Int](v,v)
    for(i<- 0 until v; j<- 0 until v){
      g(i)(j) = 0
    }
    println("Enter number of Edges : ")
    var e = scala.io.StdIn.readInt()
    for(i<- 0 until e){  
      println("From Node : ")
      var temp1 = scala.io.StdIn.readInt()       
      println("To Node   : ")
      var temp2 = scala.io.StdIn.readInt()
      println("Enter Weight :")
      var w = scala.io.StdIn.readInt
      g(temp2)(temp1) = w
      g(temp1)(temp2) = w
    }
    return g    
  }
  def printgrp(g: Array[Array[Int]],v: Int){
    for(i<- 0 until v){
      println(" ")
       for( j<- 0 until v){
          print(g(i)(j)+" " )
      }
    }
    println(" \n")
  }

  def FindTSP(g: Array[Array[Int]],visitlist: Array[Boolean],curr: Int, size: Int, count: Int,cost: Int,res: Int): Int = {
     var result: Int = res
     //println("deb : " + res)
    if (count == size && g(curr)(0) > 0) { // Check for corresponding elt to current with being a value>0
      result = Math.min(res, cost + g(curr)(0)) // get the min value till now for counter
      result
    }
    for (i <- 0 until size)
      if (visitlist(i) == false && g(curr)(i) > 0) { //if a not visited node is met with a valid value
        visitlist(i) = true
        result = FindTSP(g, visitlist, i, size, count + 1, cost + g(curr)(i),result) // recursive call for traversing all possiblities
        visitlist(i) = false
      }
    result
  }
}
