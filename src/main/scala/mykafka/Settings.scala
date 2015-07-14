package mykafka

object Settings {
   val topicName = "topic22"
   val groupId_1 = "Group-RealTime"
   val groupId_2 = "Group-Batch"
   val zooKeeper = "ubuntu:2181"
   val brokerList =  (9092 to 9097).map((port:Int)=>"ubuntu:"+port).toList.mkString(",")
}