# Enumerations in Scala

* Unlike Java, there is no `enum` keyword in Scala
* However, you can create an enum in scala by extending the `scala.Enumeration` Class

```java
package com.acme.app {

 object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
 }
}
```

* Usage

```java
import com.acme.app.Weekday._

// use an enumeration value in a test
var today = Sunday

// later in the code ...
if (today == Sunday) println("Today is a holiday")

// print all the enumeration values
import com.acme.app.Weekday
Weekday.values foreach println
}
```

## References

https://alvinalexander.com/scala/how-to-use-scala-enums-enumeration-examples

https://pedrorijo.com/blog/scala-enums/

https://medium.com/@yuriigorbylov/scala-enumerations-hell-5bdba2c1216
