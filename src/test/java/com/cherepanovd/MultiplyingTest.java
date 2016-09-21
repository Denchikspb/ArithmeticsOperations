package com.cherepanovd;

import com.cherepanovd.Reader.FileReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.List;

@Title("Тест на умножение")
public class MultiplyingTest extends Operation {

    public MultiplyingTest(String operand1, String operand2, String operation, String result) {
        super(operand1, operand2, operation, result);
    }

    @Parameterized.Parameters
    public static List<String[]> testData() {
        final List<String[]> data = FileReader.readFile("src/main/resources/datafile");
        final List<String[]> positiveData = new ArrayList<String[]>();
        for (String[] s : data) {
            if ("*".equals(s[2]))
                positiveData.add(s);
        }
        return positiveData;
    }

    @Title("Проверка на умножение")
    @Test
    public void test() {
        int expectedResult = Integer.parseInt(result);
        int first = Integer.parseInt(operand1);
        int second = Integer.parseInt(operand2);
        checkResult(expectedResult, mult(first,second));
    }

    @Step("Проверяем {0} * {1}")
    public int mult(int first, int second){
        return first * second;
    }

    @Step("Проверка результата вычислений: {0} = {1}?")
    public void checkResult(int expectedResult, int actualResult){
        Assert.assertTrue("Полученное число("+ actualResult+") не равно проверяемому("+expectedResult+")", actualResult == expectedResult);
    }
}
