
// STill Have to solve the queue dying in the last call

import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import util.control.Breaks._


object BFS101 extends App{
	var x  = Map(1-> Set(2,5),
				2-> Set(1,3),
				3-> Set(2,4,6),
				4-> Set(3,8),
				5-> Set(1),
				6-> Set(3,7),
				7-> Set(6),
				8-> Set(4))
var qu = new Queue[Int]
	val size = x.size
	var newcurr = 0;var counter = 0
	var vlst = Set[Int]()
	var res = visit(x,1,qu,vlst)

	def visit(m: Map[Int,Set[Int]],start: Int,q: Queue[Int],visitlist: Set[Int]): Unit ={

		calc(start,q,visitlist)
		def calc(curr: Int,q1: Queue[Int],visitlst: Set[Int]){
			println("Visited : "+ curr)
			visitlst += curr
			
				for((i,lst)<- m){
					if(i == curr){
						for(x<- lst){
							if(!visitlst.contains(x)){
								q1.enqueue(x)
								visitlst += x
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