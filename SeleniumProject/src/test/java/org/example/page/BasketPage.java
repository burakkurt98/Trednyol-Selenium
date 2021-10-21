package org.example.page;

import org.example.manager.DriversManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {

    public String basketPageItemName(){
        return  DriversManager.getInstance().getWebDriver().findElement(By.cssSelector(" h1  span")).getText();
    }
    public void goToFavoritePage(){
        DriversManager.getInstance().getWebDriver().findElement(By.cssSelector("i[class=\"i-heart initial-icon\"]")).click();
    }

    public void favoriteDelete(){
        String basketPageItemName = null; //basketPageItemName();
        goToFavoritePage();
        List<WebElement> favoriteItem = DriversManager.getInstance().getWebDriver().findElements(By.cssSelector("span[class=\"prdct-desc-cntnr-name no-white-space\"]"));
        for (WebElement element:favoriteItem) {
            System.out.println("aa" + element.getText());
            if (basketPageItemName==element.getText()){
                element.findElement(By.cssSelector("i[class=\"i-close\"]")).click();
            }
        }
    }
}
