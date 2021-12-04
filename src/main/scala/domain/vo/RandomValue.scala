package domain.vo

trait RandomValue[T] {
  def value: T
}

object RandomValue {
  implicit object RandomDoubleValue extends RandomValue[Double] {
    def value: Double = 0.2
  }

  private val _value = new RandomValue[AnyRef] {
    def value: AnyRef = null
  }

  // to avoid creation of RandomValue[AnyRef] instance.
  implicit def RandomAnyRef[T >: Null <: AnyRef]: RandomValue[T] = {
    _value.asInstanceOf[RandomValue[T]]
  }

  def random[T: RandomValue]: T = implicitly[RandomValue[T]].value
}
