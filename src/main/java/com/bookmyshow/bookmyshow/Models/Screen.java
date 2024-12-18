package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity(name = "Screens")
@Getter
@Setter
public class Screen extends BaseModel{

    private String name;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection(targetClass = Features.class)
    @Enumerated(EnumType.ORDINAL)
    private List<Features> features;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus status;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    Theatre theatre;

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public ScreenStatus getStatus() {
        return status;
    }

    public void setStatus(ScreenStatus status) {
        this.status = status;
    }

    public List<Features> getFeatures() {
        return features;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
