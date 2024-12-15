package com.bookmyshow.bookmyshow.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateBookingRequestDto {
    private List<Long> showSeatIds;
    private Long userId;

}
