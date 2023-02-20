package com.meawallet.usercrud.ui.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.dto.CreateUserInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateUserInRequestToDomainConverter {

    public User convert(CreateUserInRequest request) {
        return User.builder()
                   .name(request.getName())
                   .age(request.getAge())
                   .build();
    }
}
