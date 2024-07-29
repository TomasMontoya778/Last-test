package com.riwi.diagnostic.test.infrastructure.helpers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.diagnostic.test.utils.exceptions.IdNotFoundException;

public class HelperToFind <Entity>{
    public Entity findById(JpaRepository<Entity, String> repository, String id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(name));
    }
}
