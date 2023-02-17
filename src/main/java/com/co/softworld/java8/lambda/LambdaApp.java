package com.co.softworld.java8.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * jDK 8   -> Enfoque declarativo
 * JDK < 8 -> Enfoque imperativo
 */
@Slf4j
public class LambdaApp {

    /**
     * Collection ordered with the JDK < 8
     */
    public void orderWithoutLambda(List<String> list) {
        log.info("orderWithoutLambda...");
        list.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list.forEach(log::info);
    }

    /**
     * Collection ordered with the JDK 8 used lambda
     */
    public void orderWithLambda(List<String> list) {
        log.info("orderWithLambda...");
        list.sort(String::compareTo);
        list.forEach(log::info);
    }

    /**
     * Without JDK 8
     */
    public void calculateWithoutLambda(double number1, double number2) {
        log.info("calculateWithoutLambda...");
        IOperation operation = new IOperation() {
            @Override
            public double calculateAverage(double number1, double number2) {
                return (number1 + number2) / 2;
            }
        };
        log.info(String.valueOf(operation.calculateAverage(number1, number2)));
    }

    /**
     * With JDK 8
     */
    public void calculateWithLambda(double number1, double number2) {
        log.info("calculateWithLambda...");
        IOperation operation = (num1, num2) -> (num1 + num2) / 2;
        log.info(String.valueOf(operation.calculateAverage(number1, number2)));
    }

    public static void main(String[] args) {
        LambdaApp lambda = new LambdaApp();
        List<String> name = new ArrayList<>();
        List<String> lastName = new ArrayList<>();
        name.add("Martin");
        name.add("Maye");
        name.add("Gustavo");

        lastName.add("Castro");
        lastName.add("Sierra");
        lastName.add("Cardenas");

        lambda.orderWithoutLambda(name);
        lambda.orderWithLambda(lastName);
        lambda.calculateWithoutLambda(3, 4);
        lambda.calculateWithLambda(3, 4);
    }

}
