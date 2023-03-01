package com.meawallet.usercrud.repository.repository;

import com.meawallet.usercrud.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findUserById(Integer id);
}
