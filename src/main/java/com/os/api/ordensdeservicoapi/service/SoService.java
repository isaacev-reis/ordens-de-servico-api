package com.os.api.ordensdeservicoapi.service;

import com.os.api.ordensdeservicoapi.model.SoModel;
import com.os.api.ordensdeservicoapi.repository.SoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SoService {
    private SoRepository repository;

    public SoService(SoRepository repository) {
        this.repository = repository;
    }

    public void addOrder(SoModel order) {
        UUID id = UUID.randomUUID();
        order.setId(id);
        order.openServiceOrder();
        repository.save(order);
    }

    public void cancelOrder(UUID id) {
        repository.findById(id).get().cancel();
        repository.save(repository.findById(id).get());
    }

    public SoModel getOrder(UUID id) {
        return repository.findById(id).get();
    }

    public void startOrder(UUID id) {
        repository.findById(id).get().start();
        repository.save(repository.findById(id).get());
    }

    public void finishOrder(UUID id) {
        repository.findById(id).get().finish();
        repository.save(repository.findById(id).get());
    }

    public List<SoModel> getAllOrders() {
        return repository.findAll();
    }
}