package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //input fields
    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement inputConfirmPassword;

    //buttons
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonRegister;

    //text elements
    @FindBy(xpath = "//span[@id='username.errors']")
    private WebElement textUsernameErrorMessage;
    @FindBy(xpath = "//span[@id='password.errors']")
    private WebElement textPasswordErrorMessage;

    //send keys
    public void enterUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword){
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    //click
    public void clickRegister(){
        buttonRegister.click();
    }

    //get text
    public String getUsernameErrorMessage(){
        return textUsernameErrorMessage.getText();
    }
    public  String getPasswordErrorMessage(){
        return textPasswordErrorMessage.getText();
    }
}
