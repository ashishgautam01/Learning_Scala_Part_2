
import scala.collection.SortedMap
import scala.collection.mutable.Stack
import scala.collection.mutable.Set
import scala.util.control.Breaks._

object toplogy extends App {

  // var grph: SortedMap[Int,Set[Int]]  = SortedMap(0->Set(),1->Set(),2->Set(3),3->Set(1),4->Set(0,1),5->Set(0,2)) 
  //var grph: SortedMap[Int,Set[Int]] = SortedMap(0->Set(1,2),1->Set(3),2->Set(3),3->Set(4))
  var grph: SortedMap[Int,Set[Int]] = SortedMap(1->Set(0),2->Set(1),3->Set(1),5->Set(2,4),6->Set(3,4),7->Set(5,6))
  var sizee = grph.size
  var visitlist = Set[Int]()
  var obj = new topo(sizee,visitlist)
   obj.tsort(grph,0)  
}

class topo(size: Int,visitlist: Set[Int]){

  def tsort(g: SortedMap[Int,Set[Int]],start: Int){
    //What we need    
    var newstart = start
    var st = Stack[Int]()
    st.push(start)
    //first ever call for the function
    loop(start,visitlist)

    def loop(curr: Int,visitlist: Set[Int]){
    // breakable{
      g.keys.foreach(i=> {
        println("\nCurrent elt : "+ i)
        if(g(i).isEmpty){ // For empty list 
          println("Empty List : " + i)
          st.push(i)
          visitlist += i
        }
        else{
          println("Unempty List :" + g(i))
          traverse(g(i))
          st.push(i)
          visitlist += i
        }
      })
     
    } 

    def traverse(lst: Set[Int]) {
      lst.foreach(x => {
        if(!visitlist.contains(x)){
          println("traversed: "+ x)
          visitlist += x
          st.push(x)
        }
      })
    } 
     
  println("Sorted Result : ")
  var res = st.reverse
  println(res.distinct)
  }  
}
