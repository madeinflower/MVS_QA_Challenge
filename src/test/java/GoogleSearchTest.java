import base.Base;
import pageObjects.GoogleSearchPage;
import utils.GoogleConsentHandler;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoogleSearchTest extends Base {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void setUp() {
        driver = getDriver(); // Получаем WebDriver из Base
        googleSearchPage = new GoogleSearchPage(driver); // Инициализируем страницу с поисковыми функциями
    }

    @Test
    public void searchAndClickFirstResult() {
        // Открываем Google
        driver.get("https://www.google.com");

        // Обрабатываем модальное окно согласия
        GoogleConsentHandler.acceptConsent(driver);

        // Выполняем поиск по запросу "Active sync"
        googleSearchPage.enterSearchQuery("Active sync");
        googleSearchPage.submitSearch();

        // Кликаем по первому результату
        googleSearchPage.getFirstResult().click();

        // Дополнительные ассерты могут быть добавлены для проверки правильности перехода на страницу
    }

    @After
    public void tearDown() {
        quitDriver(driver); // Закрываем браузер после выполнения теста
    }
}
