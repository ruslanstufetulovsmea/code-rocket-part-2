package com.meawallet.usercrud.core.port.in;

import com.meawallet.usercrud.domain.User;

public interface UpdateUserUseCase {

    void update(User user);
}
