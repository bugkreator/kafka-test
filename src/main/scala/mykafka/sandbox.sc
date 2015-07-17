import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import mykafka.{RandomValueGenerator, MyEvent,DataEvent}

import com.gensler.scalavro.types.AvroType

case class Person(name: String, age: Int)

val personAvroType = AvroType[mykafka.DataEvent]
