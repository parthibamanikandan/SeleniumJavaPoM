package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ResultsPage {

    WebDriver driver = null;

    By search_results_videoTab = By.partialLinkText("Videos");
    By search_results_result=By.xpath("//div[@class='tF2Cxc']//div[@class='yuRUbf']");

    public ResultsPage (WebDriver driver){

        this.driver=driver;
    }

    public void isSearchResultPageIsVisible(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(search_results_videoTab).isDisplayed();
    }

    public boolean validateSearchResult(){
        return driver.findElement(search_results_result).isDisplayed();
    }
}
