package com.os.api.ordensdeservicoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class SoModel {

    private UUID id;
    private String description;
    private String clientName;
    private LocalDate openingDate;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private BigDecimal value;

    public void openServiceOrder() {
        if (status == Status.OPEN) {
            throw new IllegalStateException("This order already is open!");
        }
        this.status = Status.OPEN;
    }

    public void start() {
        if (status != Status.OPEN) {
            throw new IllegalStateException("The order hasn't open yet!");
        }
        this.status = Status.IN_PROGRESS;
    }

    public void finish() {
        if (status != Status.IN_PROGRESS) {
            throw new IllegalStateException("The service hasn't started yet!");
        }
        this.status = Status.COMPLETED;
    }

    public void cancel() {
        if (status != Status.OPEN && status != Status.IN_PROGRESS) {
            throw new IllegalStateException("This service already completed!");
        }
        this.status = Status.CANCELED;
    }
}
