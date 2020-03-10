
import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import scala.collection.SortedMap
object BFS101 extends App{
	var x  = Map(0->Array(1),1-> Array(2,5),  //Graph represented as a Map
				2-> Array(1,3),
				3-> Array(2,4,6),
				4-> Array(3,8),
				5-> Array(1),
				6-> Array(3,7),
				7-> Array(6),
				8-> Array(4))
	//var x = Map(1-> Array(2,5),2-> Array(1,3),3->Array(2,4),4->Array(3,5),5->Array(4,1))
	var qu = new Queue[Int]
	val size = x.size
	
	var vlst: Array[Boolean] = (0 until size map(_ => false)).toArray
	var res = visit(x,0,qu,vlst)

	def visit(m: Map[Int,Array[Int]],start: Int,q: Queue[Int],visitlist: Array[Boolean]): Unit ={
		var newcurr = 0
		//first call to the BFS rec function
		calc(start,q,visitlist)
		
		def calc(curr: Int,q1: Queue[Int],visitlst: Array[Boolean]){
			println("Visited : "+ curr)
			visitlst(curr) = true			
				for((i,lst)<- m){
					if(i == curr){
						for(x<- lst){
							if(!visitlst(x)){ 
								q1.enqueue(x) 
							    visitlst(x) = true
							}
						}
						if(!q1.isEmpty){
							newcurr = q1.front
							q1.dequeue
							calc(newcurr,q1,visitlst)
						}			
					}
				}
		}		
	}
}