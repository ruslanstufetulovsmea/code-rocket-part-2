package com.meawallet.usercrud.core;

import com.meawallet.usercrud.database.UserRepository;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }
}
