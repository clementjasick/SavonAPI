package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class LigneIngredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ligneIngredient: Long,
    var nom: String,
    ) {
}