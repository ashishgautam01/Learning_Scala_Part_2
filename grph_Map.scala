import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap
import scala.io.StdIn.readInt


object Graph_Map extends App{	
	println("::::::  Map elements must Start with 0 ::::: \n")
	def getMap(): Map[Int,List[_ <: Int]] = {
		var g = Map[Int,List[_ <: Int]]()
		println("Enter number of Vertices : " )
		var v = readInt()
		
		for(i<- 0 until v){
			print("From -> ")

		def getar(): List[_ <: Int] ={
			println("Number of connections :  ")
			var con = readInt
			var arr = List[Int]()
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
	
	var x = getMap()	
	
}
