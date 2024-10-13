package com.njkol

import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite

/**
 * Test Scala Reflection Using Funsuite of Scalates
 */
class ScalaReflectionTest extends AnyFunSuite with BeforeAndAfterAll {

  var mathUtils: ScalaReflection = null

  override def beforeAll() {
    mathUtils = new ScalaReflection()
  }

  test("Test Loading of Monica") {
    val expected = "I am always the hostess!!"
    val someTrait = mathUtils.loadASomeTrait("com.njkol.Monica")
    val actual = someTrait.saySomething
    println(actual)
    assertResult(expected)(actual)
  }

    test("Test Loading of Joey") {
    val expected = "How you doin?"
    val someTrait = mathUtils.loadASomeTrait("com.njkol.Joey")
    val actual = someTrait.saySomething
    println(actual)
    assertResult(expected)(actual)
  }
}