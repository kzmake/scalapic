package domain.entity

import domain.entity._
import domain.vo._

import scala.util.Random

final case class Plasma(
    id: PlasmaId,
    ions: Seq[Particle],
    eles: Seq[Particle],
    e: Field,
    m: Field,
    j: Field
) extends Entity[PlasmaId]
object Plasma {
  implicit def genParticleId = () => {
    var n = 0L
    n = n + 1
    ParticleId.apply(n.toString())
  }

  def apply(n: Int, q: Charge, m: Mass, x: Int, y: Int, z: Int): Plasma = {
    val r = new Random()

    new Plasma(
      PlasmaId("2"),
      Vector.fill(n)(
        Particle.apply(
          Charge(q.value),
          m,
          Vec.apply(r.nextDouble(), r.nextDouble(), r.nextDouble()),
          Vec.apply(r.nextDouble(), r.nextDouble(), r.nextDouble())
        )
      ),
      Vector.fill(n)(
        Particle.apply(
          Charge(-q.value),
          m,
          Vec.apply(r.nextDouble(), r.nextDouble(), r.nextDouble()),
          Vec.apply(r.nextDouble(), r.nextDouble(), r.nextDouble())
        )
      ),
      Field.apply(x, y, z),
      Field.apply(x, y, z),
      Field.apply(x, y, z)
    )
  }
}
