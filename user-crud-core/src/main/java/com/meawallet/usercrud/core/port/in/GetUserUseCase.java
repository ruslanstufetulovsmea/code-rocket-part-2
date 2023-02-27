package com.meawallet.usercrud.core.port.in;

import com.meawallet.usercrud.domain.User;

public interface GetUserUseCase {

    User getUser(Integer id);
}
