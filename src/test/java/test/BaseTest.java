package test;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver=null;
    private String browser;
    @BeforeClass
    @Parameters("browser")
    public void startBrowser(String browser){
        this.browser= browser;
        this.driver= new BrowserFactory().startBrowser(browser,"https://www.saucedemo.com/");
        this.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
}
