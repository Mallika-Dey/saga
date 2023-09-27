package com.example.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.example.commondto.event.OrderStatus;
import com.example.commondto.event.PaymentStatus;

@Entity
@Table(name = "purcase_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer customerId;
	private Integer price;
	private Set<OrderItems> orderItems;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
}
