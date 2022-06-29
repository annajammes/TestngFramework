package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    public static void open ( String url){
        FileReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (FileReader.getPropertyValue("browser")){
            case "chrome":
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:throw new RuntimeException("invalid browser name");
        }

        driver.get(FileReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    public static void close (){
        if(driver!=null){
            driver.quit();
        }
    }
}

