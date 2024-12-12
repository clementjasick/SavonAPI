package org.ldv.savonapi.model.dto

class RecetteFromDTO(
    var recetteId: Long? = null,
    var nom :String,
    var surgraissage: Double,
    var alcalinType: Double,
    var concentrationAlcalin: Double,
    var LigneIngredients: MutableList<LigneIngredientDTO> = mutableListOf()
    ) {
}