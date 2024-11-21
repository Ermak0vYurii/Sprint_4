import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

import java.util.concurrent.TimeUnit;

import static pageobject.OrderPage.*;
import static pageobject.OrderPage.PHONE_NUMBER_ERROR;

public class ErrorMessagesTest extends BaseTest {

    @Test
    public void validateErrorMessagesTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String [] extMessagesExpectMetro = {FIRSTNAME_ERROR, LASTNAME_ERROR, ADDRESS_ERROR, PHONE_NUMBER_ERROR};
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickTopOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setFormForWhomError("fd", "gh", "fgff",  "4444");
        objOrderPage.checkErrorMessagesForOrderForm(extMessagesExpectMetro);
    }
}
