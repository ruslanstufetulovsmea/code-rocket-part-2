package com.meawallet.usercrud.core.port.out;

import com.meawallet.usercrud.domain.User;

public interface SaveUserPort {

    void save(User user);
}
