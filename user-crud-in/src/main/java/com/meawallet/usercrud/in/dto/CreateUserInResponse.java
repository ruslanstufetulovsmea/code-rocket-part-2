package com.meawallet.usercrud.in.dto;

public record CreateUserInResponse(
        Integer id,
        String name,
        Integer age,
        String quote
) {
}
