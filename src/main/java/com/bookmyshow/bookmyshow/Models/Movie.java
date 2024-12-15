package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "Movies")
public class Movie extends BaseModel{
    private String name;
    private double rating;

}
