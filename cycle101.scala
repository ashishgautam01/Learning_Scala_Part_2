import scala.util.control.Breaks._
import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap

object cycle extends App{	
	var x: Map[Int,Array[Int]] = Map(1-> Array(2,5),2-> Array(3),3->Array(4),4->Array(3,5),5->Array(4,1))	 	
  	var obj = new cycle_det()
  	obj.traverse(x,1)	
}
class cycle_det{
		
  	def traverse(m: Map[Int,Array[Int]], start: Int): Unit = {		
		val size = m.size
		val st = new Stack[Int]()
		var visitlist: Array[Boolean]  = (0 until size map(_ => false)).toArray
		//For the first start
		println("DFS Traversal is as follows : \n") 
		//To visit every key
		visit(start,visitlist,st)		
		def visit(curr: Int,visitlist: Array[Boolean],stinner: Stack[Int]){		
			visitlist(curr) = true
			stinner.push(curr)
			println("Visited : " + st.top )			
			for((lst)<- m.get(curr); i<- lst){
				if(visitlist(i) != true){						
					visit(i,visitlist,st)
				}
				else{
					println("Cycle Detected at : " + i )
					System.exit(0)
				}				
			}			
		}	
	}
}
