package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFunctions.LoginPage;

public class DemoTest extends BaseTest {
    @DataProvider(name="loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user","secret_sauce",true}
        };
    }

    @Test(testName = "Validate login via correct username and password",dataProvider = "loginData")
    public void sampleTest(String username, String password, boolean expectedResult){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
        Assert.assertEquals(this.driver.getCurrentUrl().contains("inventory.html"),expectedResult);
    }

//    @Test(testName = "Validate login via incorrect username and password")
//    public void incorrectCredentialLogin(){
//        LoginPage loginPage= new LoginPage(driver);
//        loginPage.enterUsername("apple")
//                .enterPassword("password")
//                .clickLoginButton();
//
//        Assert.assertTrue(!this.driver.getCurrentUrl().contains("inventory.html"));
//    }
}