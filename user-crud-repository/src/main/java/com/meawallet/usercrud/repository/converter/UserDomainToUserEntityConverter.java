package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.repository.entity.UserEntity;
import com.meawallet.usercrud.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToUserEntityConverter {

    public UserEntity convert(User user) {
        return UserEntity.builder()
                         .name(user.getName())
                         .age(user.getAge())
                         .build();
    }
}
