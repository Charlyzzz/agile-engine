package agileengine

import org.scalatest._

class ElementFinderByIdSpec extends FreeSpec with Matchers {

  "An element finder" - {

    "#findById" - {

      val smallHTML =
        """"
          |<!DOCTYPE html>
          |<html lang="en">
          | <body>
          |   <div id="some-id" class="foo bar" href="baz">
          |   </div>
          | </body>
          |
          |</html>
          |
        """.stripMargin

      "returns an element if found" in {
        val elementFinderById = new ElementFinderById
        val foundElement = elementFinderById("some-id", smallHTML)
        foundElement should not be empty
      }

      "returns None if not found" in {
        val elementFinderById = new ElementFinderById
        val found = elementFinderById("some-id2", smallHTML)
        found shouldBe empty
      }

      "returned element contains its tag and attributes" in {
        val elementFinderById = new ElementFinderById
        val Some(ElementProperties(foundTag, foundClasses, foundProperties, foundHref)) = elementFinderById("some-id", smallHTML)
        foundProperties should contain("id" -> "some-id")
        foundClasses should contain allOf("foo", "bar")
        foundHref shouldBe "baz"
        foundTag shouldBe "div"
      }
    }
  }
}