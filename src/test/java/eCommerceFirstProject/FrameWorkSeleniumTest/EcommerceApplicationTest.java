package eCommerceFirstProject.FrameWorkSeleniumTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eCommerceFirstProject.GlobalTestCommonFun.CommonVisibleFunction;

public class EcommerceApplicationTest extends CommonVisibleFunction {

	public String productName = "ADIDAS ORIGINAL";

	// , 
	@Test(dataProvider = "dataProvide", groups = "Purchase")
	public void application(HashMap<String, String> input) throws IOException, InterruptedException {

		String CountryName = "Ind";
		ProductCatalogue productcatalogue = loginpage.loginWithCredential(input.get("email"), input.get("pass"));
		List<WebElement> listOfProd = productcatalogue.getListOfProducts();
		productcatalogue.goToCartProduct(input.get("productName"));
		GoToCartAndCheck goToCartAndCheck = productcatalogue.addToCart(input.get("productName"));
		goToCartAndCheck.goToCartedProductsCheck();
		Boolean prodName = goToCartAndCheck.checkTheSelectedProduct(input.get("productName"));
		Assert.assertTrue(prodName);
		AddressPageToEnterDetails addressPageToEnterDetails = goToCartAndCheck.goToCheckAndClick();
		FinalConfirmationOrderPage finalConfirmationOrderPage = addressPageToEnterDetails
				.goToBoxAndSendDetailsOfCountry(CountryName);
		/* Thread.sleep(2000); */
		String getText = finalConfirmationOrderPage.goToTextAndGrabTheText();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", getText);

	}
// dependsOnGroups = { "application" }
	@Test()
	public void orderapplication() throws IOException {
		ProductCatalogue productcatalogue = loginpage.loginWithCredential("man1con@gmail.com", "Mancon@1");
		OrderHistoryConfirmationPage orderHistoryConfirmationPage = productcatalogue.abstractClassForOrders();

		Assert.assertTrue(orderHistoryConfirmationPage.checkTheSelectedProduct(productName));

	}

	/*
	 * @DataProvider() public Object[][] dataProvide() { return new Object[][] { {
	 * "hnaveen@gmail.com", "Naveen0071@", "ZARA COAT 3" }, { "man1con@gmail.com",
	 * "Mancon@1", "ADIDAS ORIGINAL" } }; }
	 */

	@DataProvider()
	public Object[][] dataProvide() throws IOException {

		List<HashMap<String, String>> data = dataPurchaseReader(
				"C:\\Users\\NAVEEN\\eclipse-workspace\\FrameWorkSeleniumTest\\src\\test\\java\\eCommerceFirstProject\\DataReader\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	/*
	 * @DataProvider() public Object[][] dataProvide() {
	 * 
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "hnaveen@gmail.com"); map.put("pass", "Naveen0071@"); map.put("productName",
	 * "ZARA COAT 3");
	 * 
	 * HashMap<String, String> maps = new HashMap<String, String>();
	 * maps.put("email", "man1con@gmail.com"); maps.put("pass", "Mancon@1");
	 * maps.put("productName", "ADIDAS ORIGINAL"); return new Object[][] { { map },
	 * { maps } }; }
	 */

}
