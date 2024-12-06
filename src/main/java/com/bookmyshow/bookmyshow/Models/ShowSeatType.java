package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ShowSeatType extends  BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}
