package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleConsentHandler {

    public static void acceptConsent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Ожидаем загрузки iframe с модальным окном
            WebElement consentFrame = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("iframe[src*='consent.google.com']")));
            driver.switchTo().frame(consentFrame);

            // Ожидаем появления кнопки "Alle akzeptieren" и нажимаем её
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Alle akzeptieren')]")));
            acceptButton.click();

            // Возвращаемся к основному содержимому страницы
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Модальное окно согласия не найдено или уже принято.");
        }
    }
}

