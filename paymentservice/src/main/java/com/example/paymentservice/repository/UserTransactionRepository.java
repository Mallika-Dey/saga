package com.example.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentservice.entity.UserTransaction;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, Integer>{

}
