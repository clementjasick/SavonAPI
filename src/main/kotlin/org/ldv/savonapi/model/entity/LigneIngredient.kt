package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.ldv.savonapi.model.id.LigneIngredientId

@Entity
class LigneIngredient(
    @EmbeddedId
    var ligneIngredientId: LigneIngredientId?,
    @MapsId("ingredientId")
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    var ingredient: Ingredient? = null,

    @MapsId("recetteId")
    @ManyToOne
    @JoinColumn(name = "recetteId")
    var recette: Recette? = null,

    var quantite: Double,
    var pourcentage: Double
    ) {
}