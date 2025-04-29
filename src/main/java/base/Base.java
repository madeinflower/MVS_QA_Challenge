package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    // Метод для получения WebDriver
    protected WebDriver getDriver() {
        WebDriver driver = new ChromeDriver(); // Инициализация ChromeDriver
        driver.manage().window().maximize(); // Открытие браузера в максимальном режиме
        return driver;
    }

    // Метод для закрытия WebDriver
    protected void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }
}
