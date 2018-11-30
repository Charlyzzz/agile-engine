package agileengine

package object querybuilders {

  def typeTagAndClasses(tag: String, classes: List[String]): String = {
    List(tag) ++ classes mkString "."
  }

  def typeTagAndClasses(htmlElement: HtmlElement): String = {
    htmlElement.properties match {
      case ElementProperties(tag, classes, _, _) => typeTagAndClasses(tag, classes)
    }
  }

  def fullMatch(elementProperties: ElementProperties): String = {
    typeTagAndClasses(elementProperties.tag, elementProperties.classes) +
      mergedAttributes(elementProperties.attributes) +
      hrefAttribute(elementProperties.href)

  }

  private def mergedAttributes(attributes: Map[String, String]): String = {
    attributes.map {
      case (name, value) => toBrackets(name, value)
    }
      .mkString
  }

  private def toBrackets(name: String, value: String) = {
    s"[$name=$value]"
  }

  private def hrefAttribute(href: String) = {
    if (href.isEmpty) {
      ""
    } else {
      toBrackets("href*", href)
    }
  }

}
