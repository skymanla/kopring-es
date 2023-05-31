package com.es.es

import com.es.es.document.Phone
import com.es.es.repository.ElasticsearchRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ElasticsearchRepositoryTests() {

    @Autowired
    private lateinit var elasticsearchRepository: ElasticsearchRepository

    @Test
    @DisplayName("저장")
    fun save() {
        val phone: Phone = Phone(1, "010-0000-0000", "es")
        elasticsearchRepository.save(phone)
    }

    @Test
    @DisplayName("조회")
    fun findById() {
        val savedPhone: Phone = Phone(1, "010-0000-0000", "es")
        elasticsearchRepository.save(savedPhone)

        // 조회
        val searchedPhone = elasticsearchRepository.findById(1).orElseGet(null)

        // 테스트
        assertNotNull(searchedPhone)
        assertEquals(savedPhone.id, searchedPhone.id)
        assertEquals(savedPhone.number, searchedPhone.number)
        assertEquals(savedPhone.author, searchedPhone.author)
    }
}