package com.example.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentservice.entity.UserBalance;

public interface UserBalanceRepository extends JpaRepository<UserBalance, Integer> {

}
