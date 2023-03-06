package com.meawallet.usercrud.core.port.out;

import com.meawallet.usercrud.domain.User;

import java.util.List;

public interface FindAllUserPort {

    List<User> findAll();
}
