package com.co.softworld.java8.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@Slf4j
public class AnnotationsApp {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Languages {
        Language[] value() default {};
    }

    @Repeatable(value = Languages.class)
    public @interface Language {
        String value();
    }

    @Language("Java")
    @Language("Python")
    public interface IProgrammingLanguage {
    }

    public static void main(String[] args) {
        Language[] language = IProgrammingLanguage.class.getAnnotationsByType(Language.class);
        Arrays.stream(language).forEach( language1 -> log.info(String.valueOf(language1)));
        log.info(String.valueOf(language.length));
    }
}
