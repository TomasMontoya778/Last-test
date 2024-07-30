package com.riwi.diagnostic.test.domain.repositories;

import com.riwi.diagnostic.test.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
