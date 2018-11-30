package agileengine

import org.jsoup.Jsoup

class ElementFinderById {

  def apply(id: String, html: String): Option[ElementProperties] = {
    val document = Jsoup.parse(html)
    val foundElement = Option(document.getElementById(id))
    foundElement.map(ElementProperties.fromHTMLElement)
  }
}
