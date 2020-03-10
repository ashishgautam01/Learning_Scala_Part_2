import scala.io.StdIn.readInt
import scala.collection.mutable.ArrayBuffer
import  scala.io.StdIn.readLine
import scala.collection.mutable._
import scala.util.control.Breaks._

object topo extends App{

  println("Enter the number vertex :")
  var v=readInt()
  println("Enter no of edge :")
  var e=readInt()
  
  var obj = new topology()
  obj.calc(v,e)

}  
class topology extends Dfs{

 def calc(v: Int,e: Int){  

  var ar= new ArrayBuffer[ArrayBuffer[Int]] 
  for(i<-0 to v-1){
      ar += new ArrayBuffer[Int]
  }
  
  for(i<-0 to e-1){
    var token=readLine().split(" ").map(_.toInt)
    var a=token(0);var b=token(1)
    ar(a)+=b
  }

  var visit=new Array[Boolean](v)
  
  val dfs=new Dfs()
  var st =new Stack[Int]()
      for(i<-0 to v-1){
      if(visit(i)==false){
       println(st + "previous")
        (dfs.traversal(i,ar,visit,st))
        println(st)
      }
  }

  while(!st.isEmpty){
      println(st.pop())
  }
  println(ar) 
 } 
}

class Dfs{
    def traversal(src:Int,value:ArrayBuffer[ArrayBuffer[Int]],visit:Array[Boolean],s:Stack[Int]):Stack[Int]={
       
            for(i<-value(src)){
                if(visit(i)==false){
                    traversal(i,value,visit,s)         
            }   
        } 
        visit(src)=true 
         s.push(src)
           s
    }
}
