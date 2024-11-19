
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import static pageobject.MainPage.URL_SCOOTER;

public class BaseTest {

    protected WebDriver driver;
    String browser = "firefox";

    @Before
    public void prepare() {
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }


        driver.get(URL_SCOOTER);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonAcceptCoockie();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }



}
