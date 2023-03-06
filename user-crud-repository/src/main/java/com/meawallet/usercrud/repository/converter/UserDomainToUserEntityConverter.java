package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToUserEntityConverter {

    public UserEntity convert(User user) {
        return UserEntity.builder()
                         .id(user.getId())
                         .name(user.getName())
                         .age(user.getAge())
                         .build();
    }
}
