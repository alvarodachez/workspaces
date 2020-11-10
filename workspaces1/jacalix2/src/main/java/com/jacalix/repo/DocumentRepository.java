package com.jacalix.repo;

import org.springframework.data.repository.CrudRepository;

import com.jacalix.model.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

}
