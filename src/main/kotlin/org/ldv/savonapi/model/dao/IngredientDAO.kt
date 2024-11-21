package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IngredientDAO: JpaRepository<Ingredient, Long> {
}