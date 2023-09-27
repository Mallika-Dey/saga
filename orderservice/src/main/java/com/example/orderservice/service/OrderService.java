package com.example.orderservice.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.commondto.dto.OrderItemsDto;
import com.example.commondto.dto.OrderRequestDto;
import com.example.commondto.event.OrderStatus;
import com.example.orderservice.entity.OrderItems;
import com.example.orderservice.entity.PurchaseOrder;
import com.example.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderStatusPublisher orderStatusPublisher;

	@Transactional
	public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
		PurchaseOrder purchaseOrder = convertDtoToEntity(orderRequestDto);
		orderRepository.save(purchaseOrder);
		orderRequestDto.setId(purchaseOrder.getId());

		// producing kafka event
		orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);
		return purchaseOrder;
	}

	private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto) {
		Set<OrderItems> orderItems = orderRequestDto.getOrderItemsDtos().stream()
				.map(orderItemDto -> mapToOrderItem(orderItemDto)).collect(Collectors.toSet());

		return PurchaseOrder.builder().customerId(orderRequestDto.getCustomerId()).price(orderRequestDto.getAmount())
				.orderItems(orderItems).orderStatus(orderRequestDto.getOrderStatus()).build();
	}

	private OrderItems mapToOrderItem(OrderItemsDto orderItemDto) {
		// TODO Auto-generated method stub
		return OrderItems.builder().productId(orderItemDto.getProductId()).quantity(orderItemDto.getQuantity()).build();
	}

	public List<PurchaseOrder> getAll() {
		return orderRepository.findAll();
	}

}
