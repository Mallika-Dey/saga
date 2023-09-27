package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commondto.dto.OrderRequestDto;
import com.example.commondto.event.OrderEvent;
import com.example.commondto.event.OrderStatus;

import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {
	@Autowired
	private Sinks.Many<OrderEvent> orderSinks;

	public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
		OrderEvent orderEvent = new OrderEvent(orderRequestDto, orderStatus);
		
		// emit event
		orderSinks.tryEmitNext(orderEvent);
	}
}
