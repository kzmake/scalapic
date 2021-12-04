package domain.vo

trait ZeroValue[T] {
  def value: T
}

object ZeroValue {
  implicit object ZeroDoubleValue extends ZeroValue[Double] {
    def value: Double = 0.0
  }

  private val _value = new ZeroValue[AnyRef] {
    def value: AnyRef = null
  }

  // to avoid creation of ZeroAnyRef[AnyRef] instance.
  implicit def ZeroAnyRef[T >: Null <: AnyRef]: ZeroValue[T] = {
    _value.asInstanceOf[ZeroValue[T]]
  }

  def zero[T: ZeroValue]: T = implicitly[ZeroValue[T]].value
}
