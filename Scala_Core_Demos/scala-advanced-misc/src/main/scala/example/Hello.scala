package example

object Hello extends App {

  def demoLazyVal() {

    lazy val number = { println("Constant number is initialized."); 99 }

    println("Before Accessing 'number' constant:")

    // Evaluated only the first time it is accessed
    println(number + 1)

    // Subsequent invocations have no effect
    println(number + 1)
    println(number + 1)
  }

  def demoMultipleParameterList() {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // Multiple parameter list
    val res = numbers.foldLeft(0)((m, n) => m + n)
  }
  
  def demoPartialApplication() {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // Placeholder syntax to trigger partial application
    val numberFunc = numbers.foldLeft(List[Int]()) _
    val squares = numberFunc((xs, x) => xs :+ x * x)
    print(squares) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
    val cubes = numberFunc((xs, x) => xs :+ x * x * x)
    print(cubes) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)
  }

  def demoExtractors() {
    val user: User = new FreeUser("Daniel", 3000, 0.7d)
    user match {
      case FreeUser(name, _, p) => if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
      case PremiumUser(name, _) => "Welcome back, dear " + name
    }
  }

  def demoBooleanExtractors() {
    val user: User = new FreeUser("Lewis", 2500, 0.8d)
    user match {
      case freeUser @ premiumCandidate() => println(freeUser.name)
      case _ => println(user.name)
    }
  }

  def demoVarialbleBinding() {

    def selectedPlayers(listOfPlayers: List[Player], selectionScore: Int) = listOfPlayers.map {
      case fPlayer @ FootBallPlayer(_, _, score) if score > selectionScore => Some(fPlayer)
      case rPlayer @ RugbyPlayer(_, goals) if goals > selectionScore => Some(rPlayer)
    }

    val ps = List(new RugbyPlayer("Jean", 7), new RugbyPlayer("Claude", 8), new RugbyPlayer("Van Damme", 9))

    selectedPlayers(ps, 3) foreach (p => println(p.get.name))
  }

  def demoInfixExtractor() {

    val list = 11 :: 2 :: 3 :: Nil

    list match {
      case head :: tail => tail.map(_ * head)
      case head :: Nil => head - 1
    }

    val stream = 58 #:: 43 #:: 93 #:: Stream.empty

    stream match {
      case first #:: second #:: _ => (first, second)
      case _ => (-1, -1)
    }
  }

}