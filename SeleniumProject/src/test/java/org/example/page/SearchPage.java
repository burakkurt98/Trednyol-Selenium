package org.example.page;

import org.example.manager.DriversManager;
import org.openqa.selenium.*;

import java.util.List;

public class SearchPage{

    public void searchButton(){
        DriversManager.getInstance().setKeys(By.cssSelector("input[class=\"search-box\"]"),"kazak");
        DriversManager.getInstance().scrollBy();
    }
    public void tenValueSelected(){
        List<WebElement> valueOf = DriversManager.getInstance().getWebDriver().findElements(By.cssSelector("div[class=\"p-card-wrppr\"]"));
        String overlayString = "return document.querySelector(\".overlay\").remove();";
        DriversManager.getInstance().getJs().executeScript(overlayString);
        int counter = 0;
        for (WebElement element:valueOf) {
            counter++;
            if (counter==10){
                element.click();
            }
        }
        DriversManager.getInstance().scrollBy();
    }
}
