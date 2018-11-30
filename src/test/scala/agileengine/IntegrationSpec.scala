package agileengine

import org.scalatest._

class IntegrationSpec extends FreeSpec with Matchers {


  "Crawler runs on sample 1" in {
    val original = "C:\\Users\\Erwin\\Documents\\Scala\\agile-engine\\src\\main\\resources\\sample-0-origin.html"
    val diff = "C:\\Users\\Erwin\\Documents\\Scala\\agile-engine\\src\\main\\resources\\sample-1-evil-gemini.html"
    val locationPath = Crawler(original, diff)
  }
}
