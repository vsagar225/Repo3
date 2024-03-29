package pack2;


import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class NewTest{
ExtentReports extent;
ExtentTest logger;
@BeforeTest
public void startReport(){

extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
//extent.addSystemInfo("Environment","Environment Name")
extent
                .addSystemInfo("Host Name", "Host1")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "User1");
              
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
}
@Test
public void passTest(){
//extent.startTest("TestCaseName", "Description")
//TestCaseName – Name of the test
//Description – Description of the test
//Starting test
logger = extent.startTest("passTest");
Assert.assertTrue(true);
//To generate the log when the test case is passed
logger.log(LogStatus.PASS, "Test Case Passed is passTest");
}
@Test
public void failTest(){
logger = extent.startTest("failTest");
Assert.assertTrue(false);
logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
}
@Test
public void skipTest(){
	System.out.println("new comment -2");
	System.out.println("commit-2");
	System.out.println("commit-3");
logger = extent.startTest("skipTest");
throw new SkipException("Skipping - This is not ready for testing ");
 
 
 
}
@AfterMethod
public void getResult(ITestResult result){
if(result.getStatus() == ITestResult.FAILURE){
logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
}else if(result.getStatus() == ITestResult.SKIP){
logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
}
// ending test
//endTest(logger) : It ends the current test and prepares to create HTML report
extent.endTest(logger);
}
@AfterTest
public void endReport(){

                extent.flush();
               
                extent.close();
    }
}
