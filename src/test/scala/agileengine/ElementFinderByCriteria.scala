package agileengine

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

      "given an ExactMatch criteria" - {

        "returns None if no element matches" in {
          val wantedDiv: ElementProperties = ElementProperties(
            "div",
            List.empty,
            Map("id" -> "foobar")
          )

          val criteria = ExactMatch(wantedDiv)
          val foundElement = ElementFinderByCriteria.matchBy(criteria, smallHTML)
          foundElement shouldBe empty
        }

        "returns the element that matches tag and attributes" in {

          val wantedDiv: ElementProperties = ElementProperties(
            "div",
            List("bar"),
            Map("id" -> "some-id"),
            "bar"
          )

          val criteria = ExactMatch(wantedDiv)
          val Some(foundElementProperties) = ElementFinderByCriteria.matchBy(criteria, smallHTML)
          foundElementProperties shouldBe wantedDiv
        }
      }

      "given a TagAndClasses criteria" - {

        "returns None if no element matches" in {
          val wantedDiv: ElementProperties = ElementProperties(
            "button",
            List.empty,
            Map("id" -> "foobar")
          )

          val criteria = TagTypeAndClassesCriteria(wantedDiv)
          val foundElement = ElementFinderByCriteria.matchBy(criteria, smallHTML)
          foundElement shouldBe empty
        }

        "returns the element that matches tag and attributes" in {

          val wantedDiv: ElementProperties = ElementProperties(
            "div",
            List("bar"),
            Map("id" -> "non-existant-id")
          )

          val criteria = TagTypeAndClassesCriteria(wantedDiv)
          val Some(foundElementProperties) = ElementFinderByCriteria.matchBy(criteria, smallHTML)
          foundElementProperties.classes shouldBe List("bar")
          foundElementProperties.tag shouldBe "div"
          foundElementProperties.href shouldBe "bar"
        }
      }
    }
  }
}
