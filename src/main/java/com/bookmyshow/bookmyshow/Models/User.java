package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User extends BaseModel{
    String name;
    String email;
    String password;
}
