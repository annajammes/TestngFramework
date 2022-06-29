package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    public static void open ( String url){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    public static void close (){
        if(driver!=null){
            driver.quit();
        }
    }}

