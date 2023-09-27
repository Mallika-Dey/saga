package com.example.orderservice.config;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.commondto.event.OrderEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderPublisherConfig {

	@Bean
	public Sinks.Many<OrderEvent> orderSinks() {
		return Sinks.many().multicast().onBackpressureBuffer();
	}

	@Bean
	public Supplier<Flux<OrderEvent>> orderSuppliers(Sinks.Many<OrderEvent> sinks) {
		return sinks::asFlux;
	}
}
