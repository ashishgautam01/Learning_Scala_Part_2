import scala.collection.mutable.Stack
object cycle extends App{
  
  var o = new mat() 
  var res = o.getEdges()
  o.printgrp(res,res.size)  
}
class mat{
  def getEdges(): Array[Array[Int]] = { 

    println("Number of Vertices : ")
    var v = scala.io.StdIn.readInt()
    var g = Array.ofDim[Int](v,v)
    for(i<- 0 until v; j<- 0 until v){
      g(i)(j) = 0
    }
    println("Enter number of weighted Edges : ")
    var e = scala.io.StdIn.readInt()
    for(i<- 0 until e){  
      println("From Node : ")
      var temp1 = scala.io.StdIn.readInt()       
      println("To Node : ")
      var temp2 = scala.io.StdIn.readInt()
      println(" = ")
      var  x = scala.io.StdIn.readInt() 
      g(temp1)(temp2) = x
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
}