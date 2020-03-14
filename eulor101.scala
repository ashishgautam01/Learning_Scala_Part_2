object euler {

  def main(args: Array[String]){
    
    var matt_obj = new mat()
    var graph = matt_obj.getEdges()
    //var graph: Array[Array[Int]] = Array(Array(0,1,1,0,0,0,0,0),Array(1,0,1,1,1,0,0,0),Array(1,1,0,1,0,1,0,0),Array(0,1,1,0,0,0,0,0),Array(0,1,0,0,0,1,1,1),Array(0,0,1,0,1,0,1,1),Array(0,0,0,0,1,1,0,0),Array(0,0,0,0,1,1,0,0))
    
    var o = new eull(graph)
    o.init()
   
  }  
}

class mat {

  def getEdges(): Array[Array[Int]] = { 

    println("Number of Vertices : ")
    var v = scala.io.StdIn.readInt()
    var g = Array.ofDim[Int](v,v)
    for(i<- 0 until v; j<- 0 until v){
      g(i)(j) = 0
    }
    println("Enter number of Edges : ")
    var e = scala.io.StdIn.readInt()
    for(i<- 0 until e){  
      println("From Node : ")
      var temp1 = scala.io.StdIn.readInt()       
      println("To Node   : ")
      var temp2 = scala.io.StdIn.readInt()
      g(temp2)(temp1) = 1
      g(temp1)(temp2) = 1
    }
    return g    
  }
  def printgrp(g: Array[Array[Int]],v: Int){
    for(i<- 0 until v){
      println(" ")
       for( j<- 0 until v){
          print(g(i)(j)+" " )
      }
    }
    println(" \n")
  }
}


class eull(graph: Array[Array[Int]]) {  
    
    val Node = graph.size
    var t_grph = graph

  def init(){
     println("Euler Path or circuit :")
    fleury_Check(findstartVert())
  }

  def findstartVert(): Int ={
    for(i<- 0 until Node){
      var deg = 0
      for(j<- 0 until Node){
        if(t_grph(i)(j)== 1){
          deg +=1
        }
      }  
      if(deg % 2 != 0){
       return i
      }      
    }
    return 0
  }

  def dfs(prev: Int,start: Int,visited: Array[Boolean]):Int = {
    var count =1
    visited(start) = true
    for(u<- 0 until Node){
      if(prev != u){
        if(!visited(u)){
          if(t_grph(start)(u) == 1){
            count += dfs(start,u,visited)
          }
        }
      }
    }
    return count
  }

  def isBridge(u: Int,v: Int): Boolean ={
    var deg = 0
    for(i<- 0 until Node){
      if(t_grph(v)(i) == 1){
        deg += 1
      }
      if(deg > 1) 
        return false
    }
    return true
  }

  def edgeCount(): Int ={
    var count = 0
    for(i<- 0 until Node){
      for(j<- i until Node){
        if(t_grph(i)(j) == 1){
          count += 2  
        }
      }
    }
    return count
  }

  def fleury_Check(start: Int){
    var edge = edgeCount()
    var v_count = Node
    for(v<- 0 until Node){
      if(t_grph(start)(v) == 1){
        var visited = (0 until Node map(_ => false)).toArray
        if(isBridge(start,v)){
          v_count -= 1
        }
        var cnt = dfs(start,v,visited)
        if((v_count - cnt).abs <= 2){
          println(start+"--"+v+" ")
          if(isBridge(v,start)){
            v_count -= 1
          }
          t_grph(start)(v) = 0
          t_grph(v)(start) = 0
          edge -= 2
          fleury_Check(v)
        }
      }
    }
  }

}
