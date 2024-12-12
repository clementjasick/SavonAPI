package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.dao.MentionDAO
import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.Ingredient
import org.ldv.savonapi.model.entity.Mention
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    val ingredientDAO: IngredientDAO,
    val caracteristiqueDAO: CaracteristiqueDAO,
    private val mentionDAO: MentionDAO
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        //Pour importer les ingredients
        if (ingredientDAO.count() == 0L) { // Éviter les doublons
            val huileOlive= Ingredient(2,"Huile d'olive",189.0,78.0,111.0,9.26,10.192,9.838,9.152,10.144,9.298,10.194)
            val huileCoco= Ingredient(1,"Huile coco",257.0,9.0,248.0,7.746,14.462,13.326,9.56,9.39,11.204,11.88)

            val ingredients= listOf<Ingredient>(huileCoco,huileOlive)
            ingredientDAO.saveAll(ingredients)
        }
        if (caracteristiqueDAO.count() == 0L) { // Éviter les doublons
            val iode = Caracteristique(1,"iode")
            val ins = Caracteristique(2,"ins")
            val douceur = Caracteristique(3,"douceur")
            val lavant = Caracteristique(4,"lavant")
            val volMousse = Caracteristique(5,"vol mousse")
            val tenueMousse = Caracteristique(6,"tenue mousse")
            val durete = Caracteristique(7,"durete")
            val solubilite = Caracteristique(8,"solubilite")
            val sechage = Caracteristique(9,"sechage")







            val caracteristiques= listOf<Caracteristique>(iode,ins,douceur,lavant,volMousse,tenueMousse,durete,solubilite,sechage)
            caracteristiqueDAO.saveAll(caracteristiques)

        if (mentionDAO.count() == 0L) {

            val mentionIode1 = Mention(5, "Très stable", 0.0, 50.0, caracteristique = iode)
            val mentionIode2 = Mention(6, "Stable", 50.01, 70.0, caracteristique = iode)
            val mentionIode3 = Mention(7, "Légèrement instable", 70.01, 90.0, caracteristique = iode)
            val mentionIode4 = Mention(8, "Instabilité élevée", 90.01, 100.0, caracteristique = iode)


            val mentionIns1 = Mention(9, "Formule optimisée", 120.0, 160.0, caracteristique = ins)
            val mentionIns2 = Mention(10, "Bonne cohérence", 100.0, 180.0, caracteristique = ins)
            val mentionIns3 = Mention(11, "Moyennement équilibré", 99.0, 181.0, caracteristique = ins)
            val mentionIns4 = Mention(12, "Déséquilibre marqué", 80.0, 200.0, caracteristique = ins)

            val mentionLavant1 = Mention(13, "Pouvoir lavant exceptionnel", 80.0, 100.0, caracteristique = lavant)
            val mentionLavant2 = Mention(14, "Bonne capacité nettoyante", 60.0, 79.99, caracteristique = lavant)
            val mentionLavant3 = Mention(15, "Nettoyage modéré", 40.0, 59.99, caracteristique = lavant)
            val mentionLavant4 = Mention(16, "Pouvoir lavant insuffisant", 0.0, 39.99, caracteristique = lavant)


            val mentionDouceur1 = Mention(17, "Très doux pour la peau", 80.0, 100.0, caracteristique = douceur)
            val mentionDouceur2 = Mention(18, "Assez doux", 60.0, 79.99, caracteristique = douceur)
            val mentionDouceur3 = Mention(19, "Légèrement irritant", 40.0, 59.99, caracteristique = douceur)
            val mentionDouceur4 = Mention(20, "Irritant", 0.0, 39.99, caracteristique = douceur)

            val mentionTenueMoussante1 = Mention(21, "Excellent", 80.0, 100.0, caracteristique = tenueMousse)
            val mentionTenueMoussante2 = Mention(22, "Bonne tenue de la mousse", 60.0, 79.99, caracteristique = tenueMousse)
            val mentionTenueMoussante3 = Mention(23, "Tenue correcte", 40.0, 59.99, caracteristique = tenueMousse)
            val mentionTenueMoussante4 = Mention(24, "Mousse fugace", 0.0, 39.99, caracteristique = tenueMousse)

            val mentionSolubilite1 = Mention(25, "très bien soluble", 80.0, 100.0, caracteristique = solubilite)
            val mentionSolubilite2 = Mention(26, "Bonne solubilité", 60.0, 79.99, caracteristique = solubilite)
            val mentionSolubilite3 = Mention(27, "Solubilité moyenne", 40.0, 59.99, caracteristique = solubilite)
            val mentionSolubilite4 = Mention(28, "Dissolution lente", 0.0, 39.99, caracteristique = solubilite)

            val mentionSechage1 = Mention(29, "Séche très rapidement", 80.0, 100.0, caracteristique = sechage)
            val mentionSechage2 = Mention(30, "Bonne vitesse de séchage", 60.0, 79.99, caracteristique = sechage)
            val mentionSechage3 = Mention(31, "Séchage modéré", 40.0, 59.99, caracteristique = sechage)
            val mentionSechage4 = Mention(32, "Séchage lent", 0.0, 39.99, caracteristique = sechage)

            val mentionVolmoussant1 = Mention(33, "Mousse abondante", 80.0, 100.0, caracteristique = volMousse)
            val mentionVolmoussant2 = Mention(34, "Mousse généreuse", 60.0, 79.99, caracteristique = volMousse)
            val mentionVolmoussant3 = Mention(35, "Mousse légère", 40.0, 59.99, caracteristique = volMousse)
            val mentionVolmoussant4 = Mention(36, "Peu de mousse", 0.0, 39.99, caracteristique = volMousse)

            val mentionDurete1 = Mention(37, "Très résistant", 80.0, 100.0, caracteristique = durete)
            val mentionDurete2 = Mention(38, "Résistance correcte", 60.0, 79.99, caracteristique = durete)
            val mentionDurete3 = Mention(39, "Légèrement friable", 40.0, 59.99, caracteristique = durete)
            val mentionDurete4 = Mention(40, "Se désagrège facilement", 0.0, 39.99, caracteristique = durete)

            val mention = listOf<Mention>(
                mentionIode1,
                mentionIode2,
                mentionIode3,
                mentionIode4,
                mentionIns1,
                mentionIns2,
                mentionIns3,
                mentionIns4,
                mentionDouceur1,
                mentionDouceur2,
                mentionDouceur3,
                mentionDouceur4,
                mentionLavant1,
                mentionLavant2,
                mentionLavant3,
                mentionLavant4,
                mentionVolmoussant1,
                mentionVolmoussant2,
                mentionVolmoussant3,
                mentionVolmoussant4,
                mentionTenueMoussante1,
                mentionTenueMoussante2,
                mentionTenueMoussante3,
                mentionTenueMoussante4,
                mentionDurete1,
                mentionDurete2,
                mentionDurete3,
                mentionDurete4,
                mentionSolubilite1,
                mentionSolubilite2,
                mentionSolubilite3,
                mentionSolubilite4,
                mentionSechage1,
                mentionSechage2,
                mentionSechage3,
                mentionSechage4
            )
            mentionDAO.saveAll(mention)
        }
        }
    }
}