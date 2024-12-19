package com.bookmyshow.bookmyshow.Services;

import com.bookmyshow.bookmyshow.Dtos.ResponseStatus;
import com.bookmyshow.bookmyshow.Models.User;
import com.bookmyshow.bookmyshow.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    public User signUp(String name, String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            //user already exists,navigate to login page
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public ResponseStatus login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return ResponseStatus.SUCCESS;
            }
            else {
                return ResponseStatus.FAILURE;
            }
        }
        else {
            //ASk user to sign up
        }
        return ResponseStatus.FAILURE;
    }

}
