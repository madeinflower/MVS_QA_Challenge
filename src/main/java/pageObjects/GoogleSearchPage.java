package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Alle akzeptieren')]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement searchBox;

    @FindBy(css = "h3")
    private WebElement firstResult;

    public void acceptCookiesAfterScroll() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", acceptCookiesButton);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        } catch (TimeoutException | InterruptedException e) {
        }
    }

    public void enterSearchQuery(String query) {
        waitForVisibility(searchBox);
        searchBox.sendKeys(query);
    }

    public void submitSearch() {
        waitForVisibility(searchBox);
        searchBox.submit();
    }

    public WebElement getFirstResult() {
        waitForVisibility(firstResult);
        return firstResult;
    }
}
