package org.example.test;

import org.example.manager.DriversManager;
import org.example.model.Model;
import org.example.page.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.Set;

/**
 * Unit test for simple App.
 */
public class TrendyolTest{
    @Before
    public void setUp() {
        DriversManager.getInstance().goToUrl();
    }

    @Test
    public void firstTest() throws InterruptedException {

        Model model = new Model("burakkurt72@gmail.com" , "B2");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        ProductPage productPage = new ProductPage();
        BasketPage basketPage = new BasketPage();

        homePage.popUp();
        homePage.loginButton();

        loginPage.sendValue(By.cssSelector("input[name=\"login email\"]") , model.getEmail());
        loginPage.sendValue(By.cssSelector("input[id=\"login-password-input\"]") , model.getPassword());
        DriversManager.getInstance().scrollBy();
        loginPage.logınButton();
        Thread.sleep(2000);

        searchPage.searchButton();
        searchPage.tenValueSelected();

        switchToTest();

        productPage.bodySelection();
        DriversManager.getInstance().getJs().executeScript("window.scrollBy(0 , 400)");
        productPage.addFav();
        productPage.addProduct();
        productPage.goToBasketPage();

        basketPage.favoriteDelete();

    }

    public void switchToTest() {
        String currentWindow = DriversManager.getInstance().getWebDriver().getWindowHandle();
        Set<String> windowHandles = DriversManager.getInstance().getWebDriver().getWindowHandles();
        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                DriversManager.getInstance().getWebDriver().switchTo().window(window);
            }
        }
    }

    @After
    public void tearDown(){
        DriversManager.getInstance().getWebDriver().close();
        DriversManager.getInstance().getWebDriver().quit();
    }
}
