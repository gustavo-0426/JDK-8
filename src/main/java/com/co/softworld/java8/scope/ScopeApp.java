package com.co.softworld.java8.scope;

import com.co.softworld.java8.lambda.IOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class ScopeApp {

    static double globalStaticScope;
    double globalScope;

    public void localVariableFinal(double num, double num2) {
        log.info("localVariableFinal...");
        /**
         * double scope = 0;
         */
        final double scope = num + num2;
        IOperation operation = (x, y) -> {
            /**
             * scope = x + y; Generates error because the variable must be final,
             * but if it is final, it can only be used and not modified
             */
            return scope / 2;
        };
        log.info(String.valueOf(operation.calculateAverage(num, num2)));
    }

    public void localVariableAtomic(double num, double num2) {
        log.info("localVariableAtomic...");
        AtomicReference<Double> scope = new AtomicReference<>();
        IOperation operation = (x, y) -> {
            scope.set(x + y);
            return scope.get() / 2;
        };
        log.info(String.valueOf(operation.calculateAverage(num, num2)));
    }

    public void globalVariable(double num, double num2) {
        log.info("globalVariable...");
        IOperation operation = (x, y) -> {
            globalScope = x + y;
            return globalScope / 2;
        };
        log.info(String.valueOf(operation.calculateAverage(num, num2)));
    }

    public void globalVariableStatic(double num, double num2) {
        log.info("globalVariableStatic...");
        IOperation operation = (x, y) -> {
            globalStaticScope = x + y;
            return globalStaticScope / 2;
        };
        log.info(String.valueOf(operation.calculateAverage(num, num2)));
    }

    public static void main(String[] args) {
        ScopeApp scope = new ScopeApp();
        scope.localVariableFinal(2, 6);
        scope.localVariableAtomic(3, 4);
        scope.globalVariable(4, 6);
        scope.globalVariableStatic(2, 1);
    }
}
