# Pattern Matching Scala

Pattern matching is mainly concerned with object comparison.
 
The default case is the catch-all case _pattern. It is a good idea to have such a catch-all pattern.  If no pattern matches, a MatchError is thrown.
Unlike switch statement, Scala pattern matching  does not suffer from the *fall-through problem.  In C and its derivatives, you must use explicit break statements to exit a switch at the end of each branch, or you will fall through to the next branch. This could be error prone. Similar to if, match is an expression, not a statement.

## Type matching

The most fundamental example of object comparison is *type checking(also called typed pattern matching)*.It is akin to using *instanceof* operator in Java. However unlike Java, there is no need to explicitly cast the type, as Scala automatically binds the value on a pattern match

```java
obj match {
	case x: Int    => x
	case s: String => Integer.parseInt(s)
	case y: BigInt => Int.MaxValue
	case _ => 0	
}
```

Matches occur at runtime, and generic types are erased in the JVM. For that reason, you cannot make a type match for a specific  Maptype

  ```
  case m: Map[String,Int] =>  ... // Don't do this
  ```

You can match a generic map :

  ```
  case m: Map[_,_] => ... // OK
  ```

## Pattern matching use case

Pattern matching can be used when the following conditions occur :

	1. Deconstructing objects
	2. Type checking
	3. Testing if and taking action

## Pattern Matching with Guard statement

* You can add a guard clause to a pattern
* The guard clause can be any boolean condition

```java
val output = inputDay match {
	case weekend if weekend == "saturday" || weekend == "sunday" => "Hurrah! Weekend"
	case weekday => s"Today is $weekday, catch the bus"
}
```

## Patterns on val creation

```java
def getTuple: (User,Account) = ...
// Decompose the tuple, no need for _1 and _2 accessors
val (user,account) = getTuple 
```
