import scala.collection.mutable.ArrayBuffer
class Grph(val vertex: IndexedSeq[String], edges: Seq[(Int, Int)]) {    
    def size: Int = vertex.length
    val adjacent = edges groupBy (_._1) mapValues (_ map (_._2)) // a Map of all edges with adjacent nodes
    def adjacencyMatrix = adjacent mapValues (_.toSet) mapValues (0 to size map _)//make a maatrix of all values of adj. with true/false 
    def printAdjacencyList: String = adjacent mapValues (_ mkString ", *") mkString "\n" //Print the List structure
    def printAdjacencyMatrix: String = (adjacencyMatrix mapValues(_ mkString ", ") mkString "\n") //Print the matrix structure
}
object adj_list101 extends App{
    def vertices: Array[String] = Array("0","1","2","3","4","5","6","7")
    def edges: ArrayBuffer[(Int, Int)] = ArrayBuffer(
        (0, 1), (0, 3), (0, 5), 
        (1, 0), (1, 2), (1, 3), 
        (2, 1), (2, 3), (2, 4), 
        (3, 0), (3, 1), (3, 2), (3, 4), (3, 5), 
        (4, 2), (4, 3), (4, 5), (4, 7), 
        (5, 0), (5, 3), (5, 4), (5, 6), (5, 7), 
        (6, 5), (6, 7), 
        (7, 4), (7, 5), (7, 6)
        )
   
    val graph = new Grph(vertices,edges)

    println("number of vertices in graph: " + graph.size)
  
    println("\nadjacency list for graph -> ")
    println(graph.printAdjacencyList)
    println("\n adjacency Matrix: ->")
    println(graph.printAdjacencyMatrix)
    
}