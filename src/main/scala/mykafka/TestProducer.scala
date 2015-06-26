package mykafka

import java.util.{Calendar, UUID}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import kafka.utils.Logging

object TestProducer extends Logging {
   def main(args: Array[String]) {

      info ("Starting...")
      val producer = new KafkaProducer[String,String](Settings.topicName, Settings.brokerList, synchronously = false)

      val numMessages : Int =  if (args.length>0) Integer.parseInt(args(0)) else 10000
      val mapper: ObjectMapper = new ObjectMapper()
      mapper.registerModule(DefaultScalaModule)

      val dimensionMetaData : Map[String, List[(String,Int)]] = Map("browser"->List(("IE",200),("FF",300), ("CH",500)), "country"->List(("IL",100),("US",400),("TH",500)), "gender"->List(("M",480),("F",450),("UNKN",70)))
      val dimensionGenerators : Map[String, RandomValueGenerator[String]] = dimensionMetaData.map({ case (k,v) => k-> new RandomValueGenerator[String](v) })

      val startTime:Long = Calendar.getInstance().getTimeInMillis()
      for (i<-1 to numMessages)  {
         val key : String = UUID.randomUUID().toString()
         val ev = new MyEvent("PageView", dimensionGenerators.map( {case (k,v) => k->v.getNext()}) , Id = key)
         val message = mapper.writeValueAsString(ev) //TODO: Make this more low level to avoid serializing to string and then sending, so that mapper serializes directly into kafka client stream
         producer.send(message,key)
         //Thread.sleep(200)
         if (i%100==0)
            {
               info("Message #" + i)
            }
      }
      val endTime:Long = Calendar.getInstance().getTimeInMillis()
      producer.close()


      info ("Done - " + numMessages + " messages in " + (endTime - startTime).toString() + " msec.")
   }
}
