package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteId: Long,
    var nom: String,
    ){
}