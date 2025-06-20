import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Authentication")
public class AuthTests extends BaseTest{

    //url's
    private final String HOME_URL = "http://localhost:8080/skaiciuotuvas";
    private final String HOME_URL_AFTER_LOGIN = "http://localhost:8080/";
    private final String LOGIN_URL = "http://localhost:8080/prisijungti?logout";
    private final String REGISTER_URL = "http://localhost:8080/registruoti";
    //error messages
    private final String USERNAME_ERROR = "Privaloma įvesti nuo 3 iki 32 simbolių";
    private final String PASSWORD_ERROR = "Privaloma įvesti bent 3 simbolius";
    private final String LOGIN_ERROR  = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

    @Test
    @DisplayName("Should successfully register a user with valid data")
    void validUserCredentialsRegistration() {
        loginPage.clickRegisterLink();
        TestDataUtil.generateData();
        registerPage.enterUsername(TestDataUtil.getUsername());
        registerPage.enterPassword(TestDataUtil.getPassword());
        registerPage.enterConfirmPassword(TestDataUtil.getPassword());
        registerPage.clickRegister();
        assertRegistrationSuccess();
    }

    @Test
    @DisplayName("Should not register a user with invalid data")
    void invalidUserCredentialsRegistration(){
        loginPage.clickRegisterLink();
        TestDataUtil.generateTooShortPassword();
        registerPage.enterUsername(TestDataUtil.getShortUsername());
        registerPage.enterPassword(TestDataUtil.getShortPassword());
        registerPage.enterConfirmPassword(TestDataUtil.getShortPassword());
        registerPage.clickRegister();
        assertRegistrationErrorMessages();
        assertRegistrationFail();

    }

    @Test
    @DisplayName("Should successfully login a registered user")
    void loginWithRegisteredUser(){
        register();
        homePage.clickLogout();
        loginPage.enterUsername(TestDataUtil.getUsername());
        loginPage.enterPassword(TestDataUtil.getPassword());
        loginPage.clickLoginButton();
        assertLoginSuccess();
    }

    @Test
    @DisplayName("Should not login an unregistered user")
    void loginWithUnregisteredUser(){
        TestDataUtil.generateData();
        loginPage.enterUsername(TestDataUtil.getUsername());
        loginPage.enterPassword(TestDataUtil.getPassword());
        loginPage.clickLoginButton();
        assertLoginErrorMessage();
    }

    @Test
    @DisplayName("Should successfully logout a registered user")
    void registeredUserLogout(){
        register();
        homePage.clickLogout();
        assertLogoutSuccess();
    }

    //asserts
    private void assertRegistrationSuccess(){
        homePage.waitForVisibilityOfLogoutLink();
        assertEquals(HOME_URL, driver.getCurrentUrl(), "Was redirected to this page:" + driver.getCurrentUrl());
    }
    private void assertRegistrationFail(){
        assertEquals(REGISTER_URL, driver.getCurrentUrl());
    }
    private void assertLogoutSuccess(){
        loginPage.waitForVisibilityOfRegistrationLink();
        assertEquals(LOGIN_URL, driver.getCurrentUrl(), "Was redirected to this page:" + driver.getCurrentUrl());
    }
    private void assertLoginSuccess(){
        homePage.waitForVisibilityOfLogoutLink();
        assertEquals(HOME_URL_AFTER_LOGIN, driver.getCurrentUrl(), "Was redirected to this page:" + driver.getCurrentUrl());
    }
    private void assertRegistrationErrorMessages(){
        assertEquals(USERNAME_ERROR, registerPage.getUsernameErrorMessage(), "Error message should be displayed: " + USERNAME_ERROR);
        assertEquals(PASSWORD_ERROR, registerPage.getPasswordErrorMessage(), "Error message should be displayed: " + PASSWORD_ERROR);
    }
    private void assertLoginErrorMessage(){
        assertEquals(LOGIN_ERROR, loginPage.getErrorMessage(), "Error message should be displayed: " + LOGIN_ERROR);
    }



}
