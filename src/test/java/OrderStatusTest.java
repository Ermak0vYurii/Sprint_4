import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderStatusPage;

import static org.junit.Assert.assertFalse;

public class OrderStatusTest extends BaseTest {


    @Test
    public void orderStatusForInvalidNumber() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderStatusButton();
        objMainPage.setOrderStatus(MainPage.INVALID_ORDER_NUMBER);
        objMainPage.checkOrderStatus();
        OrderStatusPage objOrderStatusPage = new OrderStatusPage(driver);
        objOrderStatusPage.waitUntilUploadStatusForm();
        assertFalse ("Заказ найден", objOrderStatusPage.isOrderStatusDisplay());
    }
}
