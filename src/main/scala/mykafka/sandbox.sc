import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import mykafka.{RandomValueGenerator, MyEvent}

val dimensionMetaData : Map[String, List[(String,Int)]] = Map("browser"->List(("IE",200),("FF",300), ("CH",500)), "country"->List(("IL",100),("US",400),("TH",500)))
val dimensionGenerators = dimensionMetaData.map({ case (k,v) => k-> new RandomValueGenerator[String](v) })
val randomValues = dimensionGenerators.map( {case (k,v) => k->v.getNext()})


