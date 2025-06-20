package testPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //input fields
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    //buttons
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    //links
    @FindBy(xpath = "//a[text()='Sukurti naują paskyrą']")
    private WebElement linkRegister;

    //text elements
    @FindBy(xpath = "//span[contains(text(), 'neteisingi')]")
    private WebElement textErrorMessage;

    //click
    public void clickRegisterLink(){
        linkRegister.click();
    }
    public void clickLoginButton(){
        buttonLogin.click();
    }

    //send keys
    public void enterUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    //get text
    public String getErrorMessage(){
       return textErrorMessage.getText();
    }


    //waits
    public void waitForVisibilityOfRegistrationLink(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(linkRegister));
    }

}
