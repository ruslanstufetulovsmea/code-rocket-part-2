package com.meawallet.usercrud.core;

import com.meawallet.usercrud.core.port.in.SaveUserUseCase;
import com.meawallet.usercrud.core.port.out.GenerateRandomQuotePort;
import com.meawallet.usercrud.core.port.out.SaveQuotePort;
import com.meawallet.usercrud.core.port.out.SaveUserPort;
import com.meawallet.usercrud.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;
    private final GenerateRandomQuotePort generateRandomQuotePort;
    private final SaveQuotePort quotePort;

    @Override
    public User saveUser(User user) {
        var quote = generateRandomQuotePort.generateRandomQuote();
        log.debug("Quote generated: {}", quote);
        var savedQuote = quotePort.saveQuote(quote);
        var userWithQuote = user.toBuilder()
                                .quote(savedQuote)
                                .build();
        return saveUserPort.save(userWithQuote);
    }
}
