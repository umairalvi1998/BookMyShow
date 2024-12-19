package com.bookmyshow.bookmyshow.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequestDto {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }
}
