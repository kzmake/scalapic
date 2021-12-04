package domain.entity

import domain.vo.EntityId

trait Entity[Id <: EntityId] {
  val id: Id
}
