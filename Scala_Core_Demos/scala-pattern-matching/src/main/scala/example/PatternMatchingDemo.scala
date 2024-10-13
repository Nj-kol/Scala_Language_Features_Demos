package example

sealed trait Account
case class Paypal(email: String) extends Account
case class Bitcoin(key: String) extends Account
case class User(name: String,account: Account)


