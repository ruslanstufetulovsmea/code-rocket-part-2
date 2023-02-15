package com.meawallet.usercrud.dto;

import lombok.Value;

@Value
public class CreateUserInRequest {

    String name;
    Integer age;
}
