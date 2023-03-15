package com.meawallet.usercrud.domain;

import lombok.Builder;

@Builder
public record Quote(
        Integer id,
        String author,
        String content
) {
}
