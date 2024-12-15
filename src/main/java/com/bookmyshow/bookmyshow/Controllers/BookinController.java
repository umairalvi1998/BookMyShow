package com.bookmyshow.bookmyshow.Controllers;

import com.bookmyshow.bookmyshow.Dtos.BookingResponseDto;
import com.bookmyshow.bookmyshow.Dtos.CreateBookingRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookinController {

    @PostMapping
   public BookingResponseDto createBooking (@RequestBody CreateBookingRequestDto requestDto) {
    return null;
   }
}
