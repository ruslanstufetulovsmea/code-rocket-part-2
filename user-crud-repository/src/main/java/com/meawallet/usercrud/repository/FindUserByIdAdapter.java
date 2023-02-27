package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.FindUserByIdPort;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdPort {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findUserById(id);
    }
}
