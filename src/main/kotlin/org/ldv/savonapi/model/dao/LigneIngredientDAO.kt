package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.LigneIngredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LigneIngredientDAO: JpaRepository<LigneIngredient, Long> {
}