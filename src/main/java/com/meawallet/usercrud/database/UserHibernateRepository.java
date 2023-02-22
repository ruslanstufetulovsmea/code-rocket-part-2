package com.meawallet.usercrud.database;

import com.meawallet.usercrud.database.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.database.converter.UserEntityToUserDomainConverter;
import com.meawallet.usercrud.domain.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class UserHibernateRepository implements UserRepository {

    private final SessionFactory sessionFactory;
    private final UserDomainToUserEntityConverter domainToUserEntityConverter;
    private final UserEntityToUserDomainConverter userEntityToUserDomainConverter;

    @Override
    public void save(User user) {
        var entity = domainToUserEntityConverter.convert(user);
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(UserEntity.class, id);
        return Optional.ofNullable(entity)
                       .map(userEntityToUserDomainConverter::convert);
    }
}
