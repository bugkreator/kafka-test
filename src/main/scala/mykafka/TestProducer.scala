package mykafka

import java.text.SimpleDateFormat
import java.util.{Properties, Calendar}
import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}

object TestProducer {
   def main(args: Array[String]) {
      val props: Properties = new Properties()
      //props.put("metadata.broker.list", "192.168.119.128:9092,192.168.119.128:9093,192.168.119.128:9094")
      props.put("bootstrap.servers", "192.168.119.128:9092,192.168.119.128:9093,192.168.119.128:9094")
      //props.put("serializer.class", "kafka.serializer.StringEncoder")
      props.put("key.serializer", "kafka.serializer.DefaultEncoder")
      props.put("value.serializer", "kafka.serializer.DefaultEncoder")
      //props.put("partitioner.class", "example.producer.SimplePartitioner")
      props.put("request.required.acks", "1")

      val producer: KafkaProducer[String,String] = new KafkaProducer(props )
      //val data = new KeyedMessage[String, String]("topic2", "key1", "value1")
      val data = new ProducerRecord[String,String]("topic2", "key1", "value1 @ " + (new SimpleDateFormat("YYYY-MM-dd hh:mm:ss")).format(Calendar.getInstance.getTime))
      producer.send(data)
      producer.close()
      println("Done")
   }
}
