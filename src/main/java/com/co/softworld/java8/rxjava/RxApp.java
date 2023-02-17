package com.co.softworld.java8.rxjava;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class RxApp {

    public static void merge(List<String> numbers, List<String> objects) {
        log.info("merge...");
        Observable<String> observableNumber = Observable.from(numbers);
        Observable<String> observableObject = Observable.from(objects);

        Observable.merge(observableNumber, observableObject)
                .filter(name -> name.startsWith("F"))
                .subscribe(log::info);
    }

    public static void merge2(List<String> numbers, List<String> objects) {
        log.info("merge2...");
        Observable<String> observableNumber = Observable.from(numbers);
        Observable<String> observableObject = Observable.from(objects);

        Observable.merge(observableNumber, observableObject)
                .filter(name -> name.startsWith("T"))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        log.info(s);
                    }
                });
    }

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("One", "Two", "Three", "Four", "Five");
        List<String> objects = Arrays.asList("Phone", "Book", "Fox", "Tree", "Football", "Tv", "Truck");

        merge(numbers, objects);
        merge2(numbers, objects);
    }
}
