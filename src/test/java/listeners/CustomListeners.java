package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import guru99Base.Guru99Base;

public class CustomListeners  implements ITestListener{

	 public void onTestStart(ITestResult result) {
	       
	        
	    }
	    public void onTestSuccess(ITestResult result) {
	        
	        Guru99Base.eTest.pass(result.getName().toUpperCase()+" test passed");
	        
	       
	    }
	    public void onTestFailure(ITestResult result) {
	       
	    }
	    public void onTestSkipped(ITestResult result) {
	     
	    }
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        
	    	
	       
	    }
	    public void onStart(ITestContext context) {
	    	Guru99Base.eTest = Guru99Base.rep.createTest("Banking");
	        
	    }
	    public void onFinish(ITestContext context) {
	        
	    	 Guru99Base.rep.flush();
	    }
	}
	

