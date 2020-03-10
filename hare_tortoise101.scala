// fIND THE DUPLICATE NUMBER IN A GIVEN LIST OF ELEMENTS
import scala.util.control.Breaks._

object hare_tortoise extends App {

	var ar = Array(213,213,2131,3,4,5,6,7,8,9,33,34,45,56,67,78,89,90,98,87,76,67,54,23,234,1,2)
	
	var tor = ar.iterator
	var har = ar.iterator+2
	if(tor == har) println("Match :" + tor)

	

}