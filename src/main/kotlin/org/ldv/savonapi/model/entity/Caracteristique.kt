package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Caracteristique(
    @Id
    var caracteristiqueId: Long,
    var nom: String,
    @ManyToMany
    @JoinTable(
        name = "caracteristique_mention",
        joinColumns = [JoinColumn(name = "caracteristique_id")],
        inverseJoinColumns = [JoinColumn(name = "mention_id")]
    )
    var mention: MutableList<Caracteristique> = mutableListOf()
//    @ManyToMany
//    @JoinTable(
//        name = "caracteristique_recette",
//        joinColumns = [JoinColumn(name = "caracteristique_id")],
//        inverseJoinColumns = [JoinColumn(name = "recette_id")]
//    )
//    var recette: List<Recette>? = null
) {
}