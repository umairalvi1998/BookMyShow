package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Payment  extends  BaseModel {
    private String referenceNumber;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private Payment_Status paymentStatus;
}
