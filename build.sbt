name := "kafka-test"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.8.2.1"
libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.8.2.1"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.5"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.0"
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.4.0"
libraryDependencies += "org.apache.avro" % "avro" % "1.7.7"
