package agileengine

import agileengine.extensions._
import org.jsoup.nodes.Element

object ElementProperties {

  def fromElement(element: Element): ElementProperties = {
    val attributesMap: Map[String, String] = element.attributes().iterator()
      .toList
      .map(attribute => (attribute.getKey, attribute.getValue))
      .toMap

    ElementProperties(
      element.tagName(),
      attributesMap.getOrElse("class", "").split(" ").toList,
      attributesMap - "href" - "class",
      attributesMap.getOrElse("href", "")
    )
  }
}

case class ElementProperties(tag: String, classes: List[String], attributes: Map[String, String], href: String = "")

