package agileengine

trait SearchCriteria {
  def querySelectorString: String
}


case class ExactMatch(elementProperties: ElementProperties) extends SearchCriteria {
  override def querySelectorString: String = elementProperties.fullQueryString
}

case class TagTypeAndClassesCriteria(elementProperties: ElementProperties) extends SearchCriteria {
  override def querySelectorString: String = elementProperties.tagAndClasses
}

//TODO define other search criteria