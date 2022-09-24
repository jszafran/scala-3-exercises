package io_files.reading_from_file

import scala.io.Source


object ReadFileFromDisk {
  @main def readFile(): Unit = {
    // source: https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/

    val path = "src/main/scala/io_files/reading_from_file/test_file.txt"

    // this does not close the source
    val lines = Source.fromFile(path).getLines.toList

    // more verbose - closing the source
    val source = Source.fromFile(path)
    val lines2 = source.getLines.toList
    source.close()

    // read all lines as single string
    println(Source.fromFile(path).getLines.toList.mkString("\n"))
  }
}
