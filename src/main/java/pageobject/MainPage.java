package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    //верхняя кнопка заказа
    private By topOrderButton = By.className("Button_Button__ra12g");
    //нижняя кнопка заказа
    private By bottonOrderButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    //логотип самоката
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    //логотип яндекса
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //блок с вопросами
    private By sectionFaq = By.className("Home_FAQ__3uVm4");
    //вопросы
    private By question1 = By.id("accordion__heading-8");
    private By question2 = By.id("accordion__heading-9");
    private By question3 = By.id("accordion__heading-10");
    private By question4 = By.id("accordion__heading-11");
    private By question5 = By.id("accordion__heading-12");
    private By question6 = By.id("accordion__heading-13");
    private By question7 = By.id("accordion__heading-14");
    private By question8 = By.id("accordion__heading-15");
    // ответы
    private By answer1 = By.xpath(".//div[@id='accordion__panel-8']/p");
    private By answer2 = By.xpath(".//div[@id='accordion__panel-9']/p");
    private By answer3 = By.xpath(".//div[@id='accordion__panel-10']/p");
    private By answer4 = By.xpath(".//div[@id='accordion__panel-11']/p");
    private By answer5 = By.xpath(".//div[@id='accordion__panel-12']/p");
    private By answer6 = By.xpath(".//div[@id='accordion__panel-13']/p");
    private By answer7 = By.xpath(".//div[@id='accordion__panel-14']/p");
    private By answer8 = By.xpath(".//div[@id='accordion__panel-15']/p");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //нажать верхнюю кнопку Заказать
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    //нажать нижнюю кнопку Заказать
    public void clickBottonOrderButton() {
        driver.findElement(bottonOrderButton).click();
    }
    //нажать на логотип самоката
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
    //нажать на логотип яндекса
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    //ожидание загрузки блока с вопросами
    public void waitForLoadSectionFaq() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(sectionFaq));
    }

}