package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
