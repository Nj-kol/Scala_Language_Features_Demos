package example.specialtypes

// Sum Type
sealed trait Direction
case object North extends Direction
case object South extends Direction
case object East extends Direction
case object West extends Direction

// Product Type
sealed trait Color
final case object White extends Color
final case object Black extends Color

sealed trait Name
final case object Pawn extends Name
final case object Rook extends Name
final case object Knight extends Name
final case object Bishop extends Name
final case object Queen extends Name
final case object King extends Name

case class ChessPiece(color: Color, name: Name)

// Sum of Product type
sealed trait Shape
final case class Circle(radius: Double) extends Shape
final case class Rectangle(width: Double, height: Double) extends Shape