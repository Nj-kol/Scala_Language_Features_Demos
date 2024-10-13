package example.specialtypes

sealed trait FileState
final class Opened extends FileState
final class Closed extends FileState

trait FileHandle[State <: FileState] {
  
  def write[T >: State <: Opened](line: String): Unit
  def close: FileHandle[Closed]
}

object demoPhantomType extends App {

  def open(path: String): FileHandle[Opened] = new FileHandle[Opened] {
    def write[Opened](line: String): Unit = println(line)
    def close: FileHandle[Closed] = this.asInstanceOf[FileHandle[Closed]]
  }

  // Works fine
  val fh = open("/tmp/foo.txt")
  fh.write("bar")

  val fh2 = fh.close
  //fh2.write("rejected son!") // Error as compiler will reject writing to files that are already closed!
  
   // val fh3: FileHandle[FileState] = fh.close

}