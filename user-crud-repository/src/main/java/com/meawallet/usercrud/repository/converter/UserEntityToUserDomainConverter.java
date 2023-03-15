package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserEntityToUserDomainConverter {

    private final QuoteEntityToQuoteConverter quoteEntityToQuoteConverter;

    public User convert(UserEntity entity) {
        var quote = quoteEntityToQuoteConverter.convert(entity.getQuote());
        return User.builder()
                   .age(entity.getAge())
                   .name(entity.getName())
                   .id(entity.getId())
                   .quote(quote)
                   .build();
    }
}
