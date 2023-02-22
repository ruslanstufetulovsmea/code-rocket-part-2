package com.meawallet.usercrud.database;

import com.meawallet.usercrud.database.converter.UserDomainToUserEntityConverter;
import com.meawallet.usercrud.database.converter.UserEntityToUserDomainConverter;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;


@AllArgsConstructor
public class UserJdbcTemplateRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserDomainToUserEntityConverter userDomainToUserEntityConverter;
    private final UserEntityToUserDomainConverter userEntityToUserDomainConverter;

    @Override
    public void save(User user) {
        var entity = userDomainToUserEntityConverter.convert(user);
        jdbcTemplate.update("INSERT INTO users(name, age) VALUES (?,?)", entity.getName(), entity.getAge());
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        var sql = "SELECT * FROM users WHERE id = ?";

        var entity = (UserEntity) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(UserEntity.class));
        var user = userEntityToUserDomainConverter.convert(entity);
        return Optional.ofNullable(user);
    }
}
