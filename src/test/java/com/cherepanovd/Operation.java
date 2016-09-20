package com.cherepanovd;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

/**
 * Created by Denis on 20.09.2016.
 */
@RunWith(value = Parameterized.class)
public abstract class Operation {
    protected String operand1;
    protected String operand2;
    protected String operation;
    protected String result;

    public Operation(String operand1, String operand2, String operation, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.result = result;
    }
    abstract void test();
}
