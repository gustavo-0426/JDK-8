package com.co.softworld.java8;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Persona {

    private String name;
    private String lastName;
    private String city;
}
