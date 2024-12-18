package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name = "Movies")
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private double rating;

}
