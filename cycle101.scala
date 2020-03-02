import scala.util.control.Breaks._
import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap
object cycle extends App{	
	var x  = SortedMap(0->Set(1),1-> Set(6),  //Graph represented as a Map
				2-> Set(3),
				3-> Set(2),				
				5->Set(7),
				6-> Set(5),
				7->Set(7)								
				)	
	//var x = SortedMap(1-> Set(2,5),2-> Set(1,3),3->Set(2,4),4->Set(3,5),5->Set(4,1))	 	
  	traverse(x,0)	

	def traverse(m: SortedMap[Int,Set[Int]], start: Int): Unit = {					
		var visitlist = Set[Int]() 	
		var newstart: Int = start //For the first start
		visit(newstart,visitlist)

		def visit(curr: Int,visitlist: Set[Int]){
			val st = new Stack[Int]()
			visitlist += curr
			st.push(curr)
			println("Visited Vertex : "+ st.pop)			
			breakable{
				for((lst)<- m.get(curr); i<- lst){
					if(!visitlist.contains(i)){						
							visit(i,visitlist)
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
