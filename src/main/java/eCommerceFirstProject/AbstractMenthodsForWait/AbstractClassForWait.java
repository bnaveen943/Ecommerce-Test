package eCommerceFirstProject.AbstractMenthodsForWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eCommerceFirstProject.FrameWorkSeleniumTest.OrderHistoryConfirmationPage;

public class AbstractClassForWait {

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderPages;

	WebDriver driver;

	public AbstractClassForWait(WebDriver driver) {
		this.driver = driver;
	}

	public void abstractClassForWait(By toastMessage) {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
		waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toastMessage));
	}

	public void abstractClassForWait(WebElement toastMessage) {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		waits.until(ExpectedConditions.visibilityOf(toastMessage));
	}

	public OrderHistoryConfirmationPage abstractClassForOrders() {
		orderPages.click();
		OrderHistoryConfirmationPage orderHistoryConfirmationPage = new OrderHistoryConfirmationPage(driver);
		return orderHistoryConfirmationPage;
	}

	public void abstractClassForWaitInVisible(WebElement toastMessage) {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
		waits.until(ExpectedConditions.invisibilityOf(toastMessage));
	}

}
