package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDomainToUserEntityConverter {

    private final QuoteToQuoteEntityConverter quoteToQuoteEntityConverter;

    public UserEntity convert(User user) {
        var quoteEntity = quoteToQuoteEntityConverter.convert(user.getQuote());
        return UserEntity.builder()
                         .id(user.getId())
                         .name(user.getName())
                         .age(user.getAge())
                         .quote(quoteEntity)
                         .build();
    }
}
