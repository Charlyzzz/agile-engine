package agileengine

import org.scalatest._

class ElementPropertiesWrapperSpec extends FreeSpec with Matchers {

  "ElementPropertiesWrapper" - {

    "#pathInDocument" - {

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

      "returns its relative path from the document" in pending
    }
  }
}
