package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Resultat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultatDAO: JpaRepository<Resultat, Long> {
}