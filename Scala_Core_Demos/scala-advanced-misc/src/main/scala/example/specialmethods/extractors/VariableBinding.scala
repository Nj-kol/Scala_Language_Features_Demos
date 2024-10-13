package example

trait Player {
  def name: String
}

class FootBallPlayer(val name: String, val club: String, val score: Int) extends Player

// Companion object of FootBallPlayer
object FootBallPlayer {
  def unapply(arg: FootBallPlayer): Option[(String, String, Int)] = Some((arg.name, arg.club, arg.score))
}

class RugbyPlayer(val name: String, val goals: Int) extends Player

// Companion object of RugbyPlayer
object RugbyPlayer {
  def unapply(arg: RugbyPlayer): Option[(String, Int)] = Some(arg.name, arg.goals)
}

