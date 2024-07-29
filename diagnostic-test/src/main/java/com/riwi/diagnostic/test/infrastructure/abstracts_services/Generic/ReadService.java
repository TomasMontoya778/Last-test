package com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}