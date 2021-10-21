package org.example.page;

import org.example.manager.DriversManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {

    public void bodySelection(){
        List<WebElement> bodySelection = DriversManager.getInstance().getWebDriver().findElements(By.cssSelector("div[title=\"Beden seçmek için tıklayınız\"]"));
        int counter = 0;
        for (WebElement element:bodySelection) {
            counter++;
            if (counter==0){
                element.click();
            }
        }
    }
    public void addFav(){
        DriversManager.getInstance().getWebDriver().findElement(By.className("fv")).click();
    }
    public void addProduct(){
        DriversManager.getInstance().getWebDriver().findElement(By.cssSelector("div.product-button-container  button")).click();
    }
    public void goToBasketPage(){
        DriversManager.getInstance().getWebDriver().findElement(By.cssSelector("a[class=\"link account-basket\"]")).click();
    }
}
