package mykafka

/**
 * Created by orotem on 6/24/2015.
 */

import java.util.{UUID,Calendar}

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
class MyEvent(Name: String, Data : Map[String, String] = Map(), Time: Long = Calendar.getInstance.getTimeInMillis(), Id : String = UUID.randomUUID().toString())
{
   @JsonProperty("Name")
   val name: String = Name
   @JsonProperty("Data")
   val data: Map[String, String] = Data
   @JsonProperty("Time")
   val time: Long = Time
   @JsonProperty("Id")
   val id : String = Id

   //TODO: Horribly inefficient. Make object reusable?
}
