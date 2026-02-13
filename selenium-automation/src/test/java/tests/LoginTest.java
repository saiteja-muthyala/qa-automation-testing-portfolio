package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

