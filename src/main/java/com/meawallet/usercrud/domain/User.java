package com.meawallet.usercrud.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    Integer id;
    String name;
    Integer age;

}
