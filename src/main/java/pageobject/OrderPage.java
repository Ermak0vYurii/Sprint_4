package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderPage {
    private final WebDriver driver;
    //константы
    public static final String FIRSTNAME_ERROR = "Введите корректное имя";
    public static final String LASTNAME_ERROR = "Введите корректную фамилию";
    public static final String ADDRESS_ERROR = "Введите корректный адрес";
    private static final String METRO_STATION_ERROR = "Выберете станцию";
    public static final String PHONE_NUMBER_ERROR = "Введите корректный номер";
    //локаторы
    private final By fieldFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[text()='Далее']");  //проверить локатор
    private final By fieldDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-control']");
   // private final By fieldComment = By.xpath(".//");
   // private final By fieldColor = By.xpath(".//");
    private final By buttonOrder = By.xpath(".//div[starts-with(@class,'Order_Buttons')]//button[contains(text(), 'Заказать')]");  //проверить локатор
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    private final By headerModalOrderOk = By.xpath(".//div[text()='Заказ оформлен']");
    private final By infoMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final By errorMessages = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    private final By errorMessagesForMetro = By.xpath(".//div[text()='Выберите станцию']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //заполнение формы "для кого"
    public void setFormForWhom(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }
    //заполнение формы "для кого"
    public void setFormForWhomError(String firstName, String lastName, String address, String phoneNumber) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        clickNextButton();
        clickNextButton();
    }
    //заполнение формы "про аренду"
    public void setFormAboutRent(String deliveryDate, String rentalPeriod) {
        setDeliveryDate(deliveryDate);
        setRentalPeriod(rentalPeriod);
        clickOrderButton();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        clickButtonYes();
    }
    //получение сообщений об ошибке
    public void checkErrorMessagesForOrderForm(String[] expectedMessages) {
        for (int i = 0; i < expectedMessages.length; i++) {
            assertEquals("Неверное сообщение об ошибке", expectedMessages[i], getErrorMessage(i));
        }
        assertEquals("Неверное сообщение об ошибке", METRO_STATION_ERROR, getErrorMessageForMetro());
    }

    private void assertEquals(String неверноеСообщениеОбОшибке, String expectedMessage, String errorMessage) {
    }


    //ввод данных в поле имя
    public void setFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

        //ввод данных в поле фамилия
    public void setLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

        //ввод данных в поле адрес
    public void setAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

        //выбор станции метро
    public void setMetroStation(String metroStation) {
        driver.findElement(fieldMetroStation).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }

        //ввод номера телефона
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

        //нажатие на кнопку "далее"
    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }

        //ввод даты доставки
    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(fieldDeliveryDate).sendKeys(deliveryDate, Keys.ARROW_DOWN, Keys.ENTER);
    }

        //ввод срока аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='"+rentalPeriod+"']")).click();
    }

        //нажатие кнопки "заказать" в форме "про аренду"
    public void clickOrderButton() {
        driver.findElement(buttonOrder).click();
    }

        //нажатие на кнопку "да" в окне "хотите оформить заказ"
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

        //ожидание окна "заказ оформлен"
    public void waitLoadModalOrderOk() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(headerModalOrderOk));
    }

    public String getInfoMessage() {
        return driver.findElement(infoMessage).getText();
    }

    public String getErrorMessage(int i) {
        return driver.findElements(errorMessages).get(i).getText();
    }

    public String getErrorMessageForMetro() {
        return driver.findElement(errorMessagesForMetro).getText();
    }
}
