package com.meawallet.usercrud.database.converter;

import com.meawallet.usercrud.database.UserEntity;
import com.meawallet.usercrud.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToUserEntityConverter {

    public UserEntity convert(User user, Integer id) {
        return new UserEntity(id, user.getName(), user.getAge());
    }
}
