import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap

object DFS101 extends App{	
	/*var x  = Map(0->Array(1),1-> Array(2,5),  //Graph represented as a Map
				2-> Array(1,3),
				3-> Array(2,4,6),
				4-> Array(3,8),
				5-> Array(1),
				6-> Array(3,7),
				7-> Array(6),
				8-> Array(4))*/	
	var x = Map(0->Array(1),1->Array(2,0,1),2->Array(1,2))
	var obj = new DFS(x,0)
	obj.dfs()


}
class DFS(m: Map[Int,Array[Int]],start: Int) {		
	
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