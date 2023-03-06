package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.DeleteUserByIdPort;
import com.meawallet.usercrud.repository.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteUserByIdAdapter implements DeleteUserByIdPort {

    private final UserRepository userRepository;

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
