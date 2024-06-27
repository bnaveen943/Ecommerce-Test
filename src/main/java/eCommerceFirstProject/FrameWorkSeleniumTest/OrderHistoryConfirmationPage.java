package eCommerceFirstProject.FrameWorkSeleniumTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class OrderHistoryConfirmationPage extends AbstractClassForWait {

	WebDriver driver;

	public OrderHistoryConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody /tr /td[2]")
	List<WebElement> OrderHistoryProd;

	public List<WebElement> goToCartedProductsCheck() {

		return OrderHistoryProd;
	}

	public Boolean checkTheSelectedProduct(String productName) {
		Boolean prodName = OrderHistoryProd.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));

		return prodName;
	}

}
