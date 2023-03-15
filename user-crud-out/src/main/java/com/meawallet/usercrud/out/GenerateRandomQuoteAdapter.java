package com.meawallet.usercrud.out;

import com.meawallet.usercrud.core.port.out.GenerateRandomQuotePort;
import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.out.converter.GetQuoteOutResponseToQuoteConverter;
import com.meawallet.usercrud.out.dto.GetQuoteOutResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@AllArgsConstructor
public class GenerateRandomQuoteAdapter implements GenerateRandomQuotePort {

    private final RestTemplate restTemplate;
    private final GetQuoteOutResponseToQuoteConverter getQuoteOutResponseToQuoteConverter;

    @Override
    public Quote generateRandomQuote() {
        var response = restTemplate.getForEntity("https://api.quotable.io/random", GetQuoteOutResponse.class)
                                   .getBody();
        log.debug("Received random quote: {}", response);
        var quote = getQuoteOutResponseToQuoteConverter.convert(response);
        return quote;
    }
}
