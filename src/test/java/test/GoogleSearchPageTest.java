package test.java.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.config.PropertiesFile;
import test.java.pages.HomePage;
import test.java.pages.ResultsPage;

public class GoogleSearchPageTest {

     WebDriver driver =null;
     Logger logger = LogManager.getLogger(GoogleSearchPageTest.class);

   public static String browserName =null;
    public static String url =null;


    @BeforeTest
    public void setUpTest(){
         PropertiesFile.getProperties();

         if(browserName.equalsIgnoreCase("chrome")){
             WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
             logger.info("Before Test ChromeDriver setup completed");
        }
         else if(browserName.equalsIgnoreCase("firefox")){
             WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
             logger.info("Before Test FirefoxDriver setup completed");
         }
         else if(browserName.equalsIgnoreCase("edge")){
             WebDriverManager.edgedriver().setup();
             driver = new EdgeDriver();
             logger.info("Before Test EdgeDriver setup completed");
         }

    }

    @Test
    public  void googleSearchTest(){
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        driver.get(url);
        logger.info("Test Method url launch completed");
        homePage.setTextInSearchBox("google");
        homePage.clickSearchButton();
        resultsPage.isSearchResultPageIsVisible();
        Assert.assertTrue(resultsPage.validateSearchResult(),"true");
    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        logger.info("After Test Method completed");
        System.out.println("Test Completed successfully");
    }
}
