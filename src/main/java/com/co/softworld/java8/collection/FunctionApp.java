package com.co.softworld.java8.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
public class FunctionApp {

    static List<String> list = new ArrayList<>(Arrays.asList("Gustavo", "Maye", "Martin"));

    public void forEach(List<String> list) {
        log.info("forEach...");
        list.forEach(log::info);
    }

    public void sort(List<String> list) {
        log.info("sort...");
        list.stream().sorted().forEach(log::info);
    }

    public void removeIf(List<String> list) {
        log.info("removeIf...");
        list.removeIf(v -> v.equalsIgnoreCase("Martin"));
        list.forEach(log::info);
    }

    public static void main(String[] args) {
        FunctionApp functionApp = new FunctionApp();
        functionApp.forEach(list);
        functionApp.sort(list);
        functionApp.removeIf(list);
    }
}