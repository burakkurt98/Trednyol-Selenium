package org.example.page;

import org.example.manager.DriversManager;
import org.openqa.selenium.By;

public class LoginPage {
    public void logınButton(){
        DriversManager.getInstance().findElements(By.cssSelector("button[class=\"q-primary q-fluid q-button-medium q-button submit\"]")).click();
    }

    public void sendValue(By by , String text){
        DriversManager.getInstance().setKeys(by,text);
    }
}
