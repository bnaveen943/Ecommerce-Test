package eCommerceFirstProject.FrameWorkSeleniumTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class GoToCartAndCheck extends AbstractClassForWait {

	WebDriver driver;

	public GoToCartAndCheck(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> checkTheProducts;

	@FindBy(xpath = "//button[text()=\"Checkout\"]")
	WebElement checkOut;

	public List<WebElement> goToCartedProductsCheck() {
		return checkTheProducts;
	}

	public Boolean checkTheSelectedProduct(String productName) {
		Boolean prodName = checkTheProducts.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));

		return prodName;
	}

	public AddressPageToEnterDetails goToCheckAndClick() {
		checkOut.click();
		
		return new AddressPageToEnterDetails(driver);
	}

}
