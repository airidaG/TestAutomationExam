import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Tag("Calculator")
public class CalculatorTests extends BaseTest{
    private static final String CALC_ERROR_MESSAGE = "Validacijos klaida: skaičius negali būti neigiamas";

    @Test
    @DisplayName("Should calculate correct sum")
    void correctlyCalculatesSum() {
        register();
        login();
        TestDataUtil.generateFirstNumber();
        TestDataUtil.generateSecondNumber();
        homePage.selectOperation(TestDataUtil.getPlus());
        homePage.enterFirstNum(TestDataUtil.getFirstNum());
        homePage.enterSecondNum(TestDataUtil.getSecondNum());
        homePage.clickCalculate();
        assertCorrectSum(TestDataUtil.getFirstNum(), TestDataUtil.getSecondNum());
    }
    @Test
    @DisplayName("Should not calculate with negative inputs")
    void calculateSumWithNegativeNum() {
        register();
        login();
        homePage.selectOperation(TestDataUtil.getPlus());
        homePage.enterFirstNum(TestDataUtil.getFirstNumNegative());
        homePage.enterSecondNum(TestDataUtil.getSecondNumNegative());
        homePage.clickCalculate();
        assertPresentError();
    }

    @Test
    @DisplayName("Should correctly calculate subtraction")
    void correctlyCalculatesSubtraction() {
        register();
        login();
        TestDataUtil.generateFirstNumber();
        TestDataUtil.generateSecondNumber();
        homePage.selectOperation(TestDataUtil.getMinus());
        homePage.enterFirstNum(TestDataUtil.getFirstNum());
        homePage.enterSecondNum(TestDataUtil.getSecondNum());
        homePage.clickCalculate();
        assertCorrectSubtraction(TestDataUtil.getFirstNum(), TestDataUtil.getSecondNum());
    }
    @Test
    @DisplayName("Should not calculate subtraction with negative inputs")
    void calculateSumWithNegativeSubtraction() {
        register();
        login();
        homePage.selectOperation(TestDataUtil.getMinus());
        homePage.enterFirstNum(TestDataUtil.getFirstNumNegative());
        homePage.enterSecondNum(TestDataUtil.getSecondNumNegative());
        homePage.clickCalculate();
        assertPresentError();
    }
    @Test
    @DisplayName("Should correctly calculate division")
    void correctlyCalculatesDivision() {
        register();
        login();
        TestDataUtil.generateFirstNumber();
        TestDataUtil.generateSecondNumber();
        homePage.selectOperation(TestDataUtil.getDivide());
        homePage.enterFirstNum(TestDataUtil.getFirstNum());
        homePage.enterSecondNum(TestDataUtil.getSecondNum());
        homePage.clickCalculate();
        assertCorrectDivision(TestDataUtil.getFirstNum(), TestDataUtil.getSecondNum());
    }
    @Test
    @DisplayName("Should not division calculate with negative inputs")
    void calculateSumWithNegativeDivision() {
        register();
        login();
        homePage.selectOperation(TestDataUtil.getDivide());
        homePage.enterFirstNum(TestDataUtil.getFirstNumNegative());
        homePage.enterSecondNum(TestDataUtil.getSecondNumNegative());
        homePage.clickCalculate();
        assertPresentError();
    }
    @Test
    @DisplayName("Should correctly calculate multiplication")
    void correctlyCalculatesMultiplication() {
        register();
        login();
        TestDataUtil.generateFirstNumber();
        TestDataUtil.generateSecondNumber();
        homePage.selectOperation(TestDataUtil.getTimes());
        homePage.enterFirstNum(TestDataUtil.getFirstNum());
        homePage.enterSecondNum(TestDataUtil.getSecondNum());
        homePage.clickCalculate();
        assertCorrectMultiplication(TestDataUtil.getFirstNum(), TestDataUtil.getSecondNum());
    }
    @Test
    @DisplayName("Should not calculate multiplication with negative inputs")
    void calculateSumWithNegativeMultiplication() {
        register();
        login();
        homePage.selectOperation(TestDataUtil.getPlus());
        homePage.enterFirstNum(TestDataUtil.getFirstNumNegative());
        homePage.enterSecondNum(TestDataUtil.getSecondNumNegative());
        homePage.clickCalculate();
        assertPresentError();
    }

    //asserts
    private void assertCorrectSum(String numOne, String numTwo) {
        int firstNum = Integer.parseInt(numOne);
        int secondNum = Integer.parseInt(numTwo);
        int sum = firstNum + secondNum;
        assertThat(homePage.getAnswer())
                .isEqualTo(numOne + " + " + numTwo + " = " + sum);
    }
    private void assertCorrectSubtraction(String numOne, String numTwo) {
        int firstNum = Integer.parseInt(numOne);
        int secondNum = Integer.parseInt(numTwo);
        int subtracted = firstNum - secondNum;
        assertThat(homePage.getAnswer())
                .isEqualTo(numOne + " - " + numTwo + " = " + subtracted);
    }
    private void assertCorrectDivision(String numOne, String numTwo) {
        int firstNum = Integer.parseInt(numOne);
        int secondNum = Integer.parseInt(numTwo);
        int divided = firstNum / secondNum;
        assertThat(homePage.getAnswer())
                .isEqualTo(numOne + " / " + numTwo + " = " + divided);
    }
    private void assertCorrectMultiplication(String numOne, String numTwo) {
        int firstNum = Integer.parseInt(numOne);
        int secondNum = Integer.parseInt(numTwo);
        int multiplied = firstNum * secondNum;
        assertThat(homePage.getAnswer())
                .isEqualTo(numOne + " * " + numTwo + " = " + multiplied);
    }
    private void assertPresentError(){
       assertThat(homePage.getFirstNumErr())
               .isEqualTo(CALC_ERROR_MESSAGE);
       assertThat(homePage.getSecNumErr())
               .isEqualTo(CALC_ERROR_MESSAGE);
    }
}
