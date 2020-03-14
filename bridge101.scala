import scala.collection.mutable.Stack
import scala.io.StdIn.readInt
import scala.collection.mutable.ArrayBuffer
import  scala.io.StdIn.readLine
import scala.collection.mutable._
import scala.util.control.Breaks._

object bridge extends App{
	
	var matt = new mat()
	var g = matt.getEdges()
	var st = Stack[Int]()
	var visited: Array[Boolean]=(0 until g.size map(_ => false)).toArray
	
	matt.DFS(g,visited,0,st)	
	println(st.reverse)
	
	var bri = new bridge()
	var result =bri.calc(g)
	bri.show_res(result)	
}

class bridge{

	def show_res(s: Stack[(Int,Int)]){
		var st =Stack[(Int,Int)]()
		while(!s.isEmpty){
			var i=s.pop()

			if(s.contains((i._2,i._1))){
				println("")
			}
			else	
				st.push(i)
		}
		println("Brigdes conclude :")
		st.foreach(println)
	}

	def calc(g: Array[Array[Int]]):Stack[(Int,Int)] ={
		
		var fetch = new mat()
		var b_res = Stack[(Int,Int)]()
		var g1 = g
		for(i<- 0 until g1.size ; j<- 0 until g1.size){
			if(g1(i)(j)==1){
				var sti = Stack[Int]()				
				var visit: Array[Boolean] = (0 until g.size map(_ => false)).toArray
				g1(i)(j)=0 ; g1(j)(i)=0
				//fetch.printgrp(g1,g1.size)
				fetch.DFS(g1,visit,0,sti)
				g1(i)(j) = 1; g1(j)(i)=1
				if(sti.distinct.size != g.size){
						b_res.push((i,j))
				}	
			}
		}
		b_res
	}
}

class mat{

  def DFS (g: => Array[Array[Int]],visited: => Array[Boolean],start: Int,st: => Stack[Int]) {
  	visited(start) = true
  	st.push(start)
  	for(j<- 0 until g.size){
  		if(!visited(j) && g(start)(j)==1){
  			DFS(g,visited,j,st)
  		}
  	}
  }

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
      g(temp2)(temp1) = 1
      g(temp1)(temp2) = 1
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