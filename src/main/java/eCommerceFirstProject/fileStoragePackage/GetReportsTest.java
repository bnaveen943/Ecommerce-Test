package eCommerceFirstProject.fileStoragePackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetReportsTest {

	public static ExtentReports getExports() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter extReport = new ExtentSparkReporter(path);
		extReport.config().setReportName("Web Automation Results");
		extReport.config().setDocumentTitle("Test Results");

		ExtentReports eReport = new ExtentReports();
		eReport.attachReporter(extReport);
		eReport.setSystemInfo("TestEngineer", "Naveen Hallikeri");
		
		return eReport;

	}

}
