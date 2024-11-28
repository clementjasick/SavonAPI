package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var roleId: Long,
    var nom: String,
){
}