package com.meawallet.usercrud.in.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.in.dto.UpdateUserInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserInRequestToUserConverter {

    public User convert(UpdateUserInRequest request, Integer id) {
        return User.builder()
                   .id(id)
                   .age(request.age())
                   .name(request.name())
                   .build();
    }
}
