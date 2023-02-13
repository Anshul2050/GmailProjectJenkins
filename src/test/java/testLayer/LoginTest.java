package testLayer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;
import testComponents.Retry;

public class LoginTest extends BaseTest {
	String checkTxt = "controlled through softwre automation rather than a human";
	
    @Test()
	public void checkLoginTest() throws InterruptedException {
    	loginObj.loginEmail("tinkubadgaiyan@gmail.com");
    	loginObj.clickOnNext();
   }
    
    
    
    @Test(retryAnalyzer = Retry.class )
    public void checkText() throws IOException {
    	
    	
    	loginObj.loginEmail("tinkubadgaiyan@gmail.com");
    	loginObj.clickOnNext();
    	
    	loginObj.clickLearnMore();
    	String actualTxt = loginObj.text();
    	
    	if(actualTxt.contains(checkTxt)) {
    		
    		Assert.assertTrue(true);
    		System.out.println("Donee!!");
    	}
    	else Assert.assertTrue(false);
    	;
    	
    	
    }
    
//    @Test
    public void checkText2() throws IOException {
    	
    	
    	loginObj.loginEmail("tinkubadgaiyan@gmail.com");
    	loginObj.clickOnNext();
    	
    	loginObj.clickLearnMore();
    	String actualTxt = loginObj.text();
    	
    	if(actualTxt.contains(checkTxt)) {
    		
    		Assert.assertTrue(true);
    		System.out.println("Donee!!");
    	}
    	else Assert.assertTrue(false);
    	
    	
    	
    }
	
	
}
