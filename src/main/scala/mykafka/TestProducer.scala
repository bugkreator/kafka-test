package mykafka

import java.util.{Calendar, UUID}

import kafka.utils.Logging

object TestProducer extends Logging {
   def main(args: Array[String]) {

      info ("Starting...")
      val producer = new KafkaProducer[String,String](Settings.topicName, Settings.brokerList)

      val numMessages : Int = if (args.length>0)  Integer.parseInt(args(0)) else 1000

      for (i<-1 to numMessages)  {
         val key : String = UUID.randomUUID().toString()
         val message = "#" + i + " " + key + " " + Calendar.getInstance.getTimeInMillis
         producer.send(message,key)
         //Thread.sleep(200)
         if (i%100==0)
            {
               info("Message #" + i)
            }
      }
      producer.close()

      info ("Done - " + numMessages + " messages.")
   }
}
