package utils.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.pages.ItemPage;
import utils.pages.LoginPage;

public class ItemTest extends DriverController {
    private ItemPage itemPage;


    @BeforeMethod
    public void setup() {
        setupDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("123", "123");
        itemPage = new ItemPage(driver);
    }


    @Test
    public void setItemTest(){
        itemPage.chooseItemBeta();
        String urlActual = driver.getCurrentUrl();
        Assert.assertEquals(urlActual, "https://www.demoblaze.com/prod.html?idp_=1", "La página no concuerda con la del artículo");

    }

    @Test
    public void setItemTestAwait(){
        itemPage.chooseitemAwait();
        String urlActual = driver.getCurrentUrl();
        Assert.assertEquals(urlActual, "https://www.demoblaze.com/prod.html?idp_=1", "La página no concuerda con la del artículo");

    }




}

