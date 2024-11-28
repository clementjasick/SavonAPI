package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var utilisateurId: Long,
    var mdp: String,
    var email: String

) {
}