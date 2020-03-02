import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap
object DFS101 extends App{	
	var x  = SortedMap(1-> Set(2,5),  //Graph represented as a Map
				2-> Set(1,3),
				3-> Set(2,4,6),
				4-> Set(3,8),
				5-> Set(1),
				6-> Set(3,7),
				7-> Set(6),
				8-> Set(4))	
	//var x = SortedMap(1-> Set(2,5),2-> Set(1,3),3->Set(2,4),4->Set(3,5),5->Set(4,1))
	val size = x.size
	val st = new Stack[Int]()	
	for((a,b)<- x ) println(s"Vertex $a -> $b") 	
  	var vList = Set[Int]()
  	  	
  	//DFS call
	var ls = dfs(x,1,vList,st)		
	def dfs(m: SortedMap[Int,Set[Int]], start: Int,visitlist: Set[Int],stin: Stack[Int]): Unit = {		
		var newstart: Int = start //For the first start
		//To visit every key
		visit(newstart,visitlist,stin)
		def visit(curr: Int,visitlist: Set[Int],stinner: Stack[Int]){
			visitlist += curr
			stinner.push(curr)
			println("Visited Vertex : "+ st.pop)			
			for((lst)<- m.get(curr); i<- lst){
				if(!visitlist.contains(i)){						
						visit(i,visitlist,st)
				}				
			}
		}
	} 
}