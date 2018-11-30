package agileengine


object CrawlerApp {

  def main(args: Array[String]): Unit = {
    val crawlResult = args.toList match {
      case originalHtmlPath :: differentHtmlPath :: _ => Crawler(originalHtmlPath, differentHtmlPath)
      case _                                          => throw new IllegalStateException("Parameters are missing!")
    }

    println(crawlResult)
  }
}
