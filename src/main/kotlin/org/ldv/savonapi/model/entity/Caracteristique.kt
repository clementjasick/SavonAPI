package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Caracteristique(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var caracteristiqueId: Long,
    var nom: String,
    @OneToMany (mappedBy = "caracteristique")

    //var mentions: List<Mention>? = null


    var mentions: MutableList<Mention> = mutableListOf()


//    @ManyToMany
//    @JoinTable(
//        name = "caracteristique_recette",
//        joinColumns = [JoinColumn(name = "caracteristique_id")],
//        inverseJoinColumns = [JoinColumn(name = "recette_id")]
//    )
//    var recette: List<Recette>? = null
) {
}