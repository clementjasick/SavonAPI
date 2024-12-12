package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ingredientId: Long,
    var nom: String,
    var sapo: Double,
    var iode: Double,
    var ins: Double,
    var douceur: Double,
    var lavant: Double,
    var volMousse: Double,
    var tenueMousse: Double,
    var durete: Double,
    var solubilite: Double,
    var sechage: Double,

    @OneToMany(mappedBy = "ingredient")
    val ligneIngredient: List<LigneIngredient>? = mutableListOf()

) {
}