package com.es.es.service

import com.es.es.document.Phone
import com.es.es.repository.ElasticsearchRepository
import org.springframework.stereotype.Service

@Service
class ElasticsearchService(
    private val elasticsearchRepository: ElasticsearchRepository
) {
    fun save(phone: Phone): Phone {
        return elasticsearchRepository.save(phone)
    }

    fun findById(id: Int): Phone {
        return elasticsearchRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val phone = this.findById(id)
        elasticsearchRepository.delete(phone)
    }
}