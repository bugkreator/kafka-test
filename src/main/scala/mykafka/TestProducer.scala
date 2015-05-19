package mykafka

import java.util.UUID
import java.util.Date


object TestProducer {
   def main(args: Array[String]) {
      /*
      val props: Properties = new Properties()
      //props.put("metadata.broker.list", "192.168.119.128:9092,192.168.119.128:9093,192.168.119.128:9094")
      props.put("bootstrap.servers", "192.168.119.128:9092,192.168.119.128:9093,192.168.119.128:9094")
      props.put("value.serializer", "kafka.serializer.StringEncoder")
      props.put("key.serializer", props.getProperty("value.serializer"))

      //props.put("request.required.acks", "1")

      val producer: KafkaProducer[String,String] = new KafkaProducer(props )
      //val data = new KeyedMessage[String, String]("topic2", "key1", "value1")
      val data = new ProducerRecord[String,String]("topic2", "key1", "value1 @ " + (new SimpleDateFormat("YYYY-MM-dd hh:mm:ss")).format(Calendar.getInstance.getTime))
      producer.send(data)
      producer.close()
      println("Done")*/
      val producer = new KafkaProducer(Settings.testTopic, Settings.messageBroker)


      for (a <- 1 to 10 )
      {
         producer.send("Message "+a+" "+ UUID.randomUUID().toString+" "+new Date())
         print(".")
         Thread.sleep(1000);
      }
      /*
     val numList = List(0,1,2);
     for (a <- numList) {
       // Create a partition key as Byte Array
       var key = java.nio.ByteBuffer.allocate(4).putInt(a).array()
       //Here I give a Array[Byte] key
       //so the second "send" function of producer will be called
       producer.send(testMessage.getBytes("UTF8"), key)
     }*/
      println("All done!");
   }
}
