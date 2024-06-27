package eCommerceFirstProject.FrameWorkSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class AddressPageToEnterDetails extends AbstractClassForWait {

	WebDriver driver;

	public AddressPageToEnterDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement enterContryAlpa;

	// .ta-item.list-group-item.ng-star-inserted

	// button[@class='ta-item list-group-item ng-star-inserted'][2]

	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement country;

	By waitCountriesToLoad = By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]");

	// [class='btnn action__submit ng-star-inserted']

	@FindBy(css = "[class='btnn action__submit ng-star-inserted']")
	WebElement placeOrder;

	public FinalConfirmationOrderPage goToBoxAndSendDetailsOfCountry(String CountryName) {
		Actions action = new Actions(driver);
		action.sendKeys(enterContryAlpa, CountryName).build().perform();
		abstractClassForWait(waitCountriesToLoad);
		country.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		placeOrder.click();
		
		return new FinalConfirmationOrderPage(driver);

	}

}
