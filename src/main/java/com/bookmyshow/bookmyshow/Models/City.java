package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class City extends BaseModel{
    String name;
    @OneToMany(mappedBy = "city")
    List<Theatre> theatres;
}
