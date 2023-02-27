package libs;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserActions {
    WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public boolean sendKeys(By locator, String data) {
        waitForElementToAppear(locator).sendKeys(data);
        return true;
    }

    public boolean clickElement(By locator) {
        waitForElementToBeClickable(locator).click();
        return true;
    }

    private WebElement waitForElementToAppear(By locator) {
         return TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return TestBase.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }
}
