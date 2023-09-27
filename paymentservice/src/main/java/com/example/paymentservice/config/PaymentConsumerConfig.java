package com.example.paymentservice.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.commondto.event.OrderEvent;
import com.example.commondto.event.OrderStatus;
import com.example.commondto.event.PaymentEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class PaymentConsumerConfig {
	@Bean
	public Function<Flux<OrderEvent>, Flux<PaymentEvent>> paymentProcessor() {
		return orderFlux -> orderFlux.flatMap(this::processPayment);
	}
	
	private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
		if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())) {
			
		}
	}
}
