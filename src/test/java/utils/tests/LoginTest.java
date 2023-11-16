package utils.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.pages.LoginPage;

import java.time.Duration;

public class LoginTest extends DriverController {

    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        setupDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }


    @Test
    public void LoginTest(){
        loginPage.getUserNameField().sendKeys("123");
        loginPage.getPassWordField().sendKeys("123");
        loginPage.getLoginButton().click();

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"username", "password", "https://www.demoblaze.com/"},
                {"123", "123", "https://www.demoblaze.com/"},
                {"problem_user", "secret_sauce", "user invalid"},
                {"563784940303", " ", "Wrong password"},
                {"(/&#%","84940", "User does not exist." },
                {"", "", "Please fill out Username and Password."}
        };
    }

    @Test(dataProvider = "loginData")
    public void testForManyOptionsLogin(String username, String password, String expectedUrl) {
        loginPage.getUserNameField().sendKeys(username);
        loginPage.getPassWordField().sendKeys(password);
        loginPage.getLoginButton().click();

        try {
            // Esperar a que aparezca la alerta
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());

            // Cambiar al cuadro de diálogo de alerta
            Alert alert = driver.switchTo().alert();

            // Aceptar la alerta (cerrarla)
            alert.accept();

        } catch (TimeoutException e) {
            System.out.println("No hay ventana de alerta.");

        }

        waitSeconds();
        tearDown();
    }

    @AfterSuite
    public void tearDown() {
        tearDownDriver();
    }

    public void waitSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





