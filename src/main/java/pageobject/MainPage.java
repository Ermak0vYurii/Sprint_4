package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

}