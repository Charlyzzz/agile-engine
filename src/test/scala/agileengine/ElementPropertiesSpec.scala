package agileengine

import org.scalatest._

class ElementPropertiesSpec extends FreeSpec with Matchers {

  "An element property" - {

    "#toCssQueryString" - {

      "returns its sepresentation as a selector query" in {
        val elementProperty = ElementProperties(
          tag = "a",
          classes = List("foo", "bar"),
          attributes = Map("title" -> "quux"),
          href = "baz"
        )
        elementProperty.fullQueryString shouldBe "a.foo.bar[title=quux][href*=baz]"
      }
    }
  }
}