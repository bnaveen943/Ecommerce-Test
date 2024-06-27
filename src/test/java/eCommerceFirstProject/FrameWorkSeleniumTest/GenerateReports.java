package eCommerceFirstProject.FrameWorkSeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReports {

	ExtentReports eReport;

	@BeforeTest
	public void getExports() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter extReport = new ExtentSparkReporter(path);
		extReport.config().setReportName("Web Automation Results");
		extReport.config().setDocumentTitle("Test Results");

		eReport = new ExtentReports();
		eReport.attachReporter(extReport);
		eReport.setSystemInfo("TestEngineer", "Naveen Hallikeri");

	}

	@Test
	public void launchBrowser() {

		ExtentTest test = eReport.createTest("IntialDemo TestName");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		driver.getTitle();
		driver.close();
		test.fail("Test results did not match");

		eReport.flush();

	}

}
