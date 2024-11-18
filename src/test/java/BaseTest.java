
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import static pageobject.MainPage.URL_SCOOTER;

public class BaseTest {




    public static WebDriver browserSelection(String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else {
            System.getProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver");
            return new ChromeDriver();
        }
    }
    public static WebDriver driver;
    @Before
    public void prepare() {

        driver = browserSelection("chrome");
       // WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.get(URL_SCOOTER);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonAcceptCoockie();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }



}
