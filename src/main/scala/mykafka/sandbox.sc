import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import mykafka.MyEvent

val ev : MyEvent = new MyEvent("PageView")
val mapper: ObjectMapper = new ObjectMapper()
mapper.registerModule(DefaultScalaModule)
mapper.writeValueAsString(ev)