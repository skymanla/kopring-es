package com.es.es.repository

import com.es.es.document.Phone
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ElasticsearchRepository: ElasticsearchRepository<Phone, Int>