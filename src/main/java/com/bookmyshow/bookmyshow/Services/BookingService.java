package com.bookmyshow.bookmyshow.Services;

import com.bookmyshow.bookmyshow.Exceptions.ShowSeatNotFoundException;
import com.bookmyshow.bookmyshow.Exceptions.UserNotFoundException;
import com.bookmyshow.bookmyshow.Models.*;
import com.bookmyshow.bookmyshow.Repositories.BookingRepository;
import com.bookmyshow.bookmyshow.Repositories.ShowSeatRepository;
import com.bookmyshow.bookmyshow.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepo;
    private ShowSeatRepository showSeatRepo;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepo, ShowSeatRepository showSeatRepo, PriceCalculatorService priceCalculatorService, BookingRepository bookingRepository) {
        this.userRepo = userRepo;
        this.showSeatRepo = showSeatRepo;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<Long> showSeatIds, Long userId) throws UserNotFoundException, ShowSeatNotFoundException {
          Optional<User> userOptional =  userRepo.findById(userId);

          if(userOptional.isEmpty()) {
              throw new UserNotFoundException("User Not Found");
          }

         List<ShowSeat> showSeats =  showSeatRepo.findAllByIdIn(showSeatIds);

          for(ShowSeat showSeat : showSeats) {

              if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
                  throw new ShowSeatNotFoundException("Show Seat With Show Id:" + showSeat.getShow().getId() +
                  " and seat Id : " +showSeat.getSeat().getId() + "is not available");
              }
          }

        for(ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(showSeat);
        }

        Booking booking = new Booking();

        booking.setUser(userOptional.get());
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats));

        bookingRepository.save(booking);



        return booking;
    }
}

/*
            1) Fetch the user with userId
            2) if user not found then throw an exception
            3) Fetch the ShowSeat Objects from the Database
            4) Check if ShowSeats are available
            5) If not throw an exception
            --------------TAKE A LOCK --------------------------
            6) Check the ShowSeat status again
            7) Change the ShowSeat status to blocked.
            ---------------RELEASE THE LOCK -----------------------
            8) Create the booking with PENDING status
         */
