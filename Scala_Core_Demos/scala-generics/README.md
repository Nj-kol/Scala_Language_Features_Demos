# Scala Generics

## Variance in Scala

* Variance ***defines the subtyping relationship among type constructors***, using the subtyping relationship among the types that bind their type variables. 
* For a type constructor F[_], if B is a subtype of A, variance describes the relationship between the type F[B] and the type F[A]
  - F[_] is *covariant* if B is a subtype of type A and F[B] is a subtype of type F[A]. 
  - F[_] is *contravariant* if B is a subtype of type A and F[A] is a subtype of type F[B]
  - F[_] is *invariant* if any subtype relationship between types A and B is not preserved in any order between types F[A] and F[B].
* Scala lets you declare the variance of a type by annotating the type parameter

	1. class C[+A] { ... } : C is *Covariant*
	2. class C[-A] { ... } : C is *Contravariant*
	3. class C[A]  { ... } : C is *Invariant*
	
* Invariance is the only type of relationship available in many programming languages that allows the use of type constructors, similar to Java and C++.

* So functions are *contravariant* in their argument type(s) and *covariant* in their result type

### Here’s a rule of thumb

* When your generic type ***“contains“*** or ***“produces“*** elements of type T, it should be **covariant**. Examples of covariant concepts: a cage (holds animals), a garage (holds cars), a factory (creates objects), a list (and any other collection).
* When your generic type ***“acts on“”*** or ***“consumes”*** elements of type T, it should be **contravariant**. Examples of contravariant concepts: a vet (heals animals), a mechanic (fixes cars), a garbage pit (consumes objects), a function (it acts on/it’s applied on arguments).

## Type Bounds

* Type Bounds are restrictions on Type Parameters or Type Variables. By using Type Bounds, we can define the limits of a Type Variable
* Scala Type Bounds help us is Type-Safe Application Development
* Scala supports the following Type Bounds for Type Variables:

	1. Upper Bounds
	2. Lower Bounds
	3. View Bounds

* In General :

	T <: S means T is a subtype of S
	T >: S means T is a supertype of S, or   S is a subtype of T

#### Upper Bounds

* In Scala, we can define Upper Bound on Type Parameter as shown below:

	```
    T <: S
	```
	
* Here T is a Type Parameter and S is a type. By declaring Upper Bound like [T <: S] means this Type Parameter T must be either same as S or subtypes of S

#### Lower Bounds

* In Scala, we can define Upper Bound on Type Parameter as shown below:

	```
	T >: S
	```

* Here T is a Type Parameter ans S is a type. By declaring Lower Bound like *[T >: S]* means this Type Parameter T must be either same asS or Super-Type of S

#### View Bounds

* In Scala, ***View Bound is used when we want to use existing Implicit Conversions automatically.***
* We can define View Bound on Type Parameter as shown below:

	```
	[T <% S]
	```

* A view bound was a mechanism introduced in Scala to enable the use of some type A as if it were some type B. It helps in using existing Implicit Conversions automatically. The typical syntax is this:

	```
	def f[A <% B](a: A) = a.bMethod
	```

## Mixing bounds

* It is also possible to mix a lower bound with an upper bound

  ```
  [S >: NonEmpty :< IntSet]
  ```
 
  would restrict S  any type on the interval between  NonEmpty and InSet

