import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set

object DFS101 extends App{

	//var o = new DFS_cls[Int]
	var x  = Map(1-> Set(2,5),
				2-> Set(1,3),
				3-> Set(2,4,6),
				4-> Set(3,8),
				5-> Set(1),
				6-> Set(3,7),
				7-> Set(6),
				8-> Set(4))

	val st = new Stack[Int]()
	val size = x.size

	case class Vertex(label: String) 
	case class edge(from: Vertex, to: Vertex) 

	for((i,j)<- x) println("The Graph is as :"+i+" -> " + j)
  	var vList = Set[Int]()
  	
  	//DFS call
	var ls = dfs(x,1,vList)

	var count: Int = 0

	
	def dfs(m: Map[Int,Set[Int]], start: Int,visitlist: Set[Int]): Unit = {
		
		var newstart: Int = start
		//To visit every key
		visit(newstart,visitlist,st)

		def visit(curr: Int,visitlist: Set[Int],st: Stack[Int]){
			visitlist += curr
			println("Visited : "+ curr)
			for((x,lst)<- m){
				for(i<- lst){
					if(!visitlist.contains(i)){
						visit(i,visitlist,st)
					}
				}
			}
		}

		} 
}