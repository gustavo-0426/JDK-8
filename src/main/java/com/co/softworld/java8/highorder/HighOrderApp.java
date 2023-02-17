package com.co.softworld.java8.highorder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class HighOrderApp {

    private final Function<String, String> converterToUpperCase = String::toUpperCase;
    private final Function<String, String> converterToLowerCase = String::toLowerCase;

    public Function<Integer, String> show(String msg) {
        log.info("show...");
        return x -> msg.concat(" ") + x;
    }

    public void filter(List<String> list, int size, Consumer<String> consumer) {
        log.info("filter...");
        list.stream().filter(customPredicate(size)).forEach(consumer);
    }

    public void filter2(List<String> list, String name, Consumer<String> consumer) {
        log.info("filter2...");
        list.stream().filter(customPredicate2(name)).forEach(consumer);
    }

    public Predicate<String> customPredicate(int size) {
        log.info("customPredicate...");
        return x -> x.length() < size;
    }

    public Predicate<String> customPredicate2(String name) {
        log.info("customPredicate2...");
        return x -> x.toLowerCase().contains(name.toLowerCase());
    }

    public static void main(String[] args) {
        HighOrderApp highOrderApp = new HighOrderApp();
        log.info(highOrderApp.converterToUpperCase(highOrderApp.converterToUpperCase, "Hello"));
        log.info(highOrderApp.converterToUpperCase(highOrderApp.converterToLowerCase, "Welcome"));
        log.info(highOrderApp.show("Function").apply(1));

        List<String> names = new ArrayList<>(Arrays.asList("Gustavo", "Martin", "Maye"));
        highOrderApp.filter(names, 5, log::info);
        highOrderApp.filter2(names, "ma", log::info);
    }

    private String converterToUpperCase(Function<String, String> function, String msg) {
        return function.apply(msg);
    }

}
