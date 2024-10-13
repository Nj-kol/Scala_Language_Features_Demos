package example

sealed abstract class Weekday(
  val name: String,
  val abbreviation: String,
  val isWeekDay: Boolean,
  val order: Int) extends Ordered[Weekday] {

  def compare(that: Weekday) = this.order - that.order
}

case object Monday extends Weekday("Monday", "Mo.", true, 2)
case object Tuesday extends Weekday("Tuesday", "Tu.", true, 3)
case object Wednesday extends Weekday("Wednesday", "We.", true, 4)
case object Thursday extends Weekday("Thursday", "Th.", true, 5)
case object Friday extends Weekday("Friday", "Fr.", true, 6)
case object Saturday extends Weekday("Saturday", "Sa.", false, 7)
case object Sunday extends Weekday("Sunday", "Su.", false, 1)
