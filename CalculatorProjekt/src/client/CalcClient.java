package client;

import math.Calculator;

public class CalcClient {

    private final Calculator calculator;

    public CalcClient(final Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        System.out.println(calculator.sub(3,4));
    }
}
