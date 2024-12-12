package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Recette
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecetteDAO: JpaRepository<Recette, Long> {
}