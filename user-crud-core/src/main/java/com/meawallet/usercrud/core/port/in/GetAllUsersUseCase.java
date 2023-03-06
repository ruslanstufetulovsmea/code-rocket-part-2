package com.meawallet.usercrud.core.port.in;

import com.meawallet.usercrud.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {

    List<User> getAll();
}
