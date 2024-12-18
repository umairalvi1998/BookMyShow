package com.bookmyshow.bookmyshow.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponseDto {
    private  String email;
    private String name;
    private ResponseStatus responseStatus;
}
