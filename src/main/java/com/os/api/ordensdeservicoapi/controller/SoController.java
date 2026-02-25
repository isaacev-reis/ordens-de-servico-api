package com.os.api.ordensdeservicoapi.controller;

import com.os.api.ordensdeservicoapi.model.SoModel;
import com.os.api.ordensdeservicoapi.repository.SoRepository;
import com.os.api.ordensdeservicoapi.service.SoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class SoController {
    private SoService service;

    @PostMapping("/orders")
    public void createOrder(@RequestBody SoModel order) {
        service.addOrder(order);
    }

    @GetMapping("/orders/{id}")
    public SoModel searchById(@PathVariable UUID id) {
        return service.getOrder(id);
    }

    @GetMapping("/orders")
    public List<SoModel> listAllOrders() {
        return service.getAllOrders();
    }

    @PatchMapping("/orders/start/{id}")
    public void startOrder(@PathVariable UUID id) {
        service.startOrder(id);
    }

    @PatchMapping("/orders/cancel/{id}")
    public void cancelOrder(@PathVariable UUID id) {
        service.cancelOrder(id);
    }

    @PatchMapping("/orders/finish/{id}")
    public void finishOrder(@PathVariable UUID id) {
        service.finishOrder(id);
    }
}
