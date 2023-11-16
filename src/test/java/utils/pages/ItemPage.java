package utils.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver){
        super(driver);
    }

    public void chooseItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a")));
        System.out.println("Texto del elemento: " + item.getText());
        item.click();

    }

    public void chooseItemBeta() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a")));
            System.out.println("Texto del elemento: " + item.getText());
            item.click();
        } catch (StaleElementReferenceException e) {
            // Manejo de la excepción, por ejemplo, volviendo a intentar la operación
            System.out.println("Elemento no está presente en el DOM. Volviendo a intentar...");
            chooseItemBeta(); // Llamada recursiva para volver a intentar
        } catch (TimeoutException e) {
            // Manejar la excepción de tiempo de espera aquí
            System.out.println("Tiempo de espera excedido al esperar que el elemento sea clickeable.");
            e.printStackTrace();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public void chooseitemAwait(){
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a")));
        item.click();

    }

}
