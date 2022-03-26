package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver = null;

    By textbox_search = By.name("q");
    By button_search = By.name("btnK");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

public void setTextInSearchBox(String text){
    driver.findElement(textbox_search).sendKeys(text);
}

public void clickSearchButton(){
    driver.findElement(button_search).sendKeys(Keys.RETURN);
    //driver.findElement(button_search).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

}
}
