package mykafka

import java.text.SimpleDateFormat
import java.util.{Calendar, UUID}

import kafka.message.MessageAndMetadata
import kafka.utils.Logging

object TestConsumer extends Logging {
   def main(args: Array[String]) {

      def debugMessage(msg: MessageAndMetadata[Array[Byte], Array[Byte]]) : Unit = {
         info(new String(msg.message()) + " from partition #" + msg.partition)
      }

      def processMessage(blob: Array[Byte]) : Unit = {
         info(new String(blob))
      }

      info ("Starting...")
      val consumer = new KafkaConsumer(Settings.topicName, "group1", Settings.zooKeeper, true)
      //consumer.debug_read (debugMessage)
      consumer.read(processMessage)
      consumer.close()

      info ("Done.");
   }
}
