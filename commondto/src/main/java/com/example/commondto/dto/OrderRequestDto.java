package com.example.commondto.dto;

import com.example.commondto.event.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {
	private Integer id;
    private String orderDate;
    private OrderStatus orderStatus;
    private Integer customerId;
    private Integer amount;
    private Set<OrderItemsDto> orderItemsDtos;
}
