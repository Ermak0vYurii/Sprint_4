import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;
import pageobject.OrderPage;


@RunWith(Parameterized.class)

public class OrderTest {

    public static WebDriver driver;

    private final int indexButton;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;


    public OrderTest(int indexButton, String firstName, String lastName, String address,
                     String metroStation, String phoneNumber, String deliveryDate, String rentalPeriod) {
        this.indexButton = indexButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        driver = new FirefoxDriver();
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {0, "Иван", "Зябликов", "Победы, 5", "ЗИЛ", "+79127458056", "21.11.2024", "трое суток"},
                {1, "Петр", "Мошкин", "Ленина, 10", "Котельники", "89194814736", "20.11.2024", "сутки"}
        };
    }

    @Test
    public void orderTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonAcceptCoockie();
        objMainPage.clickOrderButton(indexButton);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setFormForWhom(firstName, lastName, address, metroStation, phoneNumber);
        objOrderPage.setFormAboutRent(deliveryDate, rentalPeriod);
        objOrderPage.waitLoadModalOrderOk();


    }
    @After
    public void cleanUp() {
        driver.quit();
    }


}
