package com.co.softworld.java8.referencemethod;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {
    String name;

    public Persona(String name) {
        this.name = name;
    }
}
