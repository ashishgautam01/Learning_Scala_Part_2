import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap
import scala.io.StdIn.readInt
import scala.collection.mutable.ArrayBuffer

object DFS101 extends App{	
	
  	var graph = Array(Array(0,0,1,1,0),Array(1,0,0,0,0),Array(0,1,0,0,0),Array(0,0,0,0,1),Array(0,0,0,0,0))


	var obj = new kosaraju()
	var st = Stack[Int]()
	var visitlist : Array[Boolean] = (0 until graph.size map(_ => false)).toArray

	var stack = obj.dfs(0,graph,visitlist,st)
	
	println("Actual Graph :")
	obj.printgrp(graph)
	obj.show_stack(stack)
	println(stack)

	var transposed = obj.trans(graph)
	obj.printgrp(transposed)
	
	
	obj.pop_dfs(graph,stack)
}

class kosaraju() {		
	
	def pop_dfs(tran: Array[Array[Int]], st: Stack[Int]){
		var size = st.size			
		 for(i<- 0 until st.size){
		 	var visitlist1: Array[Boolean] =(0 until tran.size map(_ => false)).toArray
		 	var temp_st = Stack[Int]()
		 	var x = st.pop()			
			//var result = pooper(x,visitlist1,temp_st)
			var result = dfs(x,tran,visitlist1,temp_st)
			println(x + "-->" + result)			
		}
	}	

	def trans(graph: Array[Array[Int]]): Array[Array[Int]] = {
		var res = graph.transpose
		res
	}

	def dfs(src:Int,graph: Array[Array[Int]],visit: Array[Boolean],st: Stack[Int]): Stack[Int] = {
	 	
	 	if(!visit(src)){
		 	visit(src) = true	 	
	 		st.push(src)
            for(j<- 0 until graph.size){
                
                if(graph(src)(j) == 1 && !visit(j)){
                	st.push(j)
                	dfs(j,graph,visit,st)
                }
         
      		}
	  	}
        st.distinct
   } 

	def show_stack(stack: Stack[Int]){
		println("ObtainedStack size : "+stack.size + "\n")
		stack.foreach(x=> {
			println("Stack : " + x)
		})
	}	
	 
   def printgrp(g: Array[Array[Int]]){
	 	var v = g.size
    for(i<- 0 until v){
      println(" ")
       for( j<- 0 until v){
          print(g(i)(j)+" " )
      }
    }
    println(" \n")
  } 

/*
		def pooper(src: Int,visit: Array[Boolean],sti: Stack[Int]): Stack[Int] ={
			
			var l = Array[Int]()
			
			if(!visit(src)){
		 		visit(src) = true	
		 		
	 			sti.push(src)
            	for(j<- 0 until tran.size){
                 breakable{
                	if(tran(src)(j) == 1 && !visit(j)){
                		sti.push(j)
                		pooper(j,visit,sti)                		
                	}else {
                		break
                	}               	
         		  }
      			}
	  		}
	  		if(sti.distinct.size == size){
	  			var r =  Stack[Int]()
	  			r.push(src)
	  			return r
	  		}else{
		  		sti.distinct       
			}
		}
			
	}
	*/
}
