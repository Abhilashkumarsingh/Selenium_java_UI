package pageFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver=null;
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public WebElement waitUntilElementIsDisplayed(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void click(WebElement ele){
        this.waitUntilElementIsDisplayed(ele).click();
    }
    public void getText(WebElement ele){
        this.waitUntilElementIsDisplayed(ele).getText();
    }
}
