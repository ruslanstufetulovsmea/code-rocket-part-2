package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.GetUserUseCase;
import com.meawallet.usercrud.core.port.out.FindUserByIdPort;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class GetUserService implements GetUserUseCase {

    private final FindUserByIdPort findUserByIdPort;

    @Override
    public User getUser(Integer id) {
        return findUserByIdPort.findById(id)
                               .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
