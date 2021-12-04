package domain.entity

import domain.vo._

final case class Particle(id: ParticleId, q: Charge, m: Mass, r: Vec, v: Vec) extends Entity[ParticleId]

object Particle {
  def apply(q: Charge, m: Mass, r: Vec, v: Vec)(implicit
      genParticleId: () => ParticleId
  ): Particle = {
    Particle.apply(genParticleId(), q, m, r, v)
  }

  def random(q: Charge, m: Mass)(implicit
      genParticleId: () => ParticleId,
      randomPosition: () => Vec,
      normalVelocity: () => Vec
  ): Particle = {
    Particle.apply(genParticleId(), q, m, randomPosition(), normalVelocity())
  }
}
