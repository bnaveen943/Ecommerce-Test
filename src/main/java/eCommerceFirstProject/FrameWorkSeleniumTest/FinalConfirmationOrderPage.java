package eCommerceFirstProject.FrameWorkSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class FinalConfirmationOrderPage extends AbstractClassForWait {

	WebDriver driver;

	public FinalConfirmationOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// h1[text()=' Thankyou for the order. ']
	@FindBy(css = "[class='hero-primary']")
	WebElement orderTextMess;

	By waitUntilTextLoad = By.cssSelector("#toast-container");

	public String goToTextAndGrabTheText() {

		abstractClassForWait(waitUntilTextLoad);
		String text = orderTextMess.getText();
		return text;
	}

}
