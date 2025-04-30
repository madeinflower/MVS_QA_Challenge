import base.Base;
import pageObjects.GoogleSearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class GoogleSearchTest extends Base {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void setUp() {
        driver = getDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void searchAndClickFirstResult() {
        driver.get("https://www.google.com");

        googleSearchPage.acceptCookiesAfterScroll();
        googleSearchPage.enterSearchQuery("Active sync");
        googleSearchPage.submitSearch();
        googleSearchPage.getFirstResult().click();
    }

    @After
    public void tearDown() {
        quitDriver(driver);
    }
}
