package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.SaveUserPort;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.repository.converter.UserEntityToUserDomainConverter;
import com.meawallet.usercrud.repository.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserPort {

    private final UserRepository userRepository;
    private final UserDomainToUserEntityConverter userDomainToUserEntityConverter;
    private final UserEntityToUserDomainConverter userEntityToUserDomainConverter;

    @Override
    public User save(User user) {
        var entity = userDomainToUserEntityConverter.convert(user);
        userRepository.saveAndFlush(entity);
        log.debug("User: {} saved successfully", entity);
        return userEntityToUserDomainConverter.convert(entity);
    }
}
