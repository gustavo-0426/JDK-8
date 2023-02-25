package com.co.softworld.java8.referencemethod;

import com.co.softworld.java8.functionalinterface.IFunctionalInterface;
import com.co.softworld.java8.functionalinterface.IFunctionalInterfaceBuilder;
import lombok.extern.slf4j.Slf4j;

import static java.util.Arrays.asList;
import java.util.List;

@Slf4j
public class ReferenceMethodApp {

    public void referenceMethodObject() {
        log.info("referenceMethodObject...");
        List<String> list = asList("Martin", "Gustavo", "Maye");
        /**
         ** this is the reference to method object
         **/
        list.sort(String::compareTo);
        list.forEach(log::info);
    }

    public void referenceMethodParticular(String text) {
        log.info("referenceMethodParticular...");
        log.info(text);
    }

    public void referenceBuilder(String name) {
        log.info("referenceBuilder...");
        IFunctionalInterfaceBuilder builder = Persona::new;
        Persona person = builder.functionalBuilder(name);
        log.info(person.name);
    }

    public static void referenceMethodStatic(String text) {
        log.info("referenceMethodStatic...");
        log.info(text);
    }

    public static void main(String[] args) {
        ReferenceMethodApp referenceMethodApp = new ReferenceMethodApp();

        referenceMethodApp.referenceMethodObject();

        /**
         * Reference to method Particular
         */
        IFunctionalInterface functionalParticular = referenceMethodApp::referenceMethodParticular;
        functionalParticular.functionalInterface("Method Particular");

        /**
         * Reference to builder
         */
        IFunctionalInterface builder = referenceMethodApp::referenceBuilder;
        builder.functionalInterface("Gustavo");

        /**
         * Reference to method static
         */
        IFunctionalInterface functionalStatic = ReferenceMethodApp::referenceMethodStatic;
        functionalStatic.functionalInterface("Method Static");

    }
}
