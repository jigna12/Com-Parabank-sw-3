package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void Setup(){
        openBrowser(BaseUrl);
    }
   /* 1.verifyThatSigningUpPageDisplay
			* click on the ‘Register’ link
			* Verify the text ‘Signing up is easy!’*/
    @Test
    public void verifyThatSigningUpPageDisplay()
    {
        clickOnElement(By.linkText("Register"));//Find Register Link and Click on Register link
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        System.out.println("Actual Message :" + actualMessage); //Find the Signing up is easy! element and get the text
        messageValidation( "Signing up is easy!",actualMessage);//validation message
    }
    /* 2.userSholdRegisterAccountSuccessfully
			* click on the ‘Register’ link
			* Enter First name
			* Enter Last name
			* Enter Address
			* Enter City
			* Enter State
			* Enter Zip Code
			* Enter Phone
			* Enter SSN
			* Enter Username
			* Enter Password
			* Enter Confirm
			* Click on REGISTER button
			* Verify the text 'Your account was created successfully. You are now logged in.’*/
    @Test
    public void userSholdRegisterAccountSuccessfully()
    {
        clickOnElement(By.linkText("Register"));//Find Register Link field  and Click on Register link
        sendTextToElement(By.id("customer.firstName"),"Beena");//Find the first name field and enter first name
        sendTextToElement(By.id("customer.lastName"),"patel");//Find the Last name field  and enter Last name
        sendTextToElement(By.id("customer.address.street"),"Harrow Close"); //Find the Address field  and enter Address
        sendTextToElement(By.id("customer.address.city"),"Watford");//Find the City field and enter City
        sendTextToElement((By.id("customer.address.state")),"Hertfordshire");//Find the State field and enter State
        sendTextToElement(By.id("customer.address.zipCode"),"WD20 6TZ");//Find the Zip Code field and enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"0790797896");//Find the Phone field and enter Phone
        sendTextToElement(By.id("customer.ssn"),"AA-12-34-56-B");//Find the SSN field and enter  SSN
        sendTextToElement(By.id("customer.username"),"Beena-Patel");//Find the Username field and enter Username
        sendTextToElement(By.id("customer.password"),"Beena1343");  //Find the Password field and enter Password
        sendTextToElement(By.id("repeatedPassword"),"Beena1343");//Find the Confirm field and enter ConfirmPassword
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));//Find Register field  and Click on Register Field

        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        System.out.println("Actual Message :" + actualMessage);//Find the Signing up is easy! element and get the text
        messageValidation("Your account was created successfully. You are now logged in.",actualMessage);
    }
    @After
    //closing the driver
    public void closedown(){
        closeBrowser();
    }
}


