package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseModel{

    private String name;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection(targetClass = Features.class)
    @Enumerated(EnumType.ORDINAL)
    private List<Features> features;
    private ScreenStatus status;
}
