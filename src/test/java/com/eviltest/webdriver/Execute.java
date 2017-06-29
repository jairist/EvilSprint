package com.eviltest.webdriver;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Execute {

    public static void main(String[] args){
        JUnitCore junit = new JUnitCore();
        Result result = junit.run();

    }
}
