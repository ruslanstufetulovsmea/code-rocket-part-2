package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserEntityToUserDomainConverter {

    private final QuoteEntityToQuoteConverter quoteEntityToQuoteConverter;

    public User convert(UserEntity entity) {
        var builder = User.builder()
                          .age(entity.getAge())
                          .name(entity.getName())
                          .id(entity.getId());

        Optional.ofNullable(entity.getQuote())
                .map(quoteEntityToQuoteConverter::convert)
                .ifPresent(builder::quote);

        return builder
                .build();
    }
}
