package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.entity.Ingredient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api-savon/v1/ingredient")
class IngredientController (private val ingredientDAO: IngredientDAO) {
    @GetMapping
    fun getAllIngredient(): List<Ingredient> {
        return ingredientDAO.findAll()
    }
    @GetMapping("/{id}")
    fun getExempleById(@PathVariable id: Long): ResponseEntity<Ingredient>{
        val ingredient = ingredientDAO.findById(id)
        return if (ingredient.isPresent){
            ResponseEntity.ok(ingredient.get())
        } else{
            ResponseEntity.notFound().build()
        }
    }
    @PostMapping()
    fun CreateIngredient(@RequestBody ingredient: Ingredient): ResponseEntity<Ingredient>{
        val savedIngredient = ingredientDAO.save(ingredient)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient)
    }
    @PutMapping("/{id}")
    fun updateIngredient(@PathVariable id: Long, @RequestBody ingredient: Ingredient): ResponseEntity<Ingredient> {
        return if (ingredientDAO.existsById(id)) {
            ingredient.ingredientId = id
            val updatedIngredient = ingredientDAO.save(ingredient)
            ResponseEntity.ok(updatedIngredient)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteIngredient(@PathVariable id: Long): ResponseEntity<Void> {
        return if (ingredientDAO.existsById(id)){
            ingredientDAO.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

}