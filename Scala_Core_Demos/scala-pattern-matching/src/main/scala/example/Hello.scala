package example

object Hello extends App {

  val obj = 20

  obj match {
    case x: Int => x
    case s: String => Integer.parseInt(s)
    case y: BigInt => Int.MaxValue
    case _ => 0
  }

  def whatis(obj: Any) {
    obj match {
      case User(name, Paypal(email)) => s"Paypal with email : ${email}"
      case User(name, Bitcoin(key)) => s"Bitcoin with key : ${key}"
      case _ => "Unknown type"
    }
  }

  val inputDay = "monday"

  val output = inputDay match {
    case weekend if weekend == "saturday" || weekend == "sunday" => "Hurrah! Weekend"
    case weekday => s"Today is $weekday, catch the bus"
  }
  
}
