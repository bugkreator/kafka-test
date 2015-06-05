package mykafka


import java.util.concurrent.atomic.AtomicInteger
import java.util.{Calendar, UUID}

import kafka.message.MessageAndMetadata
import kafka.utils.Logging

object TestConsumer extends App with Logging {
   //def main(args: Array[String]) {

   def cleanup() : Unit = {
      consumer.close()
   }

   sys addShutdownHook {
      info("Shutting down...")
      cleanup()
      info("Done shutting down.")
   }
   val counter: AtomicInteger = new AtomicInteger(0)

   def debugMessage(msg: MessageAndMetadata[Array[Byte], Array[Byte]]) : Unit = {
      info(new String(msg.message()) + " from partition #" + msg.partition) // + " (thread = " + Thread.currentThread().getId() + ")")
   }

   def processMessage(blob: Array[Byte]) : Unit = {
      info(" <#" + counter.incrementAndGet().toString() + "> : " + (new String(blob)) )
   }


   info ("Starting...")
   val consumer = new KafkaConsumer(Settings.topicName, "group2", Settings.zooKeeper, true)
   consumer.read (debugMessage)
   //consumer.read(processMessage)
   consumer.close()

   info ("Done.")
}
