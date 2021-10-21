package org.example.page;

import org.example.manager.DriversManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public void popUp(){
       findElements(By.cssSelector("img[alt=\"Male\"]")).click();
    }

    public void loginButton(){
        findElements(By.cssSelector("div[class=\"account-nav-item user-login-container\"]")).click();
    }

    public WebElement findElements(By by){
        WebDriverWait  webDriverWait = new WebDriverWait(DriversManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
