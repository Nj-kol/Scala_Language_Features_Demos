package example.specialtypes

case class UserId (id: Int) extends AnyVal
case class UserName(name: String) extends AnyVal
case class TweetId(id:Int) extends AnyVal
case class TweetContent(content:String) extends AnyVal

case class User (id: UserId,name: UserName)
case class Tweet(id: TweetId,content:TweetContent)