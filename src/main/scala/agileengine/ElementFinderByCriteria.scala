package agileengine

import org.jsoup.Jsoup

object ElementFinderByCriteria {

  def matchBy(criteria: SearchCriteria, html: String) = {
    val document = Jsoup.parse(html)
    val elementsFound = Option(document.select(criteria.querySelectorString))

    elementsFound.flatMap {
      case elements if elements.size() == 0 => None
      //We should definitely log here that we found several elements. I dont think an exception should be thrown
      case elements => Some(elements.first())
    }.map(ElementProperties.fromHTMLElement)
  }
}
