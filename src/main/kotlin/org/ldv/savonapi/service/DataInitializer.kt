package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.entity.Ingredient
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
@Component
class DataInitializer (val ingredientDAO: IngredientDAO, val caracteristiqueDAO: CaracteristiqueDAO) : CommandLineRunner {
    override fun run(vararg args: String?) {
        //Pour importer les ingredients
        if (ingredientDAO.count() == 0L) { // Éviter les doublons
            var huileOlive=  Ingredient(1,"Huile d'olive",9.26,10.192,9.838,9.152,10.144,9.298,10.194,)
            var ingredients= listOf<Ingredient>(huileOlive)
            ingredientDAO.saveAll(ingredients)
        }
        // Pour importer les caracteristiques ...

    }
}