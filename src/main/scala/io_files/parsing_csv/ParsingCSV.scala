package io_files.parsing_csv

import scala.io.Source

case class Record(
                 firstName: String,
                 lastName: String,
                 age: Option[Int]
                 )

object ParsingCSV {
  def parseLine(line: String): Record =
    // seemed weird at first that "foo,bar,".split(",") returns only two elements
    val recSplit = line.split(",")
    // TODO: handle exception when doing the parsing
    val age = recSplit.length match {
      case 2 => None
      case 3 => Some(recSplit(2).toDouble.toInt)
      case _ => None
    }
    Record(
      firstName = recSplit(0), lastName = recSplit(1), age = age
    )

  @main def runParser(): Unit = {
    val csvPath = "src/main/scala/io_files/parsing_csv/example.csv"
    val source = Source.fromFile(csvPath)
    val records = source.getLines.toList.tail.map(parseLine)
    records.foreach(println)
  }

}
