package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commondto.dto.OrderRequestDto;
import com.example.orderservice.entity.PurchaseOrder;
import com.example.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@PostMapping("/internal/create")
	public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		return orderService.createOrder(orderRequestDto);
	}

	@GetMapping("/getAll")
	public List<PurchaseOrder> getAll() {
		return orderService.getAll();
	}
}
