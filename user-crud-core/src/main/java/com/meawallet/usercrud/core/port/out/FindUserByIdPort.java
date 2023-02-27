package com.meawallet.usercrud.core.port.out;

import com.meawallet.usercrud.domain.User;

import java.util.Optional;

public interface FindUserByIdPort {

    Optional<User> findById(Integer id);
}
