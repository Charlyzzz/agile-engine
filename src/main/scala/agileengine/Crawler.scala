package agileengine

import agileengine.querybuilders._

import scala.io.Source

object Crawler {

  def apply(originalHtmlPath: String, differentHtmlPath: String): String = {

    val desiredElementId = "make-everything-ok-button"
    val originalHtml: String = Source.fromFile(originalHtmlPath).getLines().mkString
    val differentHtml: String = Source.fromFile(differentHtmlPath).getLines().mkString
    val result = ElementFinderById(desiredElementId, originalHtml)
      .flatMap(desiredElement => {
        val query = typeTagAndClasses(desiredElement)
        ElementFinderByCriteria.matchBy(query, differentHtml)
      })

    result match {
      case Some(foundMatch) => s"Element was found at: ${ foundMatch.locationInDocument }"
      case None             => "Element not found :("
    }
  }
}
