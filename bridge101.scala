
object Bridge extends App {

	var graph: Array[Array[Int]] = Array(Array(0,1,1,1,0),
										 Array(1,0,1,0,0),
										 Array(1,1,0,0,0),
										 Array(1,0,0,0,1),
										 Array(0,0,0,1,0))

	var obj = new bridge(graph,0)
	obj.visiter() 
}

class bridge(g: Array[Array[Int]],start: Int){

	def visiter (){
		var counter = 0
		var visitlist = Array[Array[Int]]()
		if(dfs_check(visitlist,0,0,counter) == true){
			println("Provided graph is connected :")
		}

		for(i<- 0 until g.size; j<- 0 until g.size){
			println(i+"-"+j+" = "+ g(i)(j))
			var res = remove_check(i,j)

			if(res){
				println("Bridge found :"+i+"-"+j)
			}
			else {
				println("No Bridges Found in the graph : ")
			}
		}

	}

	def dfs_check(visitlist: Array[Array[Int]],a: Int,b: Int,counter:Int): Boolean = {
		println("DFS running ::")
		visitlist.fill(0)(0)

		for(i<- 0 until g.size;j<- 0 until g.size){
			if(g(i)(j) == 1 && (visitlist(i)(j) == 0)){
				println("Visited : "+ i+" - "+ j)
				
				dfs_check(visitlist,i,j,counter+1)
			}
		}
		if(counter == 5) true
		else false
	}

	def remove_check(a: Int,b: Int): Boolean = {
		println("remover")
		//remove and call dfs_check
		false
	}
}