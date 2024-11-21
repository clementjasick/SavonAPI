package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.awt.geom.Arc2D

@Entity
class Mention(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chaque mention (bien, assez bien...) a un id associer (0,1,2...)
    var Id: Long,
    var text: String,
    val scoreMin: Double,
    val scoreMax : Double,

    @ManyToMany (mappedBy = "mention")
    var caracteristique: MutableList<Caracteristique>? = mutableListOf()


) {
}