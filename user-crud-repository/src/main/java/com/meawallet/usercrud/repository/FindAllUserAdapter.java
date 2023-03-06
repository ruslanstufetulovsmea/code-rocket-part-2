package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.FindAllUserPort;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.converter.UserEntityToUserDomainConverter;
import com.meawallet.usercrud.repository.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllUserAdapter implements FindAllUserPort {

    private final UserRepository userRepository;
    private final UserEntityToUserDomainConverter userEntityToUserDomainConverter;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                             .map(userEntityToUserDomainConverter::convert)
                             .collect(Collectors.toList());
    }
}
