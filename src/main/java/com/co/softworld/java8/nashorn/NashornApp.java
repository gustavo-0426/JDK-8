package com.co.softworld.java8.nashorn;

import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Slf4j
public class NashornApp {

    private final ScriptEngine scriptEngine;
    private final Invocable invocable;

    public NashornApp() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        invocable = (Invocable) scriptEngine;
    }

    public void evalFile() throws ScriptException, FileNotFoundException {
        scriptEngine.eval(new FileReader("src/main/java/com/co/softworld/java8/nashorn/file.js"));
    }

    public void evalFunction() throws ScriptException {
        scriptEngine.eval("print('Printing from function javaScript...')");
    }

    public void evalFunctionFromFile() throws ScriptException, NoSuchMethodException {
        scriptEngine.eval("print('Printing from function javaScript...')");
        double result = (double) invocable.invokeFunction("sum", 2, 5);
        log.info(String.valueOf(result));
    }


    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {

        NashornApp nashornApp = new NashornApp();
        nashornApp.evalFile();
        nashornApp.evalFunction();
        nashornApp.evalFunctionFromFile();

    }

}
