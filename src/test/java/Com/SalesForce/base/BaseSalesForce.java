package Com.SalesForce.base;


import java.lang.module.ModuleDescriptor.Exports;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Com.SalesForce.utilities.ExtentReportsUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Com.SalesForce.utilities.Constants;
import Com.SalesForce.utilities.PropertiesUtility;

public class BaseSalesForce extends BaseSalesforceTest{
	
	public void login_Salesforce() throws InterruptedException {
		
	launchBrowser("edge");
	driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
	
	
    WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
    
    username.sendKeys("sowjanya@tekarch.com");
    Thread.sleep(5000);

    WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
    password.sendKeys("");
    
    WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
	loginButton.click();
    
	
	
}
}

	

	

