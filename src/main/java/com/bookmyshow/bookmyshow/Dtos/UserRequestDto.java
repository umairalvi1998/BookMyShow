package com.bookmyshow.bookmyshow.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRequestDto {
    String name;
    String email;
    String password;
}
