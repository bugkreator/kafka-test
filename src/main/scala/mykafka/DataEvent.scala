package mykafka

import java.util.{Calendar, UUID}


case class DataEvent(Name: String, Data : Map[String, String] = Map(), Time: Long = Calendar.getInstance.getTimeInMillis(), Id : String = UUID.randomUUID().toString())
{
}

