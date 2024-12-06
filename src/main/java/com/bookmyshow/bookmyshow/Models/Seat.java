package com.bookmyshow.bookmyshow.Models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {

    private String seatNumber;
    private int row;
    private int column;
    @ManyToOne
    private SeatType seatType;
}
