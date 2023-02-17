package com.co.softworld.java8.defaultmethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultApp implements IPerson, IAnimal {

    @Override
    public void crawl() {
        log.info("Crawl from Default...");
    }

    @Override
    public void walk() {
        IPerson.super.walk();
    }

    public static void main(String[] args) {
        DefaultApp defaultApp = new DefaultApp();
        defaultApp.crawl();
        defaultApp.walk();
    }
}
