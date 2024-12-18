package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Bookings")
@Data
@Getter
@Setter
public class Booking extends BaseModel {
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
    @OneToMany
    List<Payment> payments;
    @OneToMany
    List<ShowSeat> showSeats;
    private LocalDateTime createdAt;
}
