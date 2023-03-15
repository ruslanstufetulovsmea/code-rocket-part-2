package com.meawallet.usercrud.core.port.out;

import com.meawallet.usercrud.domain.Quote;

public interface SaveQuotePort {

    Quote saveQuote(Quote quote);
}
