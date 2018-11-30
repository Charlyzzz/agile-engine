package agileengine

import org.jsoup.Jsoup

object ElementFinderByCriteria {

  def matchBy(query: String, html: String): Option[HtmlElement] = {
    val document = Jsoup.parse(html)
    val elementsFound = Option(document.select(query))

    elementsFound.flatMap {
      case elements if elements.size() == 0 => None
      //We should definitely log here that we found several elements. I dont think an exception should be thrown
      case elements => Some(elements.first)
    }.map(HtmlElement)
  }
}
