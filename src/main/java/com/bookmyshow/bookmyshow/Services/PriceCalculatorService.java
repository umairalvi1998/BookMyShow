package com.bookmyshow.bookmyshow.Services;

import com.bookmyshow.bookmyshow.Models.SeatType;
import com.bookmyshow.bookmyshow.Models.Show;
import com.bookmyshow.bookmyshow.Models.ShowSeat;
import com.bookmyshow.bookmyshow.Models.ShowSeatType;
import com.bookmyshow.bookmyshow.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class PriceCalculatorService {

    ShowSeatTypeRepository showSeatTypeRepo;

    PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepo) {
        this.showSeatTypeRepo = showSeatTypeRepo;
    }
    public int calculatePrice(List<ShowSeat> showSeats) {

        int amount = 0;
        Show show = showSeats.get(0).getShow();

        List<ShowSeatType> showSeatTypes = showSeatTypeRepo.findAllByShow(show);

        for(ShowSeat showSeat : showSeats) {

            for(ShowSeatType showSeatType : showSeatTypes) {

                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }

        }
        return amount;
    }

}
