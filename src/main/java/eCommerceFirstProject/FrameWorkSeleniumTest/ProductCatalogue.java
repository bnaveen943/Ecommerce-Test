package eCommerceFirstProject.FrameWorkSeleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceFirstProject.AbstractMenthodsForWait.AbstractClassForWait;

public class ProductCatalogue extends AbstractClassForWait {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css = ".ng-animating")
	WebElement animateWait;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement addToCartClcik;
	By productsList = By.cssSelector(".mb-3");
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By message = By.cssSelector("#toast-container");

	public List<WebElement> getListOfProducts() {
		abstractClassForWait(message);
		return products;
	}

	public WebElement goToCartProduct(String productName) {

		WebElement Selectedproduct = products.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return Selectedproduct;
	}

	public GoToCartAndCheck addToCart(String productName) {
		WebElement clickCart = goToCartProduct(productName);
		clickCart.findElement(addCart).click();
		abstractClassForWait(message);
		abstractClassForWaitInVisible(animateWait);

		addToCartClcik.click();
		
		return new GoToCartAndCheck(driver);

	}

}
