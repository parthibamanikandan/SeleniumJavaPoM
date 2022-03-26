package test.java.config;

import test.java.test.GoogleSearchPageTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static void getProperties() {

        try {
            Properties prop = new Properties();
            String projectPath = System.getProperty("user.dir");
            InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");

            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            GoogleSearchPageTest.browserName = browser;

            String url = prop.getProperty("url");
            GoogleSearchPageTest.url = url;
            System.out.println("url used:"+url);


        } catch (Exception exp){
            System.out.println( exp.getMessage());
            System.out.println( exp.getCause());
            exp.printStackTrace();
        }


    }
}
