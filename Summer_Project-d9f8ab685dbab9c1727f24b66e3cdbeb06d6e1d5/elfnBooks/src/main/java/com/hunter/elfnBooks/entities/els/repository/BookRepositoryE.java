package com.hunter.elfnBooks.entities.els.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hunter.elfnBooks.elastic.entities.BookE;

public interface BookRepositoryE extends ElasticsearchRepository<BookE, Integer> {
	

}
