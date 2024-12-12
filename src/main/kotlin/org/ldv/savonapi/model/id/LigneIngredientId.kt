package org.ldv.savonapi.model.id

import java.io.Serializable

class LigneIngredientId(
    val ingredientId: Long,
    val recetteId: Long,
):Serializable {
}