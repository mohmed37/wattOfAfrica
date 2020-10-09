package com.microserviceuser.dao;


import com.microserviceuser.entities.ConfirmationEmailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ConfirmationEmailRepository extends JpaRepository<ConfirmationEmailToken, String> {
        ConfirmationEmailToken findByConfirmationToken(String confirmationToken);
    }


