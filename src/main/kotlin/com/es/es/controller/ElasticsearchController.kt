package com.es.es.controller

import com.es.es.document.Phone
import com.es.es.service.ElasticsearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/phones")
class ElasticsearchController(
    private val elasticsearchService: ElasticsearchService
) {
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Phone> {
        return ResponseEntity.ok().body(elasticsearchService.findById(id))
    }

    @PostMapping
    fun add(@RequestBody phone: Phone): ResponseEntity<Phone> {
        elasticsearchService.save(phone);
        return ResponseEntity.created(URI.create("/phones/${phone.id}")).build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Any> {
        elasticsearchService.delete(id)
        return ResponseEntity.noContent().build()
    }
}