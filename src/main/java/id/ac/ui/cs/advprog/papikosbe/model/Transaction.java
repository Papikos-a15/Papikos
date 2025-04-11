package id.ac.ui.cs.advprog.papikosbe.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Transaction {
    private UUID id;
    private UUID userId;
    private BigDecimal amount;
    private String type; // "TOP_UP" atau "PAYMENT"
    private LocalDateTime timestamp;

    public Transaction(UUID id, UUID userId, BigDecimal amount, String type, LocalDateTime timestamp) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be null or empty");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }
}