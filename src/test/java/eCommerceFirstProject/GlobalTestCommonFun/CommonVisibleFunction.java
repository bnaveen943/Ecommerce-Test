package eCommerceFirstProject.GlobalTestCommonFun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import eCommerceFirstProject.FrameWorkSeleniumTest.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.jar.asm.TypeReference;

public class CommonVisibleFunction {

	public WebDriver driver;

	public LoginPage loginpage;

	public WebDriver visibleValues() throws IOException {
		Properties prop = new Properties();
		/*
		 * FileInputStream fis = new FileInputStream(
		 * "C:\\Users\\NAVEEN\\eclipse-workspace\\FrameWorkSeleniumTest\\src\\main\\java\\eCommerceFirstProject\\fileStoragePackage\\GlobalFile.properties"
		 * ); prop.load(fis);
		 */
		// C:\\Users\\NAVEEN\\eclipse-workspace\\FrameWorkSeleniumTest
		// C:\Users\NAVEEN\eclipse-workspace\FrameWorkSeleniumTest\src\main\java\eCommerceFirstProject\fileStoragePackage\GlobalFile.properties
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\eCommerceFirstProject\\fileStoragePackage\\GlobalFile.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	public List<HashMap<String, String>> dataPurchaseReader(String filepath) throws IOException {
		String jasonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jasonContent,
				new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public String getScreenShot(String takenFailedScreenShot, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports" + takenFailedScreenShot + ".png");

		FileUtils.copyFile(source, file);

		return System.getProperty("user.dir") + "//reports" + takenFailedScreenShot + ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage landingPages() throws IOException {
		driver = visibleValues();
		loginpage = new LoginPage(driver);
		loginpage.goTo();

		return loginpage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeTab() {
		driver.close();
		// SLF4J API Module : use this dependency when we get error after using close
		// method

	}

}
