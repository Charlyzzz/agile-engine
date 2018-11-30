package agileengine

object CrawlerAppIntegration extends App {

  val originalFile = getClass.getResource("/sample-0-origin.html").getPath
  val diffPaths = List(
    getClass.getResource("/sample-1-evil-gemini.html").getPath,
    getClass.getResource("/sample-2-container-and-clone.html").getPath,
    getClass.getResource("/sample-3-the-escape.html").getPath,
    getClass.getResource("/sample-4-the-mash.html").getPath
  )

  for (
    (diffPath, runNumber) <- diffPaths.zipWithIndex;
    result = Crawler(originalFile, diffPath)
  ) println(s"Run #$runNumber result was: $result")
}
