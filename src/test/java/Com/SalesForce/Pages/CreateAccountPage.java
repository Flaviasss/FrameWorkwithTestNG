package Com.SalesForce.Pages;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;

public class CreateAccountPage extends BaseSalesForce  {
	
/* TC10: Create an Account */
	@Test
	
	public void CreateAnAccount() throws InterruptedException {
		
		login_Salesforce();
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
			
		WebElement account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Account_Tab']/a")));
		account.click();	
		
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		WebElement newAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")));
		newAccountButton.click();
      
        WebElement accountNameInput = driver.findElement(By.xpath("//*[@id='acc2']"));
        accountNameInput.sendKeys("Tina");

        WebElement typeDropdown = driver.findElement(By.xpath("//*[@id=\'acc6\']"));
        
        typeDropdown.sendKeys("Technology Partner");

        WebElement customerPriorityDropdown = driver.findElement(By.xpath("//*[@id=\'00Nao000000PJfO\']"));
        
        customerPriorityDropdown.sendKeys("High");
        Thread.sleep(5000);

        
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\'bottomButtonRow\']/input[1]"));
        saveButton.click();
        Thread.sleep(5000);
        WebElement Message = driver.findElement(By.xpath("//*[contains(text(),'Accounts')]"));
        
        	if(Message.isDisplayed()) {
        	
        		System.out.println( " Error: New Account page is not displayedas expected");
        	
        	}else {
        
        		System.out.println( "New Account page displayed successfully");
        		
        	}
        	driver.close();
   		 }

/*  TC11: Create new view link on accounts page */
@Test
	public void AccountNew() throws InterruptedException {
		
		login_Salesforce();
		
		Thread.sleep(5000);
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		opportunitiesLink.click();
			
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\'filter_element\']/div/span/span[2]/a[2]"));
		ele.click();
		Thread.sleep(5000);
		
		 System.out.println( "New Account page displayed.");

		   driver.findElement(By.xpath("//*[@id=\'fname\']")).sendKeys("Anna");
		   driver.findElement(By.xpath("//*[@id=\'devname\']")).sendKeys(" ");
		   
		   Thread.sleep(5000);
		    WebElement saveButton = driver.findElement(By.xpath(" //*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		    saveButton.click();
		  
		  
		    WebElement Message = driver.findElement(By.xpath("//*[contains(text(),'Accounts')]"));
	        
        	if(Message.isDisplayed()) {
        	
        		System.out.println( "Error: Account page  with Last activity column not be added as expected");
        	
        	}else {
        
        		System.out.println( "Account page  with Last activity column be added successfully");
        		
        	}
        	driver.close();
   		 }
	
	/* TC12 : Edit the view the Account*/
@Test
	public void AccountEdit() throws InterruptedException {
		
		login_Salesforce();
		
		Thread.sleep(5000);
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		opportunitiesLink.click();
			
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		ele.click();
		Thread.sleep(5000);
		
		 System.out.println( "New Account page displayed.");

		   driver.findElement(By.xpath("//*[@id=\'fname\']")).sendKeys("Ann");
		   driver.findElement(By.xpath("//*[@id=\'devname\']")).sendKeys(" ");
		   
		   Thread.sleep(5000);
		   
		    WebElement saveButton = driver.findElement(By.xpath(" //*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		    saveButton.click();
		    
		    WebElement Message = driver.findElement(By.xpath("//*[contains(text(),'Accounts')]"));
	        
        	if(Message.isDisplayed()) {
        	
        		System.out.println( "Error: Account page is not edited as expected ");
        	
        	}else {
        
        		System.out.println("Account page is edited succefully");
       		
        	}
        	driver.close();
	}
	/* TC 12: Last Activity column added to the edit page */
@Test
	public void LastActivity() throws InterruptedException {
		
		login_Salesforce();
		
		Thread.sleep(5000);
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		opportunitiesLink.click();
			
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		ele.click();
		Thread.sleep(5000);
		   driver.findElement(By.xpath("//*[@id=\'fname\']")).sendKeys("Ann");
		   driver.findElement(By.xpath("//*[@id=\'devname\']")).sendKeys(" ");
		   
		   Thread.sleep(5000);
		   
		    WebElement saveButton = driver.findElement(By.xpath(" //*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		    saveButton.click();
		    
		    WebElement Message = driver.findElement(By.xpath("//*[contains(text(),'Accounts')]"));
	        
        	if(Message.isDisplayed()) {
        	
        		System.out.println( "Error:Last activity column not added to the Account page as expected");
        	
        	}else {
        
        		System.out.println("Last activity column added successfully to the Account page");        		
        	}
        	driver.close();		
	}
	
	/* TC13: Merge accounts */
@Test
	public void AccountMerge() throws InterruptedException {
		login_Salesforce();
		
		Thread.sleep(5000);
		
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		opportunitiesLink.click();
		
		WebElement ToolTab = driver.findElement(By.xpath("//h3[contains(text(), 'Tools')]"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(ToolTab).perform();
	    Thread.sleep(5000);
		WebElement MergeAccounts= driver.findElement(By.xpath("//a[contains(text(), 'Merge Accounts')]"));
		MergeAccounts.click();
		
		WebElement FindAccount= driver.findElement(By.xpath("//*[@id=\'srch\']"));
		FindAccount.sendKeys("Latha");
		
		WebElement FindSpecificAccount= driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		FindSpecificAccount.click();
		WebElement Data1= driver.findElement(By.xpath("//*[@id=\'cid1\']"));
		Data1.click();
		WebElement Data2= driver.findElement(By.xpath("//*[@id=\'cid2\']"));
		Data2.click();
		
		Thread.sleep(5000);
		
		WebElement NextButton = driver.findElement(By.xpath("//*[@id='stageForm']/div/div[2]/div[5]/div/input[1]"));
		NextButton.click();
		Thread.sleep(5000);
		
		WebElement FindAccounts= driver.findElement(By.xpath("//*[@id='stageForm']/div/div[2]/div[4]/input[2]"));
		
		FindAccounts.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Accounts')]")));

		if (Message.isDisplayed()) {
		    System.out.println("Merge operation successful.");
		} else {
		    System.out.println(" Error: Merge operation failed.");
		}
		 driver.close();		
	}
	/* TC14: Create account report */
@Test
	public void AccountReports() throws InterruptedException, TimeoutException {
		login_Salesforce();
		
		Thread.sleep(5000);
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		opportunitiesLink.click();
		Thread.sleep(1000);
		WebElement Reports = driver.findElement(By.xpath("//h3[contains(text(), 'Reports')]"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(Reports).perform();
	    
	    WebElement lastactivity = driver.findElement(By.xpath("//a[contains(text(), 'Accounts with last activity > 30 days')] "));
	    		
	    lastactivity.click();
	    Thread.sleep(5000);
	    WebElement DateField = driver.findElement(By.xpath("//*[@id=\"ext-gen148\"]"));
	    DateField.click();
	  
	    driver.findElement(By.xpath("//*[@id=\"ext-gen20\"]")).click();
		
	    WebElement RunReport= driver.findElement(By.xpath("//*[@id='runReportBtn']/tbody"));
	   
	    RunReport.click();
	    Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Acconts')]")));

		if (Message.isDisplayed()) {
		    System.out.println("Error: Accounts reports are not displayed as expected");
		} else {
		    System.out.println("Accounts reports are successful.");
		}
		 driver.close();
	        driver.quit();
	    }


}
	
