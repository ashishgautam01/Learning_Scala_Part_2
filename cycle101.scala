import scala.util.control.Breaks._
import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap
object cycle extends App{	
	var x  = SortedMap(0->Set(1),1-> Set(6),  //Graph represented as a Map
				2-> Set(2),
				3-> Set(2),
				
				5->Set(7),
				6-> Set(5),
				7->Set(3)
								
				)	
	//var x = SortedMap(1-> Set(2,5),2-> Set(1,3),3->Set(2,4),4->Set(3,5),5->Set(4,1))
	val size = x.size
	val st = new Stack[Int]()	
	//for((a,b)<- x ) println(s"Vertex $a -> $b") //to show the graph	
  	var vList = Set[Int]()  	
  	var ls = dfs(x,0,vList,st)		
	def dfs(m: SortedMap[Int,Set[Int]], start: Int,visitlist: Set[Int],stin: Stack[Int]): Unit = {		
		var newstart: Int = start //For the first start
		//To visit every key
		visit(newstart,visitlist,stin)
		def visit(curr: Int,visitlist: Set[Int],stinner: Stack[Int]){
			visitlist += curr
			stinner.push(curr)
			println("Visited Vertex : "+ st.pop)			
			breakable{
				for((lst)<- m.get(curr); i<- lst){
					if(!visitlist.contains(i)){						
							visit(i,visitlist,st)
						// 	println("No cycle  YET : ")
					}else{
					 println("Cycle Just Encountered :")
					 //break //for just one cycle  and the out we goo
					}				
				}
			}	
		}
	} 
}
