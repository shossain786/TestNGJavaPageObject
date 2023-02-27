package pages;

import libs.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    BrowserActions browserActions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        browserActions = new BrowserActions(driver);
        PageFactory.initElements(driver, this);
    }

    By loginId = By.name("username");
    By password = By.name("password");
    By login = By.xpath("//input[@value='Log In']");

    public void login(String userid, String password) {
        browserActions.sendKeys(loginId, userid);
        browserActions.sendKeys(this.password, password);
        browserActions.clickElement(login);
    }
}
