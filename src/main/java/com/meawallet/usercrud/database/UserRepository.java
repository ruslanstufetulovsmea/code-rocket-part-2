package com.meawallet.usercrud.database;

import com.meawallet.usercrud.domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findUserById(Integer id);
}
