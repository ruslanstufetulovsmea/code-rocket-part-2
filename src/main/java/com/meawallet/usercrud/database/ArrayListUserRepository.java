package com.meawallet.usercrud.database;

import com.meawallet.usercrud.database.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ArrayListUserRepository implements UserRepository {

    private static Integer USER_SEQUENCE = 1;
    private List<UserEntity> repository = new ArrayList<>();
    private final UserDomainToUserEntityConverter converter;

    @Override
    public void save(User user) {
        UserEntity entity = converter.convert(user, USER_SEQUENCE);
        USER_SEQUENCE++;
        repository.add(entity);
    }
}
