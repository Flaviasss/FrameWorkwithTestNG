package Com.SalesForce.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;


public class UserMenuDropDownPage extends BaseSalesForce{

	@Test
	public void UserMenu() throws InterruptedException {
		login_Salesforce();
		Thread.sleep(5000);		  
		WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[8]"));	        
	    userMenu.click();
	    Thread.sleep(5000);	       
	        if (userMenu.isDisplayed()) {
	            System.out.println("View Profile is displayed. Automation successful!");
	        } else {
	            System.out.println("View Profile is not displayed. Automation failed!");
	        }	       
	        driver.close();
	    }	
	
	@Test
		public void MyProfile() throws InterruptedException {
			
		login_Salesforce();
		Thread.sleep(5000);	
		
		WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[8]"));	        
	    userMenu.click();
	    Thread.sleep(5000);	
		
		WebElement Myprofile = driver.findElement(By.cssSelector("#content_115\\:3531\\;a > div > div.profile-card-indent > h1 > a"));	        
		Myprofile.click();
	    Thread.sleep(5000);
	  
		
		}
	@Test
		public void MySettings() throws InterruptedException {
			login_Salesforce();
			
			// Assume you have already logged in, if not, you should add login steps here

	        // Add some waiting time for the Salesforce page to load
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement userDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]")));
	        
	        
	        Actions actions = new Actions(driver);
	        actions.moveToElement(userDropdown).perform();

	        // Verify the dropdown options
	        WebElement myProfileOption = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
	        WebElement mySettingsOption = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
	        WebElement developerConsoleOption = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
	        WebElement logoutOption = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

	        assert myProfileOption.isDisplayed() : "My Profile option not displayed.";
	        assert mySettingsOption.isDisplayed() : "My Settings option not displayed.";
	        assert developerConsoleOption.isDisplayed() : "Developer Console option not displayed.";
	        assert logoutOption.isDisplayed() : "Logout option not displayed.";

	        // Open My Settings page
	        mySettingsOption.click();

	        // Wait for My Settings page to load
	        WebElement loginHistoryLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Login History')]")));

	        // Navigate to Login History and download data in .csv format
	        WebElement loginHistory = driver.findElement(By.xpath("//a[contains(text(),'Login History')]"));
	        loginHistory.click();

	        // Download data in .csv format (your logic to download CSV data)

	        // Navigate back to My Settings page
	        driver.navigate().back();

	        // Add Reports to Selected Tabs list
	        WebElement customizeTabsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Customize My Tabs')]")));
	        customizeTabsLink.click();

	        WebElement reportsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='draggable']/span[text()='Reports']")));
	        WebElement addReportsButton = driver.findElement(By.xpath("//img[@title='Add']"));
	        addReportsButton.click();

	        // Save the changes
	        WebElement saveButton = driver.findElement(By.xpath("//input[@name='save']"));
	        saveButton.click();

	        // Add Reports to the links in the top Salesforce pages
	        WebElement salesforceLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Salesforce')]")));
	        salesforceLink.click();

	        WebElement chatterLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Chatter')]")));
	        chatterLink.click();

	        WebElement salesAndMarketingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sales and Marketing')]")));
	        salesAndMarketingLink.click();

	        // Navigate back to My Settings page
	        driver.navigate().back();

	        // Save details as default mail options
	        WebElement emailLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Email')]")));
	        emailLink.click();

	        WebElement saveChangesButton = driver.findElement(By.xpath("//input[@name='save']"));
	        saveChangesButton.click();

	        // Navigate to Sample Event Pop window
	        WebElement sampleEventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Sample Event')]")));
	        sampleEventLink.click();

	        // Close the browser
	        driver.close();
		
		}
	@Test
		public void DeveloperConsole() throws InterruptedException {
			login_Salesforce();

	        // Assume you have already logged in, if not, you should add login steps here

	        // Add some waiting time for the Salesforce page to load
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement userDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='userNavLabel']")));

	        // Hover over the user dropdown to display the options
	        Actions actions = new Actions(driver);
	        actions.moveToElement(userDropdown).perform();

	        // Verify the dropdown options
	        WebElement developerConsoleOption = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
	        assert developerConsoleOption.isDisplayed() : "Developer Console option not displayed.";

	        // Open Force.com Developer Console window
	        developerConsoleOption.click();

	        // Switch to the newly opened window (your logic may vary based on the actual behavior of the application)
	        for (String windowHandle : driver.getWindowHandles()) {
	            driver.switchTo().window(windowHandle);
	        }

	        // Wait for Force.com Developer Console window to load
	        WebElement developerConsoleWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("developer-console")));

	        // Perform actions within the Developer Console window (if needed)

	        // Close the Force.com Developer Console window
	        driver.close();

	        // Switch back to the original window
	        driver.switchTo().window(driver.getWindowHandles().iterator().next());

	        // Close the browser
	        driver.close();
	    }
	
	@Test
	
		public void Logout() throws InterruptedException {
			login_Salesforce();
			

	        // Assume you have already logged in, if not, you should add login steps here

	        // Add some waiting time for the Salesforce page to load
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement userDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='userNavLabel']")));

	        // Hover over the user dropdown to display the options
	        Actions actions = new Actions(driver);
	        actions.moveToElement(userDropdown).perform();

	        // Verify the dropdown options
	        WebElement logoutOption = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	        assert logoutOption.isDisplayed() : "Logout option not displayed.";

	        // Click on Logout
	        logoutOption.click();

	        // Wait for the logout to complete and the login page to be displayed
	        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
	        usernameInput.click();

	        // Verify that the login page is displayed
	        assert driver.getCurrentUrl().equals("https://login.salesforce.com/") : "Logout unsuccessful.";

	        // Close the browser
	        driver.quit();
	    }   
	}


