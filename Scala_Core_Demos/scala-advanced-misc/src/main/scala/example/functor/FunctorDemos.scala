package example.functor

import scala.language.higherKinds

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object demoFunctors extends App {

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  def inc(list: List[Int])(implicit func: Functor[List]) = func.map(list)(_ + 1)

  inc(List(1, 2, 3))
}

