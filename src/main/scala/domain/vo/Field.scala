package domain.vo

import scala.collection.immutable.Vector

case class Field(x: Int, y: Int, z: Int, values: Vector[Vec])
object Field {
  def apply(x: Int, y: Int, z: Int): Field = {
    val values = Vector.fill(x * y * z)(Vec.zero())
    new Field(x, y, z, values)
  }
}
