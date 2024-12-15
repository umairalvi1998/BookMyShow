package com.bookmyshow.bookmyshow.Repositories;

import com.bookmyshow.bookmyshow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    List<ShowSeat> findAllById(List<Long> showSeatIds);
}
