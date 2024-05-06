package rahulshettyacademy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
• What are Extent Reports.
• Understand Creating Extent Reports for
Single standalone Test
• Generating Extent Reports for Parallel Test
Execution
• Attaching Screenshots to Reports for Failed Tests using TestNG Listeners.
 */

public class ExtendReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void config(){
       String path = System.getProperty("user.dir") + "/Reports/index.html";
        System.out.println(path);
        // there are 2 classes we need: ExtentReports & ExtentSparkReporter
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

      //  ->  this the main class ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Nas Abousaleh");
    }

    @Test
    public void initialDemo(){
// the results will always show pass unless you specify to fail... see example
        ExtentTest test = extent.createTest("Initial Demo");
         // instead of sout// .set
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
        test.fail("Results do not match");

        extent.flush();


    }



}
