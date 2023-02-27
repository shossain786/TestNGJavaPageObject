package base;
//name can be given CoreBase
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {
    Logger logger = Logger.getLogger(TestBase.class);
    public Properties configProperties;
    public String browser;
    String url;
    WebDriver driver;
    public static WebDriverWait wait;
    static{
        System.out.println("Inside static");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    public WebDriver initProject() {
        logger.debug("Inside init project!");
        loadConfig();
        initProjectParams();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(2));
        driver.get(url);
        return driver;
    }

    public void loadConfig() {
        try {
            configProperties = new Properties();
            configProperties.load(new FileInputStream(System.getProperty("user.dir") + "/config/config.properties"));
        } catch (IOException ignored) {

        }
    }

    public void initProjectParams() {
        url = configProperties.getProperty("url");
        browser = configProperties.getProperty("browser");
    }
}
