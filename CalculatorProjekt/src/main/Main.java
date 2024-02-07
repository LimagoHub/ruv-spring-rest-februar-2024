package main;

import client.CalcClient;
import common.LoggerProxy;
import math.Calculator;
import math.CalculatorImpl;
import math.CalculatorLogger;
import math.CalculatorSecure;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl(); // 1000
        //calculator = new CalculatorLogger(calculator);// 2000
        calculator = (Calculator) LoggerProxy.newInstance(calculator);
        calculator = new CalculatorSecure(calculator);//3000
        CalcClient client = new CalcClient(calculator);
        client.run();
    }
}