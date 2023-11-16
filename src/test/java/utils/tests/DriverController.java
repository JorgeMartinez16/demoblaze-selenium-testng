package utils.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverController {

    protected WebDriver driver;

    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void tearDownDriver() {

        if (driver != null) {
            driver.quit();
        }


    }
}
