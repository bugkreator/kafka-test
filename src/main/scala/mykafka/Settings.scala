package mykafka

object Settings {
   val topicName = "topic13"
   //val groupId_1 = "testGroup"
   //  var zooKeeper = "localhost:9092"
   //val zooKeeper = "localhost:2181"
   //val messageBroker = "localhost:9092"
   val brokerList =  (0 to 5).map((i:Int)=>"ubuntu:"+(i+9092).toString()).toList.mkString(",")
}