package com.meawallet.usercrud.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class User {
    Integer id;
    String name;
    Integer age;
    Quote quote;
}
