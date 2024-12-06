package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class City extends BaseModel{
    String name;
    @OneToMany
    List<Theatre> theatres;
}
