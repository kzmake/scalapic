package domain.entity

import domain.entity._
import domain.vo._
import com.chatwork.scala.ulid.ULID

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
  implicit def genParticleId = () => ParticleId.apply(ULID.generate().asString)

  def apply(n: Int, q: Charge, m: Mass, x: Int, y: Int, z: Int): Plasma = {
    val r = new Random()

    new Plasma(
      PlasmaId("1"),
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
