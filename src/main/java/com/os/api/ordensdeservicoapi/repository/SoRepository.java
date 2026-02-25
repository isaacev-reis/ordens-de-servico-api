package com.os.api.ordensdeservicoapi.repository;

import com.os.api.ordensdeservicoapi.model.SoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SoRepository extends JpaRepository<SoModel, UUID> {
}
