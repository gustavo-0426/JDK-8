package com.co.softworld.java8.functionalinterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalApp {

    public void functional(String text) {
        IFunctionalInterface functional = log::info;
        functional.functionalInterface(text);
    }

    public static void main(String[] args) {
        FunctionalApp functionalApp = new FunctionalApp();
        functionalApp.functional("This is a example of FunctionalInterface...");
    }
}
