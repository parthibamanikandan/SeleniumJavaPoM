package test.java.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.config.PropertiesFile;
import test.java.pages.HomePage;

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

        driver.get(url);
        logger.info("Test Method url launch completed");
        homePage.setTextInSearchBox("tester");
        homePage.clickSearchButton();
    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        logger.info("After Test Method completed");
        System.out.println("Test Completed successfully");
    }
}
