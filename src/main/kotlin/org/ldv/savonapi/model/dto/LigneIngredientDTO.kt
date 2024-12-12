package org.ldv.savonapi.model.dto

class LigneIngredientDTO (
    var ingredientId:Long,
    var recetteId:Long?,
    var quantite: Double,
    var pourcentage: Double,
){
}