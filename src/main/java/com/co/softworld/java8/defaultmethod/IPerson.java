package com.co.softworld.java8.defaultmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IPerson {

    Logger log = LoggerFactory.getLogger(IAnimal.class);

    void crawl();

    default void walk() {
        log.info("Walk from interface IPersona...");
    }

}
