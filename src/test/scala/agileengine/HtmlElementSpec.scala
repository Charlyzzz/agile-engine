package agileengine

import agileengine.querybuilders.typeTagAndClasses
import org.scalatest._

class HtmlElementSpec extends FreeSpec with Matchers {


  "#locationInDocument" - {

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

    "returns its nested path" in {
      val query = typeTagAndClasses("a", List("success", "wavy"))
      val Some(foundElement) = ElementFinderByCriteria.matchBy(query, smallHTML)
      foundElement.locationInDocument shouldBe "html>body>div[1]>a"
    }
  }
}
