package mykafka

import java.text.SimpleDateFormat
import java.util.{Calendar, UUID}

import kafka.utils.Logging

object TestProducer extends Logging {
   def main(args: Array[String]) {

      info ("Starting...")
      val producer = new KafkaProducer[String,String](Settings.topicName, Settings.brokerList)

      for (i<-1 to 50000)  {
         val key : String = UUID.randomUUID().toString()
         val message = "#" + i + " " + key + " " + (new SimpleDateFormat("YYYYMMddhhmmssSSS")).format(Calendar.getInstance.getTime)
         producer.send(message,key)
         //Thread.sleep(200)
         if (i%100==0)
            {
               info("Message #" + i)
            }
      }
      producer.close()

      info ("Done.");
   }
}
