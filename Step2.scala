import scala.io.StdIn.readLine
import scala.util.Random

class SixLittle {
  var words = List[String]()
  var hints = List[String]()
  var tokens = List[String]()

  def ask(): Unit = {
    for (_ <- 1 to 6) {
      var word = ""
      do {
        println("Enter a word of at least 4 characters: ")
        word = readLine()
      } while (word.length < 4)
      
      println("Enter a related hint: ")
      val hint = readLine()
      
      words = words :+ word
      hints = hints :+ hint
    }
  }

  def prepare(): Unit = {
    tokens = words.flatMap { word =>
      val midpoint = word.length / 2
      val (firstHalf, secondHalf) = word.splitAt(midpoint)
      List(firstHalf.toUpperCase, secondHalf.toUpperCase)
    }
    tokens = Random.shuffle(tokens)
  }

  def display(): Unit = {
    println("Six Little Words (Scala)")
    println("Partial Words:")
    tokens.grouped(4).foreach(group => println(group.mkString(" ")))
    println("\nHints:")
    hints.foreach(println)
    println("\nAnswer Key:")
    words.grouped(3).foreach(group => println(group.mkString(" ")))
  }

  def run(): Unit = {
    words = List[String]()
    hints = List[String]()
    tokens = List[String]()
    
    ask()
    prepare()
    display()
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val game = new SixLittle
    game.run()
  }
}
