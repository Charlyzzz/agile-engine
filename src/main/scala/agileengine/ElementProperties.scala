package agileengine

import org.jsoup.nodes.Element

import scala.collection.mutable

object ElementProperties {
  def fromHTMLElement(element: Element): ElementProperties = {
    var attributes: Map[String, String] = Map.empty
    element.attributes().iterator()
      .forEachRemaining(attribute => attributes = attributes + (attribute.getKey -> attribute.getValue))
    ElementProperties(
      element.tagName(),
      attributes("class").split(" ").toList,
      attributes - "href" - "class",
      attributes("href")
    )
  }
}

case class ElementProperties(tag: String, classes: List[String], attributes: Map[String, String], href: String = "") {

  def fullQueryString = {
    tagAndClasses + mergedAttributes + hrefAttribute
  }

  def tagAndClasses = {
    List(tag) ++ classes mkString "."
  }

  def mergedAttributes = {
    attributes.map {
      case (name, value) => toBrackets(name, value)
    }
      .mkString
  }

  def hrefAttribute = {
    if (href.isEmpty) {
      ""
    } else {
      toBrackets("href*", href)
    }
  }

  def toBrackets(name: String, value: String) = {
    s"[$name=$value]"
  }
}

case class ElementPropertiesWrapper(element: Element) {

  def parents: Unit = {
    val elementParents: mutable.MutableList[String] = mutable.MutableList()
    element.parents().iterator().forEachRemaining(parent => {
      elementParents += parent.tagName()
    })

    (elementParents.reverse += element.tagName()) mkString ">"
    //Time is over :(
    //
  }

}

