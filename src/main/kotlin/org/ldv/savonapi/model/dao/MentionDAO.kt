package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.Mention
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MentionDAO: JpaRepository<Mention, Long> {
    @Query("SELECT m FROM Mention m WHERE m.caracteristique = :caracteristique AND :score BETWEEN m.scoreMin AND m.scoreMax ")
    fun findMentionByScoreAndCaracteristique(
        @Param("score") score : Double,
        @Param("caracteristique") caracteristique: Caracteristique
    ): Mention?



}