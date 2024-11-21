import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static pageobject.MainPage.URL_SCOOTER;
import static pageobject.MainPage.YANDEX_URL;

public class LogoTest extends BaseTest {


    @Test
    public void checkRedirectYandex() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLogoYandex();
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String link = driver.getCurrentUrl();
        assertEquals ("Открыта не главная страница Яндекса", link, YANDEX_URL);
    }

  /*  @Test
    public void checkRedirectScooter() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLogoScooter();
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String link = driver.getCurrentUrl();
        assertEquals ("Открыта не главная страница ЯндексСамокат", link, URL_SCOOTER);
    }  */

}
