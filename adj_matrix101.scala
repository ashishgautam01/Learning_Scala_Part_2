import scala.collection.mutable.ArrayBuffer

class Grph(val vertex: IndexedSeq[String], edges: Seq[(Int, Int)]) {
	 println("Check :\tGrph: first line")
    def size: Int = vertex.length
    val index: Map[String, Int] = vertex.zipWithIndex.toMap
    val adjacent = edges groupBy (_._1) mapValues (_ map (_._2))
    def adjacencyMatrix = adjacent mapValues (_.toSet) mapValues (0 to size map _)
 
    def printEdges: String = {
    	 println("Check: main:printEdges: \tfirst line")
      for(idx <- 0 until size)
        yield f"vertex $idx: ${adjacent(idx) mkString " "}"
    } mkString "\n"
   
     def printAdjacencyMatrix: String = adjacencyMatrix mapValues(_ mkString ", ") mkString "\n"
  
}
object adj_matrix101 extends App{
	def vertices: Array[String] = Array("A", "B", "C",
        "D", "E", "F", "G", "H")

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
	println("the vertex with index 1 is: " + graph.vertex(1))
	println("the index for Miami is: " + graph.index("C"))
	
	println("adjacency matrix for graph: ")
	println(graph.printAdjacencyMatrix)
}