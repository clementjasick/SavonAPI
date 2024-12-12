package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.RecetteDAO
import org.ldv.savonapi.model.entity.Recette
import org.ldv.savonapi.service.SimulateurService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

class RecetteController(
    val simulateurService: SimulateurService,
    val recetteDAO: RecetteDAO
) {
    @GetMapping
    fun index(): List<Recette>{
        return recetteDAO.findAll()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id : Long): ResponseEntity<Recette> {
        val recette= recetteDAO.findById(id)
        return if(recette.isPresent){
            ResponseEntity.ok(recette.get())
        }else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long): ResponseEntity<Void>{
        return if (recetteDAO.existsById(id)){
            recetteDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }else{
            ResponseEntity.notFound().build()
        }
    }
}