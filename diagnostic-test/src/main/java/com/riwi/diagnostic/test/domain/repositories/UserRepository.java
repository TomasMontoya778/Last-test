package com.riwi.diagnostic.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.diagnostic.test.domain.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}