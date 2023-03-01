package com.meawallet.usercrud.in.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.in.dto.CreateUserInResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToCreateUserInResponseConverter {

    public CreateUserInResponse convert(User user) {
        return new CreateUserInResponse(user.getId(), user.getName(), user.getAge());
    }
}
