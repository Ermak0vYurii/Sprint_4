
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;



@RunWith(Parameterized.class)

public class OrderTest extends BaseTest {

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
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                // заказ через верхнюю кнопку(первый параметр в массиве)
                {0, "Иван", "Зябликов", "Победы, 5", "ЗИЛ", "+79127458056", "21.11.2024", "трое суток"},
                {0,"Семён", "Иванов", "Озерная, 46", "Павелецкая", "89229985147", "22.11.2024", "двое суток"},
                // заказ через нижнюю кнопку(первый параметр в массиве)
                {1, "Петр", "Мошкин", "Ленина, 10", "Котельники", "89194814736", "20.11.2024", "сутки"},
                {1, "Александ", "Трусов", "Первомайская, 78", "Дмитровская", "+79634411144", "23.11.2024", "четверо суток"}
        };
    }

    @Test
    public void orderTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderButton(indexButton);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setFormForWhom(firstName, lastName, address, metroStation, phoneNumber);
        objOrderPage.setFormAboutRent(deliveryDate, rentalPeriod);
        objOrderPage.waitLoadModalOrderOk();
    }
}
