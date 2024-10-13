package example

class DonutString(s: String) {
  def isFavoriteDonut: Boolean = s == "Glazed Donut"
}

object Hello extends App {

  // Implicit Parameter
  implicit def sender: String = "Bob"

  def sendText(body: String)(implicit from: String): String = s"$body, from: $from"

  // This list of parameters can be called normally if you want to
  sendText("hola mundo")("Apiumhub")

  // But its main characteristic is that you can define an
  // implicit value / function / definition in your code
  // and if it is in the same context ... the compiler will use it!
  sendText("I love you")

  // Implicit function
  implicit def stringToDonutString(s: String) = new DonutString(s)

  // Implicit class: Extension methods
  import utils._

  "4".plusOne
  "0".asBoolean

}