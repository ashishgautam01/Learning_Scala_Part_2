import scala.collection.mutable.Stack
object cycle extends App{
  println("Number of Vertices : ")
  var num_ver = scala.io.StdIn.readInt()
  var grph = Array.ofDim[Int](num_ver,num_ver)
  var o = new util() 
  var res = o.getEdges(grph,num_ver)
  o.printgrp(res,num_ver)  
}
class util{
  def getEdges(g: Array[Array[Int]],v: Int): Array[Array[Int]] = {    
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
          print(g(i)(j) )
      }
    }
    println(" \n")
  }
}