package com.meawallet.usercrud.core.port.out;

import com.meawallet.usercrud.domain.User;

public interface SaveUserPort {

    User save(User user);
}
