package com.meawallet.usercrud.in.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.in.dto.GetUserInResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToGetUserInResponseConverter {

    public GetUserInResponse convert(User user) {
        return new GetUserInResponse(user.getId(), user.getName(), user.getAge());
    }
}
