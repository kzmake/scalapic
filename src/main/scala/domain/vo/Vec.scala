package domain.vo

case class Vec(x: Double, y: Double, z: Double) extends ValueObject

object Vec {
  def zero(): Vec = {
    Vec.apply(ZeroValue.zero[Double], ZeroValue.zero[Double], ZeroValue.zero[Double])
  }

  def random(): Vec = {
    Vec.apply(RandomValue.random[Double], RandomValue.random[Double], RandomValue.random[Double])
  }
}
