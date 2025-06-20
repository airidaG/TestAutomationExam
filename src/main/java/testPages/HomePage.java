package testPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //links
    @FindBy(xpath = "//a[contains(text(), 'Logout,')]")
    private WebElement linkLogout;
    //buttons
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonCalculate;
    //inputs
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement inputFirstNumber;
    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement inputSecondNumber;
    //dropdowns
    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement dropdownOfOperations;
    //text
    @FindBy(xpath = "//h4")
    private WebElement answerLine;
    @FindBy(xpath = "//span[@id='sk1.errors']")
    private WebElement textFirstNumErr;
    @FindBy(xpath = "//span[@id='sk2.errors']")
    private WebElement textSecNumErr;

    //click
    public void clickLogout(){
        linkLogout.click();
    }
    public void clickCalculate(){
        buttonCalculate.click();
    }
    //select
    public void selectOperation(String operation) {
        Select pageSizeSelector = new Select(dropdownOfOperations);
        pageSizeSelector.selectByValue(operation);
    }
    //send keys
    public void enterFirstNum(String num) {
        inputFirstNumber.clear();
        inputFirstNumber.sendKeys(num);
    }

    public void enterSecondNum(String num) {
        inputSecondNumber.clear();
        inputSecondNumber.sendKeys(num);
    }
    //get
    public String getAnswer(){
        return answerLine.getText();
    }
    public String getFirstNumErr(){
        return textFirstNumErr.getText();
    }
    public String getSecNumErr(){
        return textSecNumErr.getText();
    }

    //waits
    public void waitForVisibilityOfLogoutLink(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(linkLogout));
    }
}
