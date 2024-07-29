package com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic;



public interface CreateService  <Request, Response>{
    Response create(Request request);
    
}
