import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFaq {
   public static WebDriver driver;
   private final int itemIndex;
   private final String answerText;

    @BeforeClass
    public static void beforeClass() {
       // WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
    }

    public TestFaq(int itemIndex, String answerText) {
        this.itemIndex = itemIndex;
        this.answerText = answerText;
        driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
              /*  {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}*/
        };
    }

    @Test
    public void faqTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonAcceptCoockie();
        objMainPage.goToFaq();
        //  objMainPage.waitVisibilityQuestion(itemIndex);
        objMainPage.clickQuestion(itemIndex);
        String actualText = objMainPage.getAnswer(itemIndex);
        assertEquals(answerText, actualText);
    }
   /* @After
    public void cleanUp() {
        driver.quit();
    }*/
}