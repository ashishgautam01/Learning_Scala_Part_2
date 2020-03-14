
import scala.collection.mutable.Stack
import util.control.Breaks._
import scala.collection.mutable.Set
import scala.collection.SortedMap

object HAM101 extends App{  
  var y  = SortedMap(0->Array(1),1-> Array(2,5),  
        2-> Array(1,3),
        3-> Array(2,4,6),
        4-> Array(3,5,8),
        5-> Array(1,6),
        6-> Array(3,7),
        7-> Array(6,8),
        8-> Array(4,0)) 
  var x = SortedMap(0->Array(1),1->Array(2,0),2->Array(0))
  var z = SortedMap(0-> Array(1),1->Array(2,4),2->Array(1,3,4,5),3->Array(2,5),4->Array(1,2,5),5->Array(0,3,4))
  var result = Stack[Stack[Int]]()

  var obj = new HAM(x,result)
  obj.init()  
}

class HAM(m: SortedMap[Int,Array[Int]],result: Stack[Stack[Int]]) {    
  
  def dfs(start: Int){
    var size = m.size
    var st = Stack[Int]()
    var visitlist: Array[Boolean] =(0 until size map(_ => false)).toArray
    visitlist(start) = true
    visit(start,visitlist,st)
  
    def visit(curr: Int,visitlist: Array[Boolean],st: Stack[Int]){
   
      visitlist(curr) = true
      st.push(curr) 
      for((lst)<- m.get(curr); i<- lst){
        if(visitlist(i) != true){         
          visit(i,visitlist,st)
        }else cycle_check(i,start,st)
      }     
    } 
  }

  def cycle_check(i: Int,start: Int,st: Stack[Int]){    
    if(start == i && st.distinct.size == m.size)  result.push(st) 
  }

  def init(){
    m.keys.foreach(c =>{
      dfs(c)
    })
    end()
  }

  def end(){
    println("Hamiltonian cycles : ")
    result.distinct.foreach(c => {
      println(c)
    })
  }
}
