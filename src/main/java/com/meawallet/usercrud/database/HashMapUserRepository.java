package com.meawallet.usercrud.database;

import com.meawallet.usercrud.database.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class HashMapUserRepository implements UserRepository {

    private static Integer USER_SEQUENCE = 1;
    private Map<Integer, UserEntity> repository = new HashMap<>();
    private final UserDomainToUserEntityConverter converter;

    @Override
    public void save(User user) {
        UserEntity entity = converter.convert(user, USER_SEQUENCE);
        USER_SEQUENCE++;
        repository.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return Optional.empty();
    }
}
