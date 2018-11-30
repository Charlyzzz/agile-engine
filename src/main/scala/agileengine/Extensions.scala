package agileengine

import org.jsoup.nodes.Element

import scala.collection.mutable

package object extensions {

  implicit class IteratorExtension[T](iterator: java.util.Iterator[T]) {

    def toList: List[T] = {
      val elements: mutable.MutableList[T] = mutable.MutableList()
      iterator.forEachRemaining(element => elements += element)
      elements.toList
    }
  }

  implicit class ElementExtension(element: Element) {

    def indexBetweenSameTypeSiblings(): Int = {
      val sameTypeBrothers = element.parent().children().toArray()
        .toList.asInstanceOf[List[Element]]
        .filter(element.tagName() == _.tagName())

      sameTypeBrothers.indexOf(element)
    }
  }

}
