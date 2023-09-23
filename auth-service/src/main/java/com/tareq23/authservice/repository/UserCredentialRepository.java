package com.tareq23.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareq23.authservice.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>{

}
