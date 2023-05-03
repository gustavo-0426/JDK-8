package com.co.softworld.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.function.*;

@Slf4j
public class StreamApp {

    private static void supplier(String msg) {
        log.info("streamSupplier...");
        Supplier<String> upperCase = msg::toUpperCase;
        log.info(upperCase.get());
    }

    private static void function(int value) {
        log.info("streamFunction...");
        String message = "your final score is ";
        Function<Integer, String> function = note -> message + note;
        log.info(function.apply(value));
    }

    private static void biFunction(double value, double value2) {
        log.info("biFunction...");
        BiFunction<Double, Double, String> biFunction = (a,b) -> String.format("%.2f", (a+b));
        log.info(biFunction.apply(value, value2));
    }

    private static void consumer(String data) {
        log.info("consumer...");
        Consumer<String> consumer = a -> log.info(a.toUpperCase());
        consumer.accept(data);
    }

    private static void biConsumer(String name1, String name2) {
        log.info("biConsumer...");
        BiConsumer<String, String> biConsumer = (a, b) -> log.info(a.concat(" and ").concat(b));
        biConsumer.accept(name1, name2);
    }

    private static void predicate(String name) {
        log.info("predicate...");
        Predicate<String> predicate = a -> a.length() > 10;
        log.info("" + predicate.test(name));
    }

    private static void biPredicate(String name, String name2) {
        log.info("biPredicate...");
        BiPredicate<String, String> biPredicate = String::equals;
        log.info("" + biPredicate.test(name, name2));
    }

    public static void main(String[] args) {
        supplier("this message must be displayed in uppercase");
        function(10);
        biFunction(3.2, 4.5);
        consumer("Gustavo");
        biConsumer("Martin", "Maye");
        predicate("Martin");
        biPredicate("Martin", "Martin");
    }
}
