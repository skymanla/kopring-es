package com.es.es

import com.es.es.document.Phone
import com.es.es.repository.ElasticsearchRepository
import com.es.es.service.ElasticsearchService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ElasticsearchServiceTests {

    @Mock
    private lateinit var elasticsearchRepository: ElasticsearchRepository
    @InjectMocks
    private lateinit var elasticsearchService: ElasticsearchService

    @BeforeEach
    fun setUp() {
        elasticsearchService = ElasticsearchService(elasticsearchRepository)
    }

    @Test
    fun save() {
        // given
        val phone = Phone(1, "010-0000-0000", "devkuma")
        given(elasticsearchRepository.save(any())).willReturn(phone)

        // when
        val savedPhone = elasticsearchService.save(phone)

        // then
        Assertions.assertAll(
            { Assertions.assertNotNull(savedPhone) },
            { Assertions.assertEquals(savedPhone.id, phone.id) },
            { Assertions.assertEquals(savedPhone.number, phone.number) },
            { Assertions.assertEquals(savedPhone.author, phone.author) }
        )
    }

    @Test
    fun findById() {
        // given
        val phone = Phone(1, "010-0000-0000", "devkuma")
        given(elasticsearchRepository.findById(any())).willReturn(Optional.of(phone))

        // 조회
        val searchedPhone = elasticsearchService.findById(1)

        // then
        Assertions.assertAll(
            { Assertions.assertNotNull(searchedPhone) },
            { Assertions.assertEquals(phone.id, searchedPhone.id) },
            { Assertions.assertEquals(phone.number, searchedPhone.number) },
            { Assertions.assertEquals(phone.author, searchedPhone.author) }
        )
    }

    @Test
    fun delete() {
        // given
        val phone = Phone(1, "010-0000-0000", "devkuma")
        given(elasticsearchRepository.findById(any())).willReturn(Optional.of(phone))

        // given
        assertDoesNotThrow { elasticsearchService.delete(1) }
    }
}