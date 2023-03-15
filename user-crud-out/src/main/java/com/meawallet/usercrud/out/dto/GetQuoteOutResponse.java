package com.meawallet.usercrud.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record GetQuoteOutResponse(
        @JsonProperty(value = "_id")
        String externalId,
        String content,
        String author,
        List<String> tags,
        String authorSlug,
        Integer length,
        LocalDate dateAdded,
        LocalDate dateModified
) {

}
