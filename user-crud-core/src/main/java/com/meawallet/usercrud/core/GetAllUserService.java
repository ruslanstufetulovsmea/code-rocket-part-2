package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.GetAllUsersUseCase;
import com.meawallet.usercrud.core.port.out.FindAllUserPort;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllUserService implements GetAllUsersUseCase {

    private final FindAllUserPort findAllUserPort;

    @Override
    public List<User> getAll() {
        return findAllUserPort.findAll();
    }
}
