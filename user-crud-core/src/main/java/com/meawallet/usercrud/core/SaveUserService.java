package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.SaveUserUseCase;
import com.meawallet.usercrud.core.port.out.SaveUserPort;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void saveUser(User user) {
        saveUserPort.save(user);
    }
}
