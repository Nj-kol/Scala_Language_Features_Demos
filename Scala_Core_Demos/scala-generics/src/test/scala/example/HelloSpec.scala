package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFlatSpec with Matchers {

  "The Stack should pop" should "1" in {

    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop) // prints 2
    println(stack.pop) // prints 1
  }
}
