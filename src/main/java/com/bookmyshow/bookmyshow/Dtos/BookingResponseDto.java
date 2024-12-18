package com.bookmyshow.bookmyshow.Dtos;

import com.bookmyshow.bookmyshow.Models.Booking;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingResponseDto {
    private Booking booking;
    ResponseStatus responseStatus;
}
