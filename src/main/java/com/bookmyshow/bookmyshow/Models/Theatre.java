package com.bookmyshow.bookmyshow.Models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Theatre extends BaseModel {
    private String theatreName;
    private String theatreAddress;
    @OneToMany
    private List<Screen> screens;

}
