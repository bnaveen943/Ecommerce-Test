package eCommerceFirstProject.FrameWorkSeleniumTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import eCommerceFirstProject.GlobalTestCommonFun.CommonVisibleFunction;
import eCommerceFirstProject.GlobalTestCommonFun.RerunFailedTestCases;

public class EcommerceTestAssertionTest extends CommonVisibleFunction {

	// Fail the testCase with Error Handling step
	//
	@Test(groups = { "Error HandlerTest" }, retryAnalyzer = RerunFailedTestCases.class)
	public void errorValidationTest() throws IOException {

		loginpage.loginWithCredential("hnaveen@gmail.com", "Nav71@");

		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMessage());

	}

	@Test()
	public void errorValidate() throws IOException {
		String productName = "ZARA COAT 3";
		String CountryName = "Ind";
		ProductCatalogue productcatalogue = loginpage.loginWithCredential("hnaveen@gmail.com", "Naveen0071@");
		List<WebElement> listOfProd = productcatalogue.getListOfProducts();
		productcatalogue.goToCartProduct(productName);
		GoToCartAndCheck goToCartAndCheck = productcatalogue.addToCart(productName);
		goToCartAndCheck.goToCartedProductsCheck();
		Boolean prodName = goToCartAndCheck.checkTheSelectedProduct("ZARA COAT 33");
		Assert.assertFalse(prodName);

	}

}
