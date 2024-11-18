package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private  WebDriver driver;

    public static final String URL_SCOOTER = "https://qa-scooter.praktikum-services.ru/";

        //верхняя кнопка заказа
    private final By topOrderButton = By.className("Button_Button__ra12g");
        //нижняя кнопка заказа
    private final By bottonOrderButton = By.xpath(".//div[contains(@class,'FinishButton')]//button[text()='Заказать']");
        //логотип самоката
    private final By logoScooter = By.className("Header_LogoScooter__3lsAR");
        //логотип яндекса
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");
        //блок с вопросами
    private final By sectionFaq = By.xpath(".//div[@data-accordion-component='Accordion']");
        //вопросы
    private String question = ".//div[@id='accordion__heading-%d']";     //accordion__heading-0
        //ответы
    private String answer = ".//div[@id='accordion__panel-%d']";
        //кнопка согласия использования куки
    private final By buttonAcceptCoockie = By.id("rcc-confirm-button");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }
        //ожидание загрузки блока с вопросами
    public void waitLoadSectionFaq() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(sectionFaq));
    }

        //соглашаемся с использованием кук
    public void clickButtonAcceptCoockie() {
        driver.findElement(buttonAcceptCoockie).click();
    }
        //скролл до блока с вопросами
    public void goToFaq () {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(sectionFaq));
    }
        //клик по стрелочке
    public void clickQuestion(int itemIndex) {
        driver.findElement(By.xpath(String.format(question, itemIndex))).click();
    }
        //получение текста ответа
    public String getAnswer(int itemIndex) {
        return driver.findElement(By.xpath(String.format(answer, itemIndex))).getText();
    }
        //получение текста вопроса
    public String getQuestion(int itemIndex) {
        return driver.findElement(By.xpath(String.format(question, itemIndex))).getText();
    }

       //нажать верхнюю или нижнюю кнопку Заказать
    public void clickOrderButton(int indexButton) {
        switch (indexButton) {
            case 0:
                driver.findElement(topOrderButton).click();
                break;
            case 1:
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottonOrderButton));
                driver.findElement(bottonOrderButton).click();
                break;
        }
    }

       //клик по логотипу самоката
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
       //клик по логотипу яндекса
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }



}