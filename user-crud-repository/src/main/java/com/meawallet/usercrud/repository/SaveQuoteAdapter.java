package com.meawallet.usercrud.repository;

import com.meawallet.usercrud.core.port.out.SaveQuotePort;
import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.repository.converter.QuoteToQuoteEntityConverter;
import com.meawallet.usercrud.repository.repository.QuoteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveQuoteAdapter implements SaveQuotePort {

    private final QuoteRepository quoteRepository;
    private final QuoteToQuoteEntityConverter quoteToQuoteEntityConverter;

    @Override
    public Quote saveQuote(Quote quote) {
        var entity = quoteToQuoteEntityConverter.convert(quote);
        quoteRepository.saveAndFlush(entity);
        return Quote.builder()
                    .id(entity.getId())
                    .content(quote.content())
                    .author(quote.author())
                    .build();
    }
}
