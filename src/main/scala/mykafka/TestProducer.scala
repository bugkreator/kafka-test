package mykafka

import java.text.SimpleDateFormat
import java.util.{Calendar, UUID, Date}

import kafka.utils.Logging


object TestProducer extends Logging {
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
      val data = new ProducerRecord[String,String]("topic2", "key1", "value1 @ " +
      producer.send(data)
      producer.close()
      println("Done")*/
      info ("Starting...")
      val producer = new KafkaProducer[String,String](Settings.topicName, Settings.brokerList)

      for (i<-0 to 100)  {
         val message = "Message " + i + " " + (new SimpleDateFormat("YYYY-MM-dd hh:mm:ss.SSS")).format(Calendar.getInstance.getTime)
         val key : String = "F"
         producer.send(message,key)
         //Thread.sleep(1000)
         if (i%100==0)
            {
               info("Message #" + i)
            }
      }
      producer.close()
      /*
     val numList = List(0,1,2);
     for (a <- numList) {
       // Create a partition key as Byte Array
       var key = java.nio.ByteBuffer.allocate(4).putInt(a).array()
       //Here I give a Array[Byte] key
       //so the second "send" function of produccd er will be called
       producer.send(testMessage.getBytes("UTF8"), key)
     }*/
      info ("Done.");
   }
}
