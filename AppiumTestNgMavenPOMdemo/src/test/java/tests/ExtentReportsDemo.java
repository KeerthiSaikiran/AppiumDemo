package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;
	ExtentSparkReporter spark;
	
	@BeforeSuite
	public void setupReport() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
		
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}

}
