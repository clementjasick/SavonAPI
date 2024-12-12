package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.awt.geom.Arc2D

@Entity
class Mention(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chaque mention (bien, assez bien...) a un id associer (0,1,2...)
    var mentionId: Long,
    var text: String,
    val scoreMin: Double,
    val scoreMax : Double,

    @ManyToOne
    @JoinColumn(name = "caracteristiqueId")
    var caracteristique: Caracteristique,

    @OneToMany(mappedBy = "mention")
    var resultat: MutableList<Resultat>? = null,


) {
}