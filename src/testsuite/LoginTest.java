package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(BaseUrl);
    }
    /*1.userShouldLoginSuccessfullyWithValidCredentials
			* Enter valid username
			* Enter valid password
			* Click on ‘LOGIN’ button
			* Verify the ‘Accounts Overview’ text is display*/
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.xpath("//input[@type='text']"),"Beena-Patel");//Send Valid Username to username field
        sendTextToElement(By.xpath("//input[@type='password']"),"Beena1343");// Send valid password to Password field
        clickOnElement(By.xpath("//input[@type='submit']"));//find the login and click on
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));//Find the text element for successfully login and get the text
        System.out.println(actualMessage);
        messageValidation("Accounts Overview",actualMessage );//validation message
    }
    /*2.verifyTheErrorMessage
			* Enter invalid username
			* Enter invalid password
			* Click on Login button
			* Verify the error message ‘The username and password could not be verified.’*/
    @Test
    public void verifyTheErrorMessage() {
        sendTextToElement(By.xpath("//input[@type='text']"),"Bella661");//Send Valid Username to username field
        sendTextToElement(By.xpath("//input[@type='password']"),"abcd123");// Send valid password to Password field
        clickOnElement(By.xpath("//input[@type='submit']"));//find the login and click on
        String actualMessage = getTextFromElement(By.xpath("//p[@class='error']"));//find error message and get the text
        System.out.println(actualMessage);
        messageValidation("The username and password could not be verified.",actualMessage);//validation message
    }
    /*3.userShouldLogOutSuccessfully
			* Enter valid username
			* Enter valid password
			* Click on ‘LOGIN’ button
			* Click on ‘Log Out’ link
			* Verify the text ‘Customer Login’*/
    @Test
    public void userShouldLogOutSuccessfully() {
        sendTextToElement(By.xpath("//input[@type='text']"),"Beena-Patel");//Send Valid Username to username field
        sendTextToElement(By.xpath("//input[@type='password']"),"Beena1343");// Send valid password to Password field
        clickOnElement(By.xpath("//input[@type='submit']"));//find the login and click on
        clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));//Find Logout element and click on it

        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));//Find the Customer login & verify
        System.out.println(actualMessage);
        messageValidation("Customer Login",actualMessage);//validation message
    }
    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}
