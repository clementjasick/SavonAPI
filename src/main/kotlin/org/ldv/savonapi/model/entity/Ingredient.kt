package org.ldv.savonapi.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ingredientId: Long,
    var nom: String,
    var iode: Double,
    var ins: Double,
    var douceur: Double,
    var lavant: Double,
    var volMousse: Double,
    var tenueMousse: Double,
    var durete: Double,
    var solubilite: Double,
    var sechage: Double,
) {
}