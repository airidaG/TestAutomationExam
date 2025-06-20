import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testPages.HomePage;
import testPages.LoginPage;
import testPages.RegisterPage;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    RegisterPage registerPage;
    HomePage homePage;
    static final String BASE_URL = "http://localhost:8080/prisijungti";

    @BeforeEach
    void setup() {

        ChromeOptions options = getHeadlessOptions();
        driver = new ChromeDriver(options);

//        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    //helper methods
    void register(){
        loginPage.clickRegisterLink();
        TestDataUtil.generateData();
        registerPage.enterUsername(TestDataUtil.getUsername());
        registerPage.enterPassword(TestDataUtil.getPassword());
        registerPage.enterConfirmPassword(TestDataUtil.getPassword());
        registerPage.clickRegister();
    }
    void login(){
        homePage.clickLogout();
        loginPage.enterUsername(TestDataUtil.getUsername());
        loginPage.enterPassword(TestDataUtil.getPassword());
        loginPage.clickLoginButton();
    }
    private ChromeOptions getHeadlessOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // Disable GPU (for compatibility)
        options.addArguments("--window-size=1920x1080"); // Set window size
        return options;
    }

}
