package Com.SalesForce.Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;


public class LeadsPage  extends BaseSalesForce{
	
	

	/* TC 20: check leads tab link */
	@Test
	
	public void LeadsHomepage() throws InterruptedException {
		
		login_Salesforce();
		Thread.sleep(10000);
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		WebElement Leads= driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
		Leads.click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Leads')]")));

		if (Message.isDisplayed()) {
		    System.out.println("Leads Home page is not displayed.");
		} else {
		    System.out.println("Leads Home page is displayed successfully.");
		}
		 driver.close();
	
			
	}
	/* TC 21: Validate 'View' drop down list contents */
	@Test
	public void Leads_Link() throws InterruptedException{
		
		login_Salesforce();
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println("List"+menuItemCount);
		
		Thread.sleep(5000);
		WebElement LeadsPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
		LeadsPage.click();
		Thread.sleep(5000);
		WebElement ViewDropDown = driver.findElement(By.xpath("//*[@id=\'filter_element\']/div/span/label"));
		ViewDropDown.click();
		
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Leads')]")));
				
		if (Message.isDisplayed()) {
		    System.out.println("Leads Home page is not displayed");
		} else {
		    System.out.println("Leads Home page is displayed successfully.");
		}
		 driver.close();
	
			
	}
	
	/* TC 22: Functionality of the Go Button */
	@Test
	public void LeadsFunctionality() throws InterruptedException{
		login_Salesforce();
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println("List"+menuItemCount);
		
		Thread.sleep(5000);
		WebElement LeadsPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
		LeadsPage.click();
		
		Thread.sleep(5000);
		WebElement GoButton = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[1]/input"));
		GoButton.click();
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Leads')]")));
				
		if (Message.isDisplayed()) {
		    System.out.println("Leads Home page is not displayed");
		} else {
		    System.out.println("Leads Home page is displayed successfully.");
		}
		 driver.close();	
	}
	
	/* TC 23: List item "Todays Leads" work*/
	@Test
	public void TodayLeads() throws InterruptedException{
		
		login_Salesforce();
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println("Menu"+menuItemCount);
		
		Thread.sleep(5000);
		WebElement LeadsPage = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]"));
		LeadsPage.click();
		Thread.sleep(5000);
		WebElement View = driver.findElement(By.xpath("//span[@class='fBody']"));
		View.click();
		
		WebElement Default = driver.findElement(By.xpath("//*[@id='fcf']/option[6]"));		
		Default.click();
		
		WebElement GoButton = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[1]/input"));
		GoButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Leads')]")));
				
		if (Message.isDisplayed()) {
		    System.out.println("Todays Leads page is not displayed successfully.");
		} else {
		    System.out.println("Todays Leads page is displayed successfully.");
		}
		 driver.close();
	
			
	}
	/* TC 24: Check "New" button on Leads Home */
	@Test
	public void Recent_Leads() throws InterruptedException{
		
		login_Salesforce();
		java.util.List<WebElement> menuItemCount = driver.findElements(By.xpath("//one-app-nav-bar-menu-item"));
		System.out.println(menuItemCount);
		
		Thread.sleep(5000);
		WebElement LeadsPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
		LeadsPage.click();
		Thread.sleep(5000);
		WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
	    newButton.click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//*[@id='name_lastlea2']")).sendKeys("SFDC");
	    driver.findElement(By.xpath("//*[@id='lea3']")).sendKeys("SFDC");
	   
	    Thread.sleep(5000);
	    WebElement saveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
	    saveButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Leads')]")));
				
		if (Message.isDisplayed()) {
		    System.out.println("Newly created lead view page is displayed successfully");
		} else {
		    System.out.println("Newly created lead view page is  not displayed .");
		}
		 driver.quit();
	
			
	}

}
