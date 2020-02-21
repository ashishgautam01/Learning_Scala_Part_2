import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Set

class Quick{
    var pivot: Int = 0
    var res = Array[Int]()
    def sort(a:Array[Int]): Array[Int] = {  
        if (a.length < 2) a
        else {
            pivot = a(a.length / 2)
            res = Array.concat( sort(a filter (pivot >)) , (a filter (pivot == )) , sort (a filter(pivot <)))
        
        }
        return res
    }

}
object Qsort extends App {
    val q = new Quick
    val a = Array(5, 3, 2, 2, 1, 1, 9, 39 ,219)
    var x = q.sort(a)
    x.foreach(n=> (print(n), print (" " )))
   
}