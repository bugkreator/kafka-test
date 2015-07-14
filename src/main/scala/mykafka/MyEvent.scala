package mykafka

/**
 * Created by orotem on 6/24/2015.
 */

import java.text.SimpleDateFormat
import java.util.{UUID,Calendar}

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
class MyEvent(Name: String, Data : Map[String, String] = Map(), Time: Long = Calendar.getInstance.getTimeInMillis(), Id : String = UUID.randomUUID().toString())
{
   @JsonSerialize
   val name: String = Name
   @JsonSerialize
   val data: Map[String, String] = Data
   @JsonSerialize
   val time: Long = Time
   @JsonSerialize
   val id : String = Id
   @JsonProperty("timestamp")
   def timestamp : String = (new SimpleDateFormat("YYYY-MM-dd HH:mm:ss")).format(time)

   //TODO: Horribly inefficient. Make object reusable?
}
