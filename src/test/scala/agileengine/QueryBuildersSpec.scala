package agileengine

import agileengine.querybuilders._
import org.scalatest._

class QueryBuildersSpec extends FreeSpec with Matchers {

  "querybuilders.typeTagAndClasses returns the expected query" in {
    typeTagAndClasses("a", List("bar")) shouldBe "a.bar"
  }

  "querybuilders.typeTagAndClasses without classes is just the tag" in {
    typeTagAndClasses("a", List.empty) shouldBe "a"
  }

  "querybuilders.fullMatch returns the expected query" in {
    val wantedDiv: ElementProperties = ElementProperties(
      "div",
      List("bar", "baz"),
      Map("id" -> "other-id"),
      "bar"
    )

    fullMatch(wantedDiv) shouldBe "div.bar.baz[id=other-id][href*=bar]"
  }
}
