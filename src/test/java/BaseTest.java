
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import static pageobject.MainPage.URL_SCOOTER;

public class BaseTest {

    public static WebDriver driver;
    @Before
    public void prepare() {

         driver = new ChromeDriver();
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
