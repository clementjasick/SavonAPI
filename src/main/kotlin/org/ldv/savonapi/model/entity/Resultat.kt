package org.ldv.savonapi.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import org.ldv.savonapi.model.id.LigneIngredientId
import org.ldv.savonapi.model.id.ResultatId

@Entity
class Resultat(
    @EmbeddedId
    var resultatId: ResultatId?,

    @MapsId("caracteristiqueId")
    @ManyToOne
    @JoinColumn(name = "caracteristiqueId")
    var caracteristique: Caracteristique? = null,

    @MapsId("recetteId")
    @ManyToOne
    @JoinColumn(name = "recetteId")
    var recette: Recette? = null,

    @ManyToOne
    @JoinColumn(name = "mentionId")
    var mention: Mention? = null,

    var score: Double
) {


}