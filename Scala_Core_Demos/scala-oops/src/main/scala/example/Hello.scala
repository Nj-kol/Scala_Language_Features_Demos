package example

import example.traits._

object Hello extends App {

  def testMixins() {

    // Example 1
    val zeus = new Dog("Zeus")
    zeus.ownerIsHome
    zeus.jumpForJoy

    // Example 2
    val a = new ChocolateIceCream()
    println(a.hasChocolate)

    val b = new ChocolateCaramelIceCream()
    println(b.hasChocolate)
    println(b.hasCaramelSwirl)

    val c = new CaramelIceCreamSundae()
    println(c.hasChocolate)
    println(c.hasCaramelSwirl)
    println(c.hasPecans)

    // Example 3
    val app = new MyApp()
    app.doSomething()
  }

  def testStackable() {
    
    val queue = (new BasicIntQueue with Incrementing with Filtering)
    queue.put(-1)
    queue.put(0)
    queue.put(1)

    queue.get()
    queue.get()
  }

}