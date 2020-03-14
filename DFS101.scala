import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap

object DFS101 extends App{		
	var G = new Graph()
	var x = G.getMap()
	println("Enter Start vertex :")
	var start = scala.io.StdIn.readInt
	var obj = new DFS(x,start)
	obj.dfs()
}
class DFS(m: Map[Int,Array[_ <: Int]],start: Int) {		
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
			}else System.exit(0)				
		}			
	}	 
}
class Graph {
	def getMap(): Map[Int,Array[_ <: Int]] = {
		var g = Map[Int,Array[_ <: Int]]()
		println("Enter number of Vertices : " )
		var v = readInt()		
		for(i<- 0 until v){
			print("From -> ")
		def getar(): Array[_ <: Int] ={
			println("Number of connections :  ")
			var con = readInt
			var arr = Array[Int]()
			for(i<- 0 until con){
				var temp = readInt
				arr = arr :+ temp
			}
			arr
		}			
		g += (readInt -> getar() )	 
	  }
	  for((i,y)<- g){		
			println(i + " -> " + y.toList)		
	}
	  g
	}
}