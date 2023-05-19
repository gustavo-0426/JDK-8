package com.co.softworld.java8.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

@Slf4j
public class FunctionApp {

    private static void supplier(String msg) {
        log.info("streamSupplier...");
        Supplier<String> upperCase = msg::toUpperCase;
        log.info(upperCase.get());
    }

    private static void booleanSupplier(int number) {
        log.info("booleanSupplier...");
        BooleanSupplier isEven = () -> number % 2 == 0;
        log.info("" + isEven.getAsBoolean());
    }

    private static void intSupplier(int number) {
        log.info("intSupplier...");
        IntSupplier intSupplier = () -> number;
        log.info("" + intSupplier.getAsInt());
    }

    private static void longSupplier(int number) {
        log.info("longSupplier...");
        LongSupplier longSupplier = () -> number;
        log.info("" + longSupplier.getAsLong());
    }

    private static void doubleSupplier(int number) {
        log.info("doubleSupplier...");
        DoubleSupplier doubleSupplier = () -> number;
        log.info("" + doubleSupplier.getAsDouble());
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

    private static void doubleFunction(double value) {
        log.info("doubleFunction...");
        DoubleFunction<Integer> doubleFunction = a -> Math.toIntExact(Math.round(a));
        log.info(""+ doubleFunction.apply(value));
    }

    private static void toDoubleFunction(int value) {
        log.info("toDoubleFunction...");
        ToDoubleFunction<Integer> toDoubleFunction = Integer::doubleValue;
        log.info(""+ toDoubleFunction.applyAsDouble(value));
    }

    private static void intToDoubleFunction(int value) {
        log.info("intToDoubleFunction...");
        IntToDoubleFunction intToDoubleFunction = a -> (double) a;
        log.info(""+ intToDoubleFunction.applyAsDouble(value));
    }

    private static void toIntBiFunction(double number1, double number2) {
        log.info("toIntBiFunction...");
        ToIntBiFunction<Double, Double> toIntBiFunction = (a, b) -> Math.toIntExact(Math.round(a+b));
        log.info(""+ toIntBiFunction.applyAsInt(number1, number2));
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

    private static void intConsumer(int number) {
        log.info("intConsumer...");
        IntConsumer intConsumer = a -> log.info("" + a);
        intConsumer.accept(number);
    }

    private static void objIntConsumer(List<String> names, int beginPosition) {
        log.info("objIntConsumer...");
        ObjIntConsumer<List<String>> objIntConsumer = (list, number) -> {
            AtomicInteger position = new AtomicInteger(number);
            list.stream().forEach(a -> log.info("position : " + position.getAndIncrement() + ", name: " + a ));
        };
        objIntConsumer.accept(names, beginPosition);
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

    private static void intPredicate(int number) {
        log.info("intPredicate...");
        IntPredicate intPredicate = a -> a > 0;
        log.info("" + intPredicate.test(number));
    }

    public static void main(String[] args) {
        supplier("this message must be displayed in uppercase");
        booleanSupplier(8);
        intSupplier(8);
        longSupplier(8);
        doubleSupplier(8);
        function(10);
        biFunction(3.2, 4.5);
        doubleFunction(5.2);
        toDoubleFunction(6);
        intToDoubleFunction(7);
        toIntBiFunction(2.3, 3.2);
        consumer("Gustavo");
        biConsumer("Martin", "Maye");
        intConsumer(7);
        objIntConsumer(Arrays.asList("Martin", "Maye", "Gustavo"), 9);
        predicate("Martin");
        biPredicate("Martin", "Martin");
        intPredicate(2);
    }
}
