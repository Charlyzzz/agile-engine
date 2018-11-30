package agileengine

import agileengine.querybuilders._
import org.scalatest._

class ElementFinderByCriteriaSpec extends FreeSpec with Matchers {

  "An element finder by criteria" - {

    "#matchBy" - {

      val smallHTML =
        """"
          |<!DOCTYPE html>
          |<html lang="en">
          | <body>
          |   <div id="some-id" class="bar" href="bar">
          |
          |   </div>
          |   <div id="other-id" class="bar baz" href="bar">
          |     <a class="success wavy">
          |
          |     </a>
          |   </div>
          |
          |   <a id="some-id" class="bar" href="bar">
          |
          |   </a>
          | </body>
          |
          |</html>
          |
        """.stripMargin

      "returns None if no element matches" in {

        val query = typeTagAndClasses("button", List.empty)
        val foundElement = ElementFinderByCriteria.matchBy(query, smallHTML)
        foundElement shouldBe empty
      }

      "returns the element that matches" in {

        val query = typeTagAndClasses("a", List("success", "wavy"))
        val Some(foundElement) = ElementFinderByCriteria.matchBy(query, smallHTML)
        val foundElementProperties = foundElement.properties
        foundElementProperties.classes shouldBe List("success", "wavy")
        foundElementProperties.tag shouldBe "a"
        foundElementProperties.href shouldBe empty
      }
    }
  }
}


