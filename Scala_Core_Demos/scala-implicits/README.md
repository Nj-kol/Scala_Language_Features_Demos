# Implicits

* Implicits are a way of describing context

* The real world defination of implicit is somethings things 
  that are understood by context

## Traditional ways to express context

* Global
   * rigid if immutable
   * unsafe if mutable
   * Ex - Singletons

* Dependency injection
   * At runtime ( Spring,Guice )
   * Or with macros (MacWire)

* Monkey patching
* Cake pattern
* closure coupling + recursion

## Ground rules

* If you do not give an argument to an implicit parameter, one will be provided  for you.
* Eligible are all implicit values  that are visible *at the point of call*
* If there are more than one eligible candidate, the most specific one os chosen
* If there is no unique or most specific candidatean *ambiguity* error is raised

## What types of Scala implicits are there?

1. Implicit parameters

2. Implicit conversions (implicit functions)

3. Implicit classes ( Used for *extension methods* )

3. Implicit objects

# Patterns of Implicit Conversion

## Extension methods 

* Add new methods to an existing class , without changing
  the original class

* Achieved by using Implicit classes

## Late Trait Implementation

* make existing classes implement new traits without
  changing their code 

* This was the original reason for implicits in Scala

```
implicit class StringDeco(x: String) extends Ordered[String] {
	
	def <(other: String) = ???
}
```

## Other

* cached implicit classes

**context-dependent views**

class Symbol {
	
	implicit def denot(implicit ctx: Context) : SymDenotation
}

class SymDenotation {
	
	def owner : Symbol
	def name : String
	def info : Type
}

## Anti patterns

* Conversions that go both ways
* Conversions that change semantics
* Conversions that undermine type safety
  
  implicit def toTermName(s: String) : TermName 

* Conversions between pre-exisitng types

Reference
=========
https://apiumhub.com/tech-blog-barcelona/scala-implicits/

Keynote - What to Leave Implicit by Martin Odersky : https://www.youtube.com/watch?v=Oij5V7LQJsA ( seen till 37 min )
