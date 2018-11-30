package agileengine

import scala.collection.mutable

package object extensions {

  implicit class IteratorExtension[T](iterator: java.util.Iterator[T]) {

    def toList: List[T] = {
      val elements: mutable.MutableList[T] = mutable.MutableList()
      iterator.forEachRemaining(element => elements += element)
      elements.toList
    }
  }
}
