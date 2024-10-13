package com.njkol

import scala.reflect.runtime.universe

/**
 * Demonstrate Reflection capabilities of Scala
 * 
 * @author Nilanjan Sarkar
 */
// https://stackoverflow.com/questions/3039822/how-do-i-call-a-scala-object-method-using-reflection
class ScalaReflection {

  /**
   * @param className Fully qualified name of the class (Ex- "com.njkol.Monica")
   */
  def loadASomeTrait(className: String): Friends = {
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(className)
    val obj = runtimeMirror.reflectModule(module)
    obj.instance.asInstanceOf[Friends]
  }  
}