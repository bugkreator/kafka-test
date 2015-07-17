package mykafka

object Settings {
   val topicName = "topic22"
   val groupId_1 = "Group-RealTime"
   val groupId_2 = "Group-Batch"
   val zooKeeper = "ubuntu:2181"
   val brokerList =  (9092 to 9097).map((port:Int)=>"ubuntu:"+port).toList.mkString(",")
   // Helper crap to save rewriting existing scala in Java
   val dimensionMetaData = Map("browser"->List(("IE",200),("FF",300), ("CH",500)), "country"->List(("IL",100),("US",400),("TH",500)), "gender"->List(("M",480),("F",450),("UNKN",70)))
   val dimensionGenerators : Map[String, RandomValueGenerator[String]] = dimensionMetaData.map({ case (k,v) => k-> new RandomValueGenerator[String](v) })
   val dimensions = dimensionMetaData.keysIterator.toArray
   def getNextRandomValue(dimName: java.lang.String) : String = dimensionGenerators(dimName).getNext()
}