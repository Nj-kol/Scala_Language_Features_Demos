package example

object Hello extends App {

  def demo() {
    import Weekday._

    // use an enumeration value in a test
    var today = Sunday

    // later in the code ...
    if (today == Sunday) println("Today is a holiday")

    // print all the enumeration values
    Weekday.values foreach println
  }
}

