package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginButton.click();

    }

    public void login(String userName, String passWord){
        this.getUserNameField().sendKeys(userName);
        this.getPassWordField().sendKeys(passWord);
        this.getLoginButton().click();

    }

    public WebElement getUserNameField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    public WebElement getPassWordField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
    }

    public WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Log in')]")));
    }


}
