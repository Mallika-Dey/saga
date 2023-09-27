package com.example.orderservice.entity;

import com.example.commondto.dto.OrderItemsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {
	private Integer id;
	private Integer productId;
	private Integer quantity;
}
