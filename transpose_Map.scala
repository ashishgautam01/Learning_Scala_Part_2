object transpose_a_Map extends App {
	 val m = Map(1 -> List("a", "b", "c"),
        		2 -> List("d", "e", "f"),
        		3 -> List("g", "h", "i"))
    println(m+"\n\n")
    val res = m.map {case (k, vs) => vs.map(k -> _)}.toList.transpose.map(_.toMap)
    println(res)


}