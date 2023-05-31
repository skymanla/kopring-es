package com.es.es

import com.es.es.document.Phone
import com.es.es.repository.ElasticsearchRepository
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
}