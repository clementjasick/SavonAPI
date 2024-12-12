package org.ldv.savonapi.model.id

import org.ldv.savonapi.model.entity.Caracteristique
import java.io.Serializable

class ResultatId(
    val caracteristiqueId: Long,
    val recetteId: Long
): Serializable {
}