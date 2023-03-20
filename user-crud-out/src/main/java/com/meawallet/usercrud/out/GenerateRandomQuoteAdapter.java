package com.meawallet.usercrud.out;

import com.meawallet.usercrud.core.port.out.GenerateRandomQuotePort;
import com.meawallet.usercrud.domain.Quote;
import com.meawallet.usercrud.out.config.QuoteApiConfig;
import com.meawallet.usercrud.out.converter.GetQuoteOutResponseToQuoteConverter;
import com.meawallet.usercrud.out.dto.GetQuoteOutResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@AllArgsConstructor
public class GenerateRandomQuoteAdapter implements GenerateRandomQuotePort {

    private final RestTemplate restTemplate;
    private final QuoteApiConfig quoteApiConfig;
    private final GetQuoteOutResponseToQuoteConverter getQuoteOutResponseToQuoteConverter;

    @Override
    public Quote generateRandomQuote() {
        try {
            var response = restTemplate.getForEntity(quoteApiConfig.getQuoteUrl(), GetQuoteOutResponse.class)
                                       .getBody();

            log.debug("Received random quote: {}", response);
            return getQuoteOutResponseToQuoteConverter.convert(response);
        } catch (RestClientException restClientException) {
            log.error("Received error from quote API: {}", restClientException.getMessage());
            throw new RuntimeException(restClientException);
        }
    }
}
