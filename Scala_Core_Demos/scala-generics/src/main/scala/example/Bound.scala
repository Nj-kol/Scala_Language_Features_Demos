package example

class Animal
class Dog extends Animal
class Puppy extends Dog
class SweetPuppy // extends Puppy

class AnimalCarer {

  // Accepts any sub type of Dog
  def displayUpperBound[T <: Dog](t: T) {
    println(t)
  }
}

class Vegan
class Vegetarian extends Vegan
class Ominivore extends Vegetarian
class Order[T >: Vegetarian](meal: T)

trait Thing

class Vehicle extends Thing

class Car extends Vehicle

class Jeep extends Car
class Coupe extends Car

class Motorcycle extends Vehicle
class Bicycle extends Vehicle

class Tricycle extends Bicycle

// We need to restrict parking to all subtypes of vehicle, above Tricycle

class Parking[T >: Bicycle <: Vehicle](val plaza: T)
