package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.repository.entity.QuoteEntity;
import org.springframework.stereotype.Component;

@Component
public class QuoteToQuoteEntityConverter {

    public QuoteEntity convert(Quote quote) {
        return QuoteEntity.builder()
                          .id(quote.id())
                          .author(quote.author())
                          .content(quote.content())
                          .build();
    }
}
