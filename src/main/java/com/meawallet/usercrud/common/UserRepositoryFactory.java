package com.meawallet.usercrud.common;

import com.meawallet.usercrud.database.ArrayListUserRepository;
import com.meawallet.usercrud.database.HashMapUserRepository;
import com.meawallet.usercrud.database.UserRepository;
import com.meawallet.usercrud.database.converter.UserDomainToUserEntityConverter;

public class UserRepositoryFactory {

    public static UserRepository create(String name) {
        UserDomainToUserEntityConverter userDomainToUserEntityConverter = new UserDomainToUserEntityConverter();
        if ("ARRAY".equals(name)) {
            return new ArrayListUserRepository(userDomainToUserEntityConverter);
        }
        if ("MAP".equals(name)) {
            return new HashMapUserRepository(userDomainToUserEntityConverter);
        }
        throw new IllegalStateException("Database not chosen");
    }
}
