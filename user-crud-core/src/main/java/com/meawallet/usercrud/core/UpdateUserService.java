package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.UpdateUserUseCase;
import com.meawallet.usercrud.core.port.out.FindUserByIdPort;
import com.meawallet.usercrud.core.port.out.UpdateUserPort;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final FindUserByIdPort findUserByIdPort;
    private final UpdateUserPort updateUserPort;

    @Override
    public void update(User user) {
        findUserByIdPort.findById(user.getId())
                        .orElseThrow(() -> new IllegalArgumentException("User not found."));

        updateUserPort.update(user);
    }

}
