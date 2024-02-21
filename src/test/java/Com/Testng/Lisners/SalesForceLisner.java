package Com.Testng.Lisners;


import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class SalesForceLisner implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+".......test execution started........");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+".......test execution completed with success........");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(".......test execution completed with failure........");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(".......test execution started........");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(".......test execution completed........");
	}
	
	

}
