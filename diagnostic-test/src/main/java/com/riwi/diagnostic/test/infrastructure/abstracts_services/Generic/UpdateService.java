package com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic;

public interface UpdateService  <Request, Response, Id> {
    Response update(Id id, Request request);
}
