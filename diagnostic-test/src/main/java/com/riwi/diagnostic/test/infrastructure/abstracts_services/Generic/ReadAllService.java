package com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable); 
}
