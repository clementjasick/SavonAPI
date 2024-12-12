package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.awt.Stroke

@Entity
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var recetteId: Long,
    var nom: String,
    var surgraissage: Double,
    var alcalinQuantite: Double,
    var alcalinPourcentage: Double,
    var alcalinType: String,
    var eauQuantite: Double,

    @OneToMany(mappedBy = "recette")
    val ligneIngredient: MutableList<LigneIngredient> = mutableListOf(),
    @OneToMany(mappedBy = "recette")
    val resultat: MutableList<Resultat> = mutableListOf(),

){
    fun calculalcalinQuantite(){
        var alcalinQuantiteNormal = 0.0
        if(alcalinType == "soude"){
            alcalinQuantiteNormal = this.ligneIngredient.sumOf{(it.quantite*it.ingredient!!.sapo*(40.0/56.0/1000.0))}
        } else {
            alcalinQuantiteNormal = this.ligneIngredient.sumOf{ (it.quantite*it.ingredient!!.sapo)/1000.0}
        }
        var alcalinQuantite = alcalinQuantiteNormal/(alcalinPourcentage/100.0)
        alcalinQuantite = alcalinQuantite - (alcalinQuantite*(surgraissage/100))
    }

    fun calculApportEau(){
        var concentrationEau =(100 - alcalinPourcentage)/100
        eauQuantite = alcalinQuantite*concentrationEau
        eauQuantite = this.eauQuantite
    }

    fun calculNonPondere(){
        var ins = this.ligneIngredient.sumOf { it.ingredient!!.ins*it.pourcentage/100 }
        var iode = this.ligneIngredient.sumOf { it.ingredient!!.iode*it.pourcentage/100 }

        this.resultat.find { it.caracteristique!!.nom=="iode" }!!.score=iode
        this.resultat.find { it.caracteristique!!.nom=="ins" }!!.score=ins
    }

    fun calculPondere(){
        var douceur = this.ligneIngredient.sumOf { it.ingredient!!.douceur*it.pourcentage/100 }
        var lavant = this.ligneIngredient.sumOf { it.ingredient!!.lavant*it.pourcentage/100 }
        var volmousse = this.ligneIngredient.sumOf { it.ingredient!!.volMousse*it.pourcentage/100 }
        var tenueMousse = this.ligneIngredient.sumOf { it.ingredient!!.tenueMousse*it.pourcentage/100 }
        var durete = this.ligneIngredient.sumOf { it.ingredient!!.durete*it.pourcentage/100 }
        var solubilite = this.ligneIngredient.sumOf { it.ingredient!!.solubilite*it.pourcentage/100 }
        var sechage = this.ligneIngredient.sumOf { it.ingredient!!.sechage*it.pourcentage/100 }

        douceur = douceur*(1+0.01494*surgraissage)
        lavant = lavant*(1+-0.01203*surgraissage)
        volmousse = volmousse*(1+-0.00702*surgraissage)
        tenueMousse = tenueMousse*(1+0.01016*surgraissage)
        durete = durete*(1+-0.00602*surgraissage)
        solubilite = solubilite*(1+0.00250*surgraissage)
        sechage = sechage*(1+-0.00503*surgraissage)

        this.resultat.find { it.caracteristique!!.nom=="douceur" }!!.score=douceur
        this.resultat.find { it.caracteristique!!.nom=="lavant" }!!.score=lavant
        this.resultat.find { it.caracteristique!!.nom=="vol mousse" }!!.score=volmousse
        this.resultat.find { it.caracteristique!!.nom=="tenue mousse" }!!.score=tenueMousse
        this.resultat.find { it.caracteristique!!.nom=="durete" }!!.score=durete
        this.resultat.find { it.caracteristique!!.nom=="solubilite" }!!.score=solubilite
        this.resultat.find { it.caracteristique!!.nom=="sechage" }!!.score=sechage

    }
}