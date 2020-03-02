object learn extends App {

  //Zip allows us to have two different collections and get aa single output
  val a = Seq(1,2,3)
  val b = Seq(3,2,1)
  println("Zip output : ")
  println( a zip b)
  

  //ZipWithIndex uses element's Index to Zip together the values
  var x = Map('a'-> 12, 'b'-> 13)
  var zippervar =x.zipWithIndex

  zippervar.foreach(y => println("Zip With index output : "+s"key - ${y._1} with Index - ${y._2}")) 

  //groupBy is used to group all elements of a collection accordin to a given scheme
  val input = List(1,2,3,4,5,6,7,8)
  val result = input.groupBy {x => x}.map {case(num,times) => (num,times.size)}.toList.sortBy(_._1)
  println("Group By output : "+result)


}