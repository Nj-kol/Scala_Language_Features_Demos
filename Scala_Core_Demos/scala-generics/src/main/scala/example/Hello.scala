package example

object Hello extends App {

  def demoSimpleTypes() {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop) // prints 2
    println(stack.pop) // prints 1
  }

  def demoUpperTypeBouunds() {

    val animal = new Animal
    val dog = new Dog
    val puppy = new Puppy

    val animalCarer = new AnimalCarer
    animalCarer.displayUpperBound(dog)
    // Puppy is a sub type of Dog
    animalCarer.displayUpperBound(puppy)

    val animalCarer2 = new AnimalCarer
    animalCarer2.displayUpperBound(dog)
    animalCarer2.displayUpperBound(puppy)
    // Animal is not a subtype of Dog
    //animalCarer.display(animal) // Error
  }

  def demoLowerTypeBouunds() {
    val firstOrder = new Order[Vegan](new Vegan)
    val secondOrder = new Order[Vegetarian](new Vegetarian)
    val failOrder = new Order[Ominivore](new Ominivore) // doesn't work
  }

  def demoMixedBouunds() {

    // this won't compile
    // val parking1 = new Parking[AnyRef](new AnyRef)

    // this will compile
    val parking2 = new Parking[Bicycle](new Bicycle)

    // this won't compile
    //  val parking3 = new Parking[Thing](new Thing {})

  }
}
