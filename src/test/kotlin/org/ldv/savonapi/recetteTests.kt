package org.ldv.savonapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
//TODO Les Imports suivant sont à adapter selon votre projet
import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.entity.*
import org.ldv.savonapi.model.id.*
import org.ldv.savonapi.service.DataInitializer

@SpringBootTest
class recetteTests(
    @Autowired val dataInitializer: DataInitializer,
    @Autowired val ingredientDAO: IngredientDAO,
    @Autowired val caracteristiqueDAO: CaracteristiqueDAO
){
    private lateinit var savon: Recette

    @BeforeEach
    fun setup() {
        dataInitializer.run()
        //TODO : Vérifier les id des ingredients et caracteristiques dans le dataInitializer
        val huileCoco = ingredientDAO.findById(1).get()
        val huileOlive = ingredientDAO.findById(2).get()

        val iode = caracteristiqueDAO.findById(1).get()
        val ins = caracteristiqueDAO.findById(2).get()
        val douceur = caracteristiqueDAO.findById(3).get()
        val lavant = caracteristiqueDAO.findById(4).get()
        val volMousse = caracteristiqueDAO.findById(5).get()
        val tenueMousse = caracteristiqueDAO.findById(6).get()
        val durete = caracteristiqueDAO.findById(7).get()
        val solubilite = caracteristiqueDAO.findById(8).get()
        val sechage = caracteristiqueDAO.findById(9).get()

        // Initialisation du savon avec les données fournies
        savon = Recette(
            recetteId = 1,
            nom = "Savon Hydratant Reduction",
            surgraissage = 5.00,
            eauQuantite = 353.0833,
            alcalinType = "soude",
            alcalinPourcentage = 30.0,
            alcalinQuantite = 504.40475,
            ligneIngredient = mutableListOf(
                LigneIngredient(
                    LigneIngredientId(ingredientId = 1, recetteId = 1),
                    quantite = 500.00,
                    pourcentage = 50.00,
                    ingredient = huileOlive
                ),
                LigneIngredient(
                    LigneIngredientId(ingredientId = 2, recetteId = 1),
                    quantite = 500.00,
                    pourcentage = 50.00,
                    ingredient = huileCoco
                )
            ),
            resultat = mutableListOf(
                Resultat(ResultatId(1, 1), score = 0.0, caracteristique = iode),
                Resultat(ResultatId(2, 1), score = 0.0, caracteristique = ins),
                Resultat(ResultatId(3, 1), score = 0.0, caracteristique = douceur),
                Resultat(ResultatId(4, 1), score = 0.0, caracteristique = lavant),
                Resultat(ResultatId(5, 1), score = 0.0, caracteristique = volMousse),
                Resultat(ResultatId(6, 1), score = 0.0, caracteristique = tenueMousse),
                Resultat(ResultatId(7, 1), score = 0.0, caracteristique = durete),
                Resultat(ResultatId(8, 1), score = 0.0, caracteristique = solubilite),
                Resultat(ResultatId(9, 1), score = 0.0, caracteristique = sechage),
            )
        )
    }










    @Test
    fun `test calculApportEau`() {
        savon.calculApportEau()
        assertEquals(353.0833, savon.eauQuantite, 0.001, "L'apport en eau doit être calculé correctement")
    }

    @Test
    fun `test calculNonPondere`() {
        savon.calculNonPondere()
        val iode = savon.resultat.find { it.caracteristique?.nom == "iode" }?.score!!
        val ins = savon.resultat.find { it.caracteristique?.nom == "ins" }?.score!!

        assertEquals(43.5, iode, 0.1, "Le score iode doit être correct")
        assertEquals(179.5, ins, 0.1, "Le score INS doit être correct")
    }

    @Test
    fun `test calculPondere`() {
        savon.calculPondere()

        val douceur = savon.resultat.find { it.caracteristique?.nom == "douceur" }?.score!!
        val lavant = savon.resultat.find { it.caracteristique?.nom == "lavant" }?.score!!
        val volMousse = savon.resultat.find { it.caracteristique!!.nom == "vol mousse" }?.score!!
        val tenueMousse = savon.resultat.find { it.caracteristique!!.nom == "tenue mousse" }?.score!!
        val durete = savon.resultat.find { it.caracteristique!!.nom == "durete" }?.score!!
        val solubilite = savon.resultat.find { it.caracteristique!!.nom == "solubilite" }?.score!!
        val sechage = savon.resultat.find { it.caracteristique!!.nom == "sechage" }?.score!!

        assertEquals(9.138174, douceur, 0.001, "Le score douceur doit être correct")
        assertEquals(11.585531, lavant, 0.001, "Le score lavant doit être correct")
        assertEquals(11.175472, volMousse, 0.1, "Le score volume de mousse ne doit pas être modifié")
        assertEquals(9.831285, tenueMousse, 0.1, "Le score tenue de mousse ne doit pas être modifié")
        assertEquals(9.473014, durete, 0.1, "Le score dureté ne doit pas être modifié")
        assertEquals(10.379138, solubilite, 0.1, "Le score solubilité ne doit pas être modifié")
        assertEquals(10.759419, sechage, 0.1, "Le score séchage ne doit pas être modifié")
    }

    @Test
    fun `test calculQteAlcalin`() {
        savon.calculalcalinQuantite()
        assertEquals(504.40475, savon.alcalinQuantite, 0.001, "La quantité d'alcalin doit être calculée correctement")
    }
}