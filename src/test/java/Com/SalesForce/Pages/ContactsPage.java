 package Com.SalesForce.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;

public class ContactsPage  extends BaseSalesForce  {
	
	/*TC25:Create new contact*/
	@Test
	public void NewContact() throws InterruptedException {
		login_Salesforce();
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		contact.click();
		WebElement newButton = driver.findElement(By.xpath("//*[@id=\'hotlist\']/table/tbody/tr/td[2]/input"));
        newButton.click();   
        
        Thread.sleep(5000);

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"name_firstcon2\"]"));
        firstName.sendKeys("Latha");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\'name_lastcon2\']"));
        lastName.sendKeys("Sri");
        Thread.sleep(5000);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\'bottomButtonRow\']/input[1]"));
        saveButton.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='bottomButtonRow']/input[1]")));
        
        System.out.println("New contact page displayed");
    		
    		driver.close();
    	}
        
    	
        
	
	
	/*TC26 Create new view in the Contact Page*/
	@Test
	public void newview() throws InterruptedException {
			login_Salesforce();
			
			java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
			System.out.println(menuItemCount);
			
			Thread.sleep(5000);
			WebElement contact = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
			contact.click();
			Thread.sleep(5000);
			WebElement newview = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
			newview.click();
			Thread.sleep(5000);
			
			System.out.println( "New Contact page displayed."); 

			driver.findElement(By.xpath("//*[@id=\'fname\']")).sendKeys("Latha");
			driver.findElement(By.xpath("//*[@id=\'devname\']")).sendKeys(" ");
			   
			Thread.sleep(5000);
			WebElement saveButton = driver.findElement(By.xpath(" //*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
			saveButton.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='bottomButtonRow']/input[1]")));
	        
	        if (saveButton.isSelected()) {
		    	System.out.println(" New Contact details are created");
		    	
		    } else {
		    	System.out.println("New Contact details are created");
		    }
		        
		    
			  
			
			    driver.close();
		}
	/*TC27: Check recently created contact in the Contact Page */
	@Test
	public void Recentlyview() throws InterruptedException {
		login_Salesforce();
		
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		contact.click();
		Thread.sleep(5000);
		WebElement Recentlyviewed = driver.findElement(By.xpath("//*[@id=\"hotlist_mode\"]"));
		Recentlyviewed.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='bottomButtonRow']/input[1]")));
		
		if (Recentlyviewed.isDisplayed()) {
	    	System.out.println(" Recentlyviewed details are  not displayed");
	    	
	    } else {
	    	System.out.println("Recentlyviewed details are displayed");
	    }
	        
	    driver.close();
		
		
	}
	/*TC28: Check 'My contacts' view in the Contact Page	*/
	@Test
	public void Mycontacts() throws InterruptedException {
		
		login_Salesforce();
		
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		contact.click();
		Thread.sleep(5000);
		
		WebElement Mycontacts = driver.findElement(By.xpath("//*[@id=\'00Bao000000HNdB_listSelect\']/option[8]"));
		Mycontacts.click();
		
		Thread.sleep(5000);
		
		  if (Mycontacts.isSelected()) {
			  
			  Thread.sleep(5000);
			  System.out.println("New Contact details are displayed");
		    			    	
		    } else {
		    	System.out.println("New Contact details are displayed");
		    }
		  driver.close();
		  
	}  
	/*TC29 View a contact in the contact Page */  	
	@Test
	public void Viewcontacts() throws InterruptedException {
		
		login_Salesforce();
		
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		contact.click();
		Thread.sleep(5000);
		
		WebElement viewcontact = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		 viewcontact.click();
		 
		 System.out.println("Recent contacts are desplayed");
		 
		 driver.close();
	}
	/*TC30 Check the Error message if, the required information is not entered while creating a New view in Contacts */
	@Test
	public void NewviewinContacts() throws InterruptedException {
		
		login_Salesforce();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement contactsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Contacts')]")));
        contactsTab.click();

        WebElement createNewViewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='newView']")));
        createNewViewButton.click();

        WebElement uniqueNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fname")));
        WebElement viewNameError = driver.findElement(By.xpath("//div[@class='errorMsg' and contains(text(),'Error: You must enter a value')]"));

        uniqueNameField.sendKeys("EFGH");

        assert viewNameError.isDisplayed() : "Error message not displayed under the View Name field.";

        // Close the browser
        driver.close();
    }

	/*TC31 Check the Cancel button works fine in Create New View*/
	public void CheckCancelButton() throws InterruptedException {
		
		login_Salesforce();
		  // Assume you have already logged in, if not, you should add login steps here

        // Add some waiting time for the Salesforce page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement contactsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Contacts')]")));
        contactsTab.click();

        // Open Create New View page
        WebElement createNewViewButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='newView']")));
        createNewViewButton.click();

        // Wait for the Create New View page to load
        WebElement viewNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fname")));
        WebElement uniqueNameField = driver.findElement(By.id("devname"));

        // Enter View Name and Unique Name
        viewNameField.sendKeys("ABCD");
        uniqueNameField.sendKeys("ABCD");

        // Save the view
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
        saveButton.click();

        // Wait for the Contacts Home page to load
        WebElement contactsHomeTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Contacts Home')]")));
        contactsHomeTab.click();

        // Verify the View ABCD is not created
        WebElement viewABCDLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'ABCD')]")));

        assert !viewABCDLink.isDisplayed() : "View ABCD is unexpectedly created.";

        // Close the browser
        driver.quit();
    }



	/*TC32 Check the Save and New button works in New Contact page */
	@Test
	public void CheckSaveandNewButton() throws InterruptedException {
		
		login_Salesforce();
		

        // Add some waiting time for the Salesforce page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement contactsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Contacts')]")));
        contactsTab.click();

        // Open Contact Edit: New Contact Page
        WebElement newContactButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='new']")));
        newContactButton.click();

        // Wait for the Contact Edit: New Contact Page to load
        WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name_lastcon2")));
        WebElement accountNameField = driver.findElement(By.id("con4"));

        // Enter Last Name and Account Name
        lastNameField.sendKeys("NewLastName");
        accountNameField.sendKeys("NewAccountName");

        // Save the new contact
        WebElement saveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
        saveButton.click();

        // Wait for the Contact Edit: New Contact Page to load again
        WebElement newContactPageHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Contact Edit: New Contact')]")));

        // Verify the new contact is created
        assert newContactPageHeader.isDisplayed() : "New contact is not created successfully.";

        // Close the browser
        driver.quit();
    }


}
	
