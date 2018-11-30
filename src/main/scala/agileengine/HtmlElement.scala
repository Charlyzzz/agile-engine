package agileengine

import agileengine.extensions._
import org.jsoup.nodes.Element

case class HtmlElement(element: Element) {

  def locationInDocument: String = (parentsNames ++ name).mkString(">")

  private def parents: List[Element] = element.parents().iterator().toList.reverse

  private def parentsNames = {
    parents.map(parent => {
      val parentName = parent.tagName()
      val childIndex = parent.siblingIndex() - 1
      val isOnlyChild = childIndex == 0
      if (isOnlyChild) {
        parentName
      } else {
        s"$parentName[$childIndex]"
      }
    })
  }

  private def name = element.tagName()

  def properties = ElementProperties.fromElement(element)
}
