package com.co.softworld.java8.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class MapApp {

    public void forEachBiConsumer(Map<Integer, String> map) {
        log.info("forEachBiConsumer...");
        map.forEach((key, value) -> log.info("key: " + key + " value: " + value));
    }

    public void forEachStream(Map<Integer, String> map) {
        log.info("forEachStream...");
        map.entrySet().forEach(entry -> log.info(String.valueOf(entry)));
    }

    public void putIfAbsent(Map<Integer, String> map) {
        log.info("putIfAbsent...");
        map.putIfAbsent(4, "new four");
        map.entrySet().forEach(entry -> log.info(String.valueOf(entry)));
    }

    public void computeIfAbsent(Map<Integer, String> map) {
        log.info("computeIfAbsent...");
        map.computeIfAbsent(6, String::valueOf);
        map.entrySet().forEach(entry -> log.info(String.valueOf(entry)));
    }

    public void computeIfPresent(Map<Integer, String> map) {
        log.info("computeIfPresent...");
        map.computeIfPresent(5, (key, value) -> value.concat(" new"));
        map.entrySet().forEach(entry -> log.info(String.valueOf(entry)));
    }

    public void defaultValue(Map<Integer, String> map) {
        log.info("defaultValue...");
        log.info(map.getOrDefault(7, "default"));
    }

    public void collect(Map<Integer, String> map) {
        log.info("collect...");
        Map<Integer, String> result = map.entrySet().stream()
                .filter(x -> x.getValue().toLowerCase().startsWith("f"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        result.entrySet().forEach( entry -> log.info(String.valueOf(entry)));
    }

    public static void main(String[] args) {
        MapApp mapApp = new MapApp();
        Map<Integer, String> number = new HashMap<>();
        number.put(1, "one");
        number.put(2, "two");
        number.put(3, "three");
        number.put(4, "four");
        number.put(5, "five");

        mapApp.forEachBiConsumer(number);
        mapApp.forEachStream(number);
        mapApp.putIfAbsent(number);
        mapApp.computeIfAbsent(number);
        mapApp.computeIfPresent(number);
        mapApp.defaultValue(number);
        mapApp.collect(number);
    }
}
