package eCommerceFirstProject.FrameWorkSeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class LoginPage extends AbstractClassForWait {

	@FindBy(id = "userEmail")
	WebElement enteremail;

	@FindBy(id = "userPassword")
	WebElement enterPassword;

	@FindBy(id = "login")
	WebElement loginClick;
	
	
	@FindBy(xpath="//div[text()=' Incorrect email or password. ']")
	WebElement errorMessage;
//  div[aria-label='Incorrect email or password.']
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductCatalogue loginWithCredential(String email, String password) {
		enteremail.sendKeys(email);
		enterPassword.sendKeys(password);
		loginClick.click();

		return new ProductCatalogue(driver);
	}
	
	public String getErrorMessage()
	{
		abstractClassForWait(errorMessage);
		
		return errorMessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");

	}

}
