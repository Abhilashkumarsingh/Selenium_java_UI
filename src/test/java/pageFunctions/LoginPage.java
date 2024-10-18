package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver= null;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    @FindBy(xpath="//input[contains(@id,'user-name')]")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(css="#login-button")
    WebElement loginButton;

    public LoginPage enterUsername(String username){
        this.waitUntilElementIsDisplayed(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
