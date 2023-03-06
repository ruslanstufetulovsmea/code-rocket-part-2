package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.DeleteUserByIdUseCase;
import com.meawallet.usercrud.core.port.out.DeleteUserByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserByIdService implements DeleteUserByIdUseCase {

    private final DeleteUserByIdPort deleteUserByIdPort;

    @Override
    public void deleteById(Integer id) {
        deleteUserByIdPort.deleteById(id);
    }
}
