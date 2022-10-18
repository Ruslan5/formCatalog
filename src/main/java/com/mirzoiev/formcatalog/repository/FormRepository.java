package com.mirzoiev.formcatalog.repository;

import com.mirzoiev.formcatalog.entity.FormEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository
        extends MongoRepository<FormEntity, String> {
    public FormEntity getFormById(String id);

}
