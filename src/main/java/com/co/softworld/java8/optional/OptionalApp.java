package com.co.softworld.java8.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
public class OptionalApp {

    /**
     * generate a exception NoSuchElementException
     */
    public static void empty() {
        log.info("empty...");
        Optional<String> optional = Optional.empty();
        try {
            optional.get();
        } catch (NoSuchElementException e) {
            log.info("No Value Present");
        }
    }

    public static void isPresent(String value) {
        log.info("isPresent...");
        Optional<String> optional = Optional.ofNullable(value);

        if (optional.isPresent()) {
            log.info("present");
        } else
            log.info("not present");
    }

    public static void orElse(String value) {
        log.info("orElse...");
        Optional<String> optional = Optional.ofNullable(value);
        log.info(optional.orElse("Other"));
    }

    public static void orElseGet(String value) {
        log.info("orElseGet...");
        Optional<String> optional = Optional.ofNullable(value);
        log.info(optional.orElseGet(OptionalApp::getValue));
    }

    public static void orElseThrow(String value) {
        log.info("orElseThrow...");
        Optional<String> optional = Optional.ofNullable(value);
        optional.orElseThrow(NumberFormatException::new);
    }

    public static String getValue() {
        log.info("getValue...");
        return "value";
    }

    public static void main(String[] args) {
        empty();
        isPresent(null);
        orElse(null);
        orElseGet(null);
        orElseThrow(null);
    }

}
