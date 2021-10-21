package org.example.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriversManager {
    private static DriversManager instance;
    private static WebDriver webDriver = null;
    private JavascriptExecutor js = null;

    private DriversManager() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        webDriver = new ChromeDriver(options);
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
    }

    public static DriversManager getInstance(){
        if (instance == null) {
            instance = new DriversManager();
        }
        return  instance;
    }

    public void goToUrl() {
        webDriver.navigate().to("https://www.trendyol.com/");
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public WebElement findElements(By by){
        WebDriverWait webDriverWait = new WebDriverWait(DriversManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        return  webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void setKeys(By byElement,String text) {
        WebDriverWait  webDriverWait = new WebDriverWait(DriversManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text , Keys.ENTER);
    }
    public void scrollBy() {
        js.executeScript("window.scrollBy(0 , 400)");
    }
}
