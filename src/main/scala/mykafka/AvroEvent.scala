package mykafka

import java.util.{Calendar, UUID}

class AvroEvent(Name: String, Data : Map[String, String] = Map(), Time: Long = Calendar.getInstance.getTimeInMillis(), Id : String = UUID.randomUUID().toString())
{
   val name: String = Name
   val data: Map[String, String] = Data
   val time: Long = Time
   val id : String = Id
}
