package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	 WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(id ="identifierId")
	WebElement userEmail;
	
	public void loginEmail (String email) {
		
		userEmail.sendKeys(email);
		
		
	}
	
	@FindBy(id ="Passwd")
	WebElement userPassword;
	
	public void loginPassword (String password) {
		
		userPassword.sendKeys(password);
		
	}
	
	@FindBy(css =".F9NWFb button")
	WebElement next_buttn;
	
	public void clickOnNext () {
		
		next_buttn.click();
		
		
	}
	
	@FindBy(css =".CxRgyd a")
	WebElement learnMore;
	public void clickLearnMore() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(learnMore));
		learnMore.click();
		
	}
	@FindBy(css = ".article.page")
	WebElement article;
	public String text() {
		
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		Iterator<String> it = ids.iterator();
		it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		  
		
				return article.getText();
		
		
	}
	
	
	public void goTo() {
		
		driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S1526746465%3A1674022841496087&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHeWkk6KxaZp5j2_-fgp11zzkfjaV5_Lz9aZR5P7DAvq4buW4S8lLDBPKaDIkdpnuxI6fRRBuA");
	}
	
    

}
