package com.meawallet.usercrud.out.converter;

import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.out.dto.GetQuoteOutResponse;
import org.springframework.stereotype.Component;

@Component
public class GetQuoteOutResponseToQuoteConverter {

    public Quote convert(GetQuoteOutResponse response) {
        return Quote.builder()
                    .content(response.content())
                    .author(response.author())
                    .build();
    }
}
