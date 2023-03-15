package com.meawallet.usercrud.repository.converter;

import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.repository.entity.QuoteEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuoteEntityToQuoteConverter {

    public Quote convert(QuoteEntity entity) {
        return Quote.builder()
                    .id(entity.getId())
                    .author(entity.getAuthor())
                    .content(entity.getContent())
                    .build();
    }

}
