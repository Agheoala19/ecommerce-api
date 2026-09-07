package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.OrderRequestDto;
import com.ecommerce.api.dto.OrderResponseDto;
import com.ecommerce.api.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto request) {
        return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.CREATED);
    }

    @GetMapping("/my-orders")
    public ResponseEntity<Page<OrderResponseDto>> getMyOrders(
            @PageableDefault(size = 10, sort = "orderDate") Pageable pageable) {
        return ResponseEntity.ok(orderService.getCurrentUserOrders(pageable));
    }
}