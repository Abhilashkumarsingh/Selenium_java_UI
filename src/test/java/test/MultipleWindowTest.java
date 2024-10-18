package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowTest extends BaseTest{
    @Test
    public void createANewWindow() throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor)driver).executeScript("window.open();");
        String parentWindow= this.driver.getWindowHandle();
        Set<String> allWindow = this.driver.getWindowHandles();
        Assert.assertEquals(allWindow.size(),2);
        System.out.println(allWindow.size());
        //this.driver.switchTo().window(this.driver.getWindowHandles().stream().skip(1).findFirst().orElse(null));
        for(String tab: allWindow){
            if(tab!=parentWindow){
                this.driver.switchTo().window(tab);
                break;
            }
        }
        //this.driver.navigate().to("");
        String titleOfNewWindow= driver.getTitle();
        System.out.println(titleOfNewWindow);
        Thread.sleep(5000);
    }
}
