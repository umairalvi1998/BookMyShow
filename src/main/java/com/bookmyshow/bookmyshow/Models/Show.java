package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel{
        @ManyToOne
        private Movie movie;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        @ManyToOne
        private Screen screen;
        @ElementCollection(targetClass = Features.class)
        private List<Features> features;
}
