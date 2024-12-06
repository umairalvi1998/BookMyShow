package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Show extends BaseModel{
        @ManyToOne
        private Movie movie;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        @ManyToOne
        private Screen screen;

        private List<Features> features;
}
