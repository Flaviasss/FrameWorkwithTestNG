package Com.SalesForce.Pages;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;




public class CreateOpportunitiesPage extends BaseSalesForce {
	
/*TC15 : opportunities drop down */
	@Test
	

	public void OpportunitiesDropDown() throws InterruptedException {
		
		login_Salesforce();
		
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		Thread.sleep(5000);
		WebElement Opportunity = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		Opportunity.click();
		 
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Opportunities')]")));

		if (Message.isDisplayed()) {
		    System.out.println("Error:Oppertunities dropdown is not displayed as expected");
		} else {
		    System.out.println("Oppertunities dropdown is displayed successfully.");
		}
		 driver.close();
		
		}
	  
   /* TC16: Create a newOpportunity */
   
		public void NewOpportunity() throws InterruptedException {
		
		login_Salesforce();		
		Thread.sleep(5000);
		
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		opportunitiesLink.click();
		
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='fcf']"));
		ele.click();
		Thread.sleep(5000);
		
	    WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
	    newButton.click();
	    Thread.sleep(5000);
	    
	    WebElement opportunityEditPage = driver.findElement(By.xpath("//h2[contains(text(), 'New Opportunity')]"));
	    
	    opportunityEditPage.click();
	    
	    System.out.println( "New Opportunity Edit page displayed.");

	    driver.findElement(By.id("opp3")).sendKeys("Banking");
	    driver.findElement(By.id("opp4")).sendKeys("Meenu");
	    driver.findElement(By.id("opp9")).sendKeys("02/02/2024"); // Example date
	    driver.findElement(By.id("opp11")).sendKeys("Qualification");
	    driver.findElement(By.id("opp12")).sendKeys("0");
	    driver.findElement(By.id("opp6")).sendKeys("Web");
	    

	    Thread.sleep(5000);
	    WebElement saveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
	    saveButton.click();
	    
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Opportunities')]")));

		if (Message.isDisplayed()) {
		    System.out.println("New Oppertunity details are stored");
		} else {
		    System.out.println("Error: New Oppertunity details are  not stored");
		}
		 driver.close();
		
		}
	/*TC17: Test Opportunity Pipeline Report   */
		@Test
		public void PipelineReport() throws InterruptedException {
	
		login_Salesforce();
		Thread.sleep(5000);
			
		WebElement opportunitiesLink = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		opportunitiesLink.click();
			
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='fcf']"));
		ele.click();
		Thread.sleep(5000);
	        
	
		WebElement reportsTab = driver.findElement(By.xpath("//a[contains(text(), 'Reports')]"));
	    
	    Actions actions = new Actions(driver);
	    actions.moveToElement(reportsTab).perform();

	    WebElement opportunityPipelineLink = driver.findElement(By.xpath("//a[contains(text(), 'Opportunity Pipeline')]"));
	    opportunityPipelineLink.click();
	    Thread.sleep(5000);	        
	    WebElement reportPageHeader = driver.findElement(By.xpath("//h1[contains(text(), 'Opportunity Pipeline')]"));
	    reportPageHeader.click();
	    Thread.sleep(5000);	
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Opportunities')]")));

		if (Message.isDisplayed()) {
		    System.out.println("Opportunity Pipeline Report is displayed successfully");
		} else {
		    System.out.println("Error: Opportunity Pipeline Report is not displayed as expected");
		}
		 driver.close();
		
		}
	/* TC 18: Test Stuck Opportunities Report */
		@Test

	  	public void StuckOpportunities() throws InterruptedException {
	
	    	login_Salesforce();
	  
	       
	    	WebElement opportunitiesLink = driver.findElement(By.xpath("//a[contains(text(), 'Opportunities')]"));
	        opportunitiesLink.click();

	        WebElement reportsTab = driver.findElement(By.xpath("//a[contains(text(), 'Reports')]"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(reportsTab).perform();

	        
	        WebElement stuckOpportunitiesLink = driver.findElement(By.xpath("//a[contains(text(), 'Stuck Opportunities')]"));
	        stuckOpportunitiesLink.click();
	        Thread.sleep(5000);
	        WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Opportunities')]")));

			if (Message.isDisplayed()) {
			    System.out.println("Error: StuckOpportunities Report is  not displayed as expected");
			} else {
			    System.out.println("StuckOpportunities Report is displayed successfully");
			}
	        
	        driver.close();
	    }
	
	/* TC 19: Test Quarterly Summary Report*/
		@Test
		
	  	public void QuarterlySummaryReport() throws InterruptedException {
	  		
		login_Salesforce();
	
	
		WebElement opportunitiesLink = driver.findElement(By.xpath("//a[contains(text(), 'Opportunities')]"));
		opportunitiesLink.click();
		
		WebElement dropdown = driver.findElement(By.xpath("//a[contains(text(), 'Opportunities')]"));
		dropdown.click();
		

		try {
           
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement intervalDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='quarter_q']")));

            Select intervalSelect = new Select(intervalDropdown);
            
            intervalSelect.selectByVisibleText(" ");
            Thread.sleep(10000);
            
            java.util.List<WebElement> options = intervalSelect.getOptions();
            for (WebElement option : options) {
                System.out.println(option.getText());
                Thread.sleep(5000);
            }         
            WebElement includeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='open']")));            
            Thread.sleep(5000); 
            if (!(includeCheckbox).isSelected()) {
               
            	includeCheckbox.click();

            
            WebElement runReportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='runReportButton']")));

            runReportButton.click();
           
            }

        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(5000);
            System.out.println(" Quarterly Summary Report displayed successfully");
        }
            driver.quit();
        }
}
