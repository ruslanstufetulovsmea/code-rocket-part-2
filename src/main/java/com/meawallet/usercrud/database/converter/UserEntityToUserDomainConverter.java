package com.meawallet.usercrud.database.converter;

import com.meawallet.usercrud.database.UserEntity;
import com.meawallet.usercrud.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDomainConverter {

    public User convert(UserEntity entity) {
        return User.builder()
                   .age(entity.getAge())
                   .name(entity.getName())
                   .id(entity.getId())
                   .build();
    }
}
