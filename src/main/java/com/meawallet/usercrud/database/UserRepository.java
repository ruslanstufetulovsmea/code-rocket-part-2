package com.meawallet.usercrud.database;

import com.meawallet.usercrud.domain.User;

public interface UserRepository {

    void save(User user);
}
