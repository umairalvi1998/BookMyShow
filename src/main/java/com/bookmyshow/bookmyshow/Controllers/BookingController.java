package com.bookmyshow.bookmyshow.Controllers;

import com.bookmyshow.bookmyshow.Dtos.BookingResponseDto;
import com.bookmyshow.bookmyshow.Dtos.CreateBookingRequestDto;
import com.bookmyshow.bookmyshow.Dtos.ResponseStatus;
import com.bookmyshow.bookmyshow.Exceptions.ShowSeatNotFoundException;
import com.bookmyshow.bookmyshow.Exceptions.UserNotFoundException;
import com.bookmyshow.bookmyshow.Models.Booking;
import com.bookmyshow.bookmyshow.Services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
   public BookingResponseDto createBooking (@RequestBody CreateBookingRequestDto requestDto) throws UserNotFoundException, ShowSeatNotFoundException {

       List<Long> showSeats =  requestDto.getShowSeatIds();
       Long userId  = requestDto.getUserId();

       BookingResponseDto responseDto = from(bookingService.createBooking(showSeats,userId));


        return responseDto;
   }

   private BookingResponseDto from(Booking booking){
        BookingResponseDto responseDto = new BookingResponseDto();
        if(booking == null) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return  responseDto;
   }
}
