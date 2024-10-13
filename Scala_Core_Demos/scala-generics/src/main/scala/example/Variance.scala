package example

/**
 * Reference - https://www.youtube.com/watch?v=b1ftkK1zhxI
 */

class Animal
class Dog(name: String) extends Animal

class MyInvariant[T]

class MyContraVariantList[-T]

object demonstrateVariance {

  // The variance question : If Dog <: Animal, does List[Dog] <: List[Animal] ?

  // If YES, then the type is called Covariant
  val laika = new Dog("Lassie")
  val hachi = new Dog("Hachi")
  val lassie = new Dog("Hachi")

  val anAnimal: Animal = lassie // dog
  val myDogs: List[Animal] = List(lassie, hachi, laika) // list of dogs is a list of animals

  //If NO, then the type is called Invariant
  // val myDogstoo: MyInvariant[Animal] = new MyInvariant[Dog] // will not compile
  val myDogs2: MyInvariant[Animal] = new MyInvariant[Animal]

  // No, quite the opposite
  val myDogs3: MyContraVariantList[Dog] = new MyContraVariantList[Animal]

  // Example of contravariance

  trait Vet[-T] {
    def heal(animal: T): Boolean
  }

  def gimmeAVet(): Vet[Dog] = {
    
    new Vet[Animal] {
      override def heal(animal: Animal) = {
        println("You'll be fine")
        true
      }
    }
  }

  val myDog4 = new Dog("Buddy")
  val myVet: Vet[Dog] = gimmeAVet()
  myVet.heal(myDog4)
}