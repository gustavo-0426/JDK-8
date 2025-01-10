package com.co.softworld.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Principal {

    public static void main(String[] args) {

        IntStream numbers = IntStream.range(1, 5); // 1, 2, 3, 4
        List<String> numberStrings = numbers
                .mapToObj(n -> "Number: " + n) // Convertir int a String
                .collect(Collectors.toList());

        System.out.println(numberStrings); // ["Number: 1", "Number: 2", "Number: 3", "Number: 4"]


        // PREDICATE -> boolean test(T t);
        // ********************************************************
        System.out.println("******PREDICATE -> boolean test(T t);**");
        List<Persona> personas = Arrays.asList(
                Persona.builder().name("Gustavo").lastName("Castro").city("Cartagena").build(),
                Persona.builder().name("Martin").lastName("Castro").city("Bogota").build(),
                Persona.builder().name("Maye").lastName("Sierra").city("Medellin").build());

        Predicate<Persona> predicate = per ->
                per.getCity().equalsIgnoreCase("Medellin") || per.getLastName().equalsIgnoreCase("Sierra");

        List<Persona> result = filter(personas, predicate);
        result.forEach(p -> System.out.println(p.getName() + "\n"));


        // CONSUMER -> void accept(T t);
        // ********************************************************
        System.out.println("******CONSUMER -> void accept(T t);****");
        Consumer<String> consumer = t -> {
            double x = 2;
            double y = 5;
            System.out.println(t + (x + y)/2 + "\n");
        };
        consumer.accept("EL PROMEDIO ES: ");


        // SUPPLIER -> T get();
        // ********************************************************
        System.out.println("******SUPPLIER -> T get();************");
        Supplier<String> supplier = () -> {
            String cadenas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890*-.=";
            StringBuilder password = new StringBuilder();
            IntStream.range(0, 13)
                    .map(x -> new Random().nextInt(cadenas.length()))
                    .forEach(x -> password.append(cadenas.charAt(x)));
            return password.toString();
        };
        System.out.println("Password: " + supplier.get() + "\n");

        // FUNCTION -> R apply(T t);
        // ********************************************************
        System.out.println("******FUNCTION -> R apply(T t);*******");
        Function<String, Integer> sise = String::length;
        System.out.println(sise.apply("Gustavo"));


    }

    private static List<Persona> filter(List<Persona> personas, Predicate<Persona> predicate) {
        return personas.stream().filter(predicate).collect(Collectors.toList());
    }
}
