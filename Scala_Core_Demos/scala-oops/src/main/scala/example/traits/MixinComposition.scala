package example.traits

// Example 1
trait Tail {
  def wagTail = println("tail is wagging")
  def stopTail = println("tail is stopped")
}

abstract class Pet(var name: String) {
  def speak // abstract
  def ownerIsHome = println("excited")
  def jumpForJoy = println("jumping for joy")
}

class Dog(name: String) extends Pet(name) with Tail {
  def speak = println("woof")
  override def ownerIsHome {
    wagTail
    speak
  }
}

// Example 2
trait Chocolate {
  def hasChocolate = true
}

trait CaramelSwirl {
  def hasCaramelSwirl = true
}

trait Pecans {
  def hasPecans() = true
}

class ChocolateIceCream extends Chocolate
class ChocolateCaramelIceCream extends Chocolate with CaramelSwirl
class CaramelIceCreamSundae extends Chocolate with CaramelSwirl with Pecans

// Example 3
trait LoggingSupport {
  def log(message: String): Unit = {}
}

trait ConsoleLoggingSupport extends LoggingSupport {
  override def log(message: String): Unit = {
    super.log(message)
    println(f"This is a console message: $message")
  }
}

trait FileLoggingSupport extends LoggingSupport {
  override def log(message: String): Unit = {
    super.log(message)
    println(f"Let's assume this is written to a file: $message")
  }
}

class MyApp extends FileLoggingSupport with ConsoleLoggingSupport {
  def doSomething(): Unit = log("Something happened")
}