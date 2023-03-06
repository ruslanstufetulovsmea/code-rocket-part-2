package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.UpdateUserPort;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.repository.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateUserAdapter implements UpdateUserPort {

    private final UserRepository userRepository;
    private final UserDomainToUserEntityConverter userDomainToUserEntityConverter;

    @Override
    public void update(User user) {
        var entity = userDomainToUserEntityConverter.convert(user);
        userRepository.save(entity);
    }
}
