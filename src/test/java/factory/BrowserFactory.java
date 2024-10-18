package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    WebDriver driver=null;
    public WebDriver startBrowser(String browserName, String url){
        if(browserName.startsWith("chrome")){
            WebDriverManager.chromedriver().setup();
            this.driver= new ChromeDriver();
        }else if(browserName.startsWith("firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver= new FirefoxDriver();
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
        return this.driver;
    }
}
