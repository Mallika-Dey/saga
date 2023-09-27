package com.example.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.entity.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}
