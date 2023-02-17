package com.co.softworld.java8.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class StreamApp {


    public void filter(List<String> list) {
        log.info("filter...");
        list.stream().filter(val -> val.toUpperCase().startsWith("M")).forEach(log::info);
    }

    public void sort(List<String> list) {
        log.info("sort...");
        log.info("Sort Desc");
        list.stream().sorted((x, y) -> y.compareTo(x)).forEach(log::info);
    }

    public void sort2(List<String> list) {
        log.info("sort2...");
        log.info("Sort Desc2");
        list.stream().sorted(Comparator.reverseOrder()).forEach(log::info);
    }

    public void transformer(List<String> list) {
        log.info("transformer...");
        list.stream().map(String::toUpperCase).forEach(log::info);
    }

    public void limit(List<String> list) {
        log.info("limit...");
        list.stream().limit(3).forEach(log::info);
    }

    public void count(List<String> list) {
        log.info("count...");
        log.info(String.valueOf(list.stream().count()));
    }

    public void parallel(List<String> list) {
        log.info("parallel...");
        log.info("parallelStream");
        list.parallelStream().forEach(log::info);
        log.info("stream");
        list.stream().forEach(log::info);
    }

    public static void main(String[] args) {
        List<String> name = new ArrayList<>(Arrays.asList("Adolfo", "Rocio", "Gustavo", "Maye", "Martin"));
        List<String> number = new ArrayList<>(Arrays.asList("1", "2", "3"));
        StreamApp streamApp = new StreamApp();
        streamApp.filter(name);
        streamApp.sort(name);
        streamApp.sort2(name);
        streamApp.transformer(name);
        streamApp.limit(name);
        streamApp.count(name);
        streamApp.parallel(number);
    }

}
