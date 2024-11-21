package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStatusPage {

    private final WebDriver driver;
        //изображение заказ не найден
    private final By notFoundImg = By.xpath(".//div[@class='Track_NotFound__6oaoY']/img");
        //кнопка посмотреть
    private final By seeButton = By.xpath(".//button[text()='Посмотреть']");
        //конструктор
    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

      //методы
    public void waitUntilUploadStatusForm() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(seeButton));
    }

    public boolean isOrderStatusDisplay() {
        return !(driver.findElement(notFoundImg).isDisplayed());
    }
}
