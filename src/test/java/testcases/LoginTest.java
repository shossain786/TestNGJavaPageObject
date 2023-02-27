package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    Logger logger = Logger.getLogger(LoginTest.class);
    LoginPage loginPage;

    public LoginTest() {
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void setUP() {
        logger.debug("Before Test running!");
    }

    @Test
    public void loginTestPositive(){
        loginPage.login("test_userqa", "test_userqa");
    }

    @Test
    public void loginTestNegative(){
        loginPage.login("test_userqa", "test_userqa");
    }
}
