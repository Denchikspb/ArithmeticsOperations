package com.cherepanovd;

import com.cherepanovd.Reader.FileReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
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
        try {
            final int expectedResult = Integer.parseInt(result);
            final int actualResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
            Assert.assertEquals(expectedResult, actualResult);
        } catch (ArithmeticException ex) {
            Assert.assertEquals(ex.getMessage(), "Деление на 0");
            Assert.assertEquals(result, "0");
        }
    }

}
