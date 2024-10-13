package com.njkol

trait Friends {

  def saySomething: String
}

object Joey extends Friends {

  override def saySomething() : String = {
    "How you doin?"
  }
}

object Chandler extends Friends {

  override def saySomething() : String = {
   "Could I BE wearing anymore clothes?"
  }
}

object Monica extends Friends {

  override def saySomething() : String = {
   "I am always the hostess!!"
  }
}

object Phoebe extends Friends {

  override def saySomething() : String = {
    "Smelly cat.. Smelly cat .. what are they feeding you?"
  }
}

object Ross extends Friends {

  override def saySomething() : String = {
   "We were on a break!!"
  }
}

object Rachel extends Friends {

  override def saySomething() : String = {
   "I am gonna go and get one of those job things !!"
  }
}


