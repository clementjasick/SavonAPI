package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.*
import org.ldv.savonapi.model.dto.LigneIngredientDTO
import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.LigneIngredient
import org.ldv.savonapi.model.entity.Recette
import org.ldv.savonapi.model.entity.Resultat
import org.ldv.savonapi.model.id.LigneIngredientId
import org.springframework.stereotype.Service

@Service
class SimulateurService (
    val caracteristiqueDAO: CaracteristiqueDAO,
    val recetteDAO: RecetteDAO,
    val ingredientDAO: IngredientDAO,
    val ligneIngredientDAO: LigneIngredientDAO,
    val mentionDAO: MentionDAO,
    val resultatDAO: ResultatDAO,

){
    fun toLigne(ligneIngredientDTO: LigneIngredientDTO, recette: Recette): LigneIngredient {
        val ingredient = ingredientDAO.findById(ligneIngredientDTO.ingredientId)
            ?: throw NoSuchElementException("Aucun ingrédient trouvé pour l'ID ${ligneIngredientDTO.ingredientId}")
        val ligneIngredientId = LigneIngredientId(
            ingredientId = ingredient.get().ingredientId,
            recetteId = recette.recetteId
        )
        val ligneIngredient = LigneIngredient(
                ligneIngredientId = ligneIngredientId,
                quantite = ligneIngredientDTO.quantite,
                pourcentage = ligneIngredientDTO.pourcentage
        )
        return ligneIngredient
    }
/*    
    fun createResultats(recette: Recette): List<Resultat>{
        var caracteristiques = this.caracteristiqueDAO.findAll()            
            ?: throw NoSuchElementException("Aucun caracteristique trouvé pour ${caracteristiqueDAO}")

            }
*/
 


    }


