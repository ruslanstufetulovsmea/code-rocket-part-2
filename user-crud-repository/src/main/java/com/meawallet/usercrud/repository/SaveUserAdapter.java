package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.SaveUserPort;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Transactional
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserPort {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
