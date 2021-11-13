package steps;

import org.testng.Assert;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;

public class ExplanationSteps {
    private int result;

    @Дано("Я складываю числа (.+) и (.+)")
    public void sumNumbers(int first, int second) {
        result = first + second;
    }

    @Пусть("Я вычитаю из числа (.+) число (.+)")
    public void subtract15and8(int first, int second) {
        result = first - second;
    }

    @Тогда("В результате я получаю (.+)")
    public void assertResult10(int expectedResult) {
        Assert.assertEquals(result, expectedResult);
    }
}
