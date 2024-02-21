package Com.SalesForce.Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;

public class LoginPage extends BaseSalesForce {
	@Parameters({"browser","version"})
    @Test
    public void NavigationTOSFDC() throws InterruptedException {
    	String Title = "SalesForce";
        
        driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
        enterText(Title, "SaleForce");
        Thread.sleep(5000);
    }

    @Test (priority =-1)
    public void LoginTOSFDC() throws InterruptedException {
    	
        driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("sowjanya@tekarch.com");
        Thread.sleep(5000);
    	
        WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
        password.clear();
        password.sendKeys("");
        Thread.sleep(5000);
        Assert.assertEquals(password.isDisplayed(), true, "Home page is displayed as expected");
    }

    @Test
    public void RememberUsername() throws InterruptedException {
    	
    	driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
    	
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        
        username.sendKeys("sowjanya@tekarch.com");
        Thread.sleep(5000);

        WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
        password.sendKeys("");

        Thread.sleep(5000);
        
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@class='r4 fl mr8']"));
        
        rememberMeCheckbox.click();
        Thread.sleep(5000);
        
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
        loginButton.click();
        Thread.sleep(5000);
        
        WebElement ViewProfile= driver.findElement(By.xpath("//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]"));	        
        ViewProfile.click();
	    Thread.sleep(5000);	
        WebElement Logout = driver.findElement(By.className("logout"));
        Logout.click();
        Thread.sleep(5000);	
        try {
            username = driver.findElement(By.xpath("//input[@name='username']"));
            Assert.assertTrue(username.isDisplayed(), "Home page is displayed.");
        } catch (StaleElementReferenceException e) {
            Assert.fail("Username element is stale after logout.");
        }      
    }

    @Test
    public void ForgotPassword() throws InterruptedException {
    	
    	
		driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("sowjanya@tekarch.com");
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
		password.sendKeys(" ");

		Thread.sleep(5000);
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		 

        try {
            // Attempt to interact with the stale element
            Assert.assertTrue(password.isDisplayed(), "Error: Home page is not displayed as expected");
        } catch (StaleElementReferenceException e) {
            // Re-locate the password element after catching the stale element exception
            password = driver.findElement(By.xpath("//input[@name='pw']"));

            Assert.assertTrue(password.isDisplayed(), "Error: Home page is not displayed as expected");
        }
       
    }

    @Test
    public void EnterWrongUsernameandPassword() throws InterruptedException {
     	
    	driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");
    	Thread.sleep(1000);
    	
    	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("123");
        
		Thread.sleep(5000);
		
		 WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
		 password.sendKeys("22131");
		 Thread.sleep(5000);
		 
		 WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
 		loginButton.click();
 		Thread.sleep(1000);
 	     try {
             // Attempt to interact with the stale element
             Assert.assertTrue(password.isDisplayed(), "Error: Home page is not displayed as expected");
         } catch (StaleElementReferenceException e) {
             // Re-locate the password element after catching the stale element exception
             password = driver.findElement(By.xpath("//input[@name='pw']"));

             Assert.assertTrue(password.isDisplayed(), "Error: Home page is not displayed as expected");
         }
     }
    @Test
    public void VerifyLogout() throws InterruptedException {
    	driver.navigate().refresh();
    	
        driver.get("https://tekarch151-dev-ed.develop.my.salesforce.com/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='pw']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

        username.sendKeys("sowjanya@tekarch.com");
        password.sendKeys("Sudeep@17!");
        loginButton.click();
        waitForVisibility(loginButton, 10, 0, null);
        
        WebElement ViewProfile = driver.findElement(By.xpath("//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]")); 
        ViewProfile.click();

        WebElement Logout = driver.findElement(By.className("logout"));
        waitForVisibility(Logout, 10, 0, null);
        Logout.click();
        

        try {
            // Attempt to interact with the stale element (logout button)
            Assert.assertTrue(Logout.isDisplayed(), "Error: Logout button is not displayed.");
        } catch (StaleElementReferenceException e) {
            Assert.fail("Successfully logged out (handling StaleElementReferenceException)");
        }
    }

 }
