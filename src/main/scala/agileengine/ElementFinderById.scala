package agileengine

import org.jsoup.Jsoup

object ElementFinderById {

  def apply(id: String, html: String): Option[HtmlElement] = {
    val document = Jsoup.parse(html)
    val foundElement = Option(document.getElementById(id))
    foundElement.map(HtmlElement)
  }
}
