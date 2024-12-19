package com.bookmyshow.bookmyshow.Controllers;

import com.bookmyshow.bookmyshow.Dtos.ResponseStatus;
import com.bookmyshow.bookmyshow.Dtos.UserRequestDto;
import com.bookmyshow.bookmyshow.Dtos.UserResponseDto;
import com.bookmyshow.bookmyshow.Dtos.loginRequestDto;
import com.bookmyshow.bookmyshow.Models.User;
import com.bookmyshow.bookmyshow.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserResponseDto signUp(@RequestBody  UserRequestDto requestDto) {
            User user = userService.signUp(requestDto.getName(),requestDto.getEmail(),requestDto.getPassword());
            UserResponseDto responseDto = new UserResponseDto();

            responseDto.setName(user.getName());
            responseDto.setEmail(user.getEmail());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

            return responseDto;
    }

    @GetMapping("/login")
    public ResponseStatus login(@RequestBody loginRequestDto requestDto) {
       return  userService.login(requestDto.getEmail(), requestDto.getPassword());
    }
}
