package agileengine

import org.scalatest._

class ExampleSpec extends FreeSpec {

  "A Set" - {

    "(when empty)" - {

      "should have size 0" in {
        assert(Set.empty.size == 0)
      }
      "should produce NoSuchElementException when head is invoked" in {
        intercept[NoSuchElementException] {
          Set.empty.head
        }
      }
      "should should be empty" ignore {
        assert(Set.empty.isEmpty)
      }
    }

    "(when non-empty)" - {

      "should have the correct size" in {
        assert(Set(1, 2, 3).size == 3)
      }

      "return a contained value when head is invoked" is pending

      import tagobjects.Slow
      "should be non-empty" taggedAs Slow in {
        assert(Set(1, 2, 3).nonEmpty)
      }
    }
  }
}