package com.cherepanovd;

import com.cherepanovd.Reader.FileReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.List;

@Title("Тест на деление")
public class DivisionTest extends Operation {
    public DivisionTest(String operand1, String operand2, String operation, String result) {
        super(operand1, operand2, operation, result);
    }

    @Parameterized.Parameters
    public static List<String[]> testData() {
        final List<String[]> data = FileReader.readFile("src/main/resources/datafile");
        final List<String[]> positiveData = new ArrayList<String[]>();
        for (String[] s : data) {
            if ("/".equals(s[2]))
                positiveData.add(s);
        }
        return positiveData;
    }


    @Title("Проверка на деление")
    @Test
    public void test() {
        int expectedResult = Integer.parseInt(result);
        int first = Integer.parseInt(operand1);
        int second = Integer.parseInt(operand2);
        checkResult(getDivisionResult(first,second), expectedResult);
    }

    @Step("Проверка результата вычислений {0} = {1}?")
    private void checkResult(int actualResult, int expectedResult) {
        Assert.assertTrue("Полученное число("+ actualResult+") не равно проверяемому("+expectedResult+")", actualResult == expectedResult);
    }

    @Step("Получение результата деления числа {0} на {1}")
    private int getDivisionResult(int firstInt, int secondInt) {
        checkNotZero(secondInt);
        return firstInt / secondInt;
    }

    @Step("Проверка делителя")
    private void checkNotZero(int intValue) {
        Assert.assertTrue("Делитель равен 0", intValue != 0);
    }

}
