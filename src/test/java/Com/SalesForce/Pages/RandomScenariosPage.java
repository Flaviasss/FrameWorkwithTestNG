package Com.SalesForce.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Com.SalesForce.base.BaseSalesForce;

public class RandomScenariosPage extends BaseSalesForce {
	
	@Test
		/* TC33: Verify if the firstname and lastname of the loggedin user is displayed */

	public void VerifyFirstAndLastName() throws InterruptedException {
			
			login_Salesforce();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement ViewProfile=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]")));	        
		    ViewProfile.click();
		    
		    WebElement ProfileCardname=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'content_115:3529;a\']/div/div[2]/h1/a")));	        
		    ProfileCardname.click();
		  

		    WebElement firstNameElement = driver.findElement(By.xpath("//span[@id='userNav-menuItems']/a[1]"));
		    WebElement lastNameElement = driver.findElement(By.xpath("//span[@id='userNav-menuItems']/a[2]"));

		       
		     String firstName = firstNameElement.getText();
		     String lastName = lastNameElement.getText();

		      
		     String expectedFirstName = "YourExpectedFirstName";
		     String expectedLastName = "YourExpectedLastName";

		     assert firstName.equals(expectedFirstName) : "Expected first name: " + expectedFirstName + ", Actual: " + firstName;
		     assert lastName.equals(expectedLastName) : "Expected last name: " + expectedLastName + ", Actual: " + lastName;

		        // Print the first name and last name
		     System.out.println("First Name: " + firstName);
		     System.out.println("Last Name: " + lastName);

		        // Close the browser
		      driver.quit();
		    }
		
	

@Test


		/*TC34: Verify the edited lastname is updated at various places*/
		public void EditLastName() throws InterruptedException {
			
			login_Salesforce();
			
			  WebElement userNavLabel = driver.findElement(By.id("userNavLabel"));
		        userNavLabel.click();

		      WebElement myProfileOption = driver.findElement(By.xpath("//a[contains(@title,'My Profile')]"));
		      myProfileOption.click();

		        
		      WebElement editProfileButton = driver.findElement(By.name("edit"));
		      editProfileButton.click();

		      WebElement contactTab = driver.findElement(By.id("contactTab"));
		      contactTab.click();

		      WebElement firstNameField = driver.findElement(By.id("firstName"));
		      new Actions(driver).moveToElement(firstNameField).perform();

		        
		        WebElement closeButton = driver.findElement(By.xpath("//div[@id='thePage:theForm:pbs:j_id5:j_id27:j_id61']/div[2]/a/img"));
		        closeButton.click();

		        WebElement updatedLastNameTopLeft = driver.findElement(By.xpath("//span[@id='tailf_lastNameContent']"));
		        assert updatedLastNameTopLeft.isDisplayed() : "Updated Last Name not displayed at the top left-hand side of the page.";

		        userNavLabel.click();
		        WebElement updatedLastNameUserMenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		        assert updatedLastNameUserMenu.getText().contains(updatedLastNameTopLeft.getText()) : "User menu does not show the updated Last Name.";

		       
		        WebElement userProfileTitle = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[contains(@title,'User:')]"));
		        assert userProfileTitle.getText().contains(updatedLastNameTopLeft.getText()) : "User profile page does not have the updated Last Name.";

		     
		        driver.quit();
		    }
		
		
	/*TC35: Verify the tab customization*/
		@Test
		public void CustomizeMyTabs() throws InterruptedException {
	
			login_Salesforce();
			WebElement userNavLabel = driver.findElement(By.xpath("//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]"));
	        userNavLabel.click();

	        WebElement customizeMyTabsOption = driver.findElement(By.xpath("//a[contains(@title,'Customize My Tabs')]"));
	        customizeMyTabsOption.click();

	        // Locate and remove the selected tab
	        WebElement selectedTab = driver.findElement(By.xpath("//td[@class='selectedPicklist']/option[1]"));
	        String selectedTabText = selectedTab.getText();

	        WebElement removeButton = driver.findElement(By.xpath("//img[@title='Remove']"));
	        removeButton.click();

	        // Verify that the tab is moved to the 'Available Tabs' section
	        WebElement availableTab = driver.findElement(By.xpath("//td[@class='availablePicklist']/option[text()='" + selectedTabText + "']"));
	        assert availableTab.isDisplayed() : "Selected tab not moved to the Available Tabs section.";

	        // Save the changes
	        WebElement saveButton = driver.findElement(By.xpath("//input[@name='save']"));
	        saveButton.click();

	        // Wait for the changes to be saved
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Verify that the 'Customize My Tabs' page is displayed
	        WebElement customizeMyTabsHeader = driver.findElement(By.xpath("//h1[contains(text(),'Customize My Tabs')]"));
	        assert customizeMyTabsHeader.isDisplayed() : "Customize My Tabs page not displayed.";

	        // Logout
	        userNavLabel.click();
	        WebElement logoutOption = driver.findElement(By.xpath("//a[contains(@title,'Logout')]"));
	        logoutOption.click();

	        // Close the browser
	        driver.close();
	    }
	

	/* TC36: Blocking an event in the calendar */
		@Test
		public void BlockingEventCalender() throws InterruptedException {
			
			login_Salesforce();
			

	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement homePageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Home')]")));
	        homePageLink.click();

	        WebElement currentDateLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='currentDate']/a")));
	        String currentDateText = currentDateLink.getText();

	        WebElement calendarLink = driver.findElement(By.xpath("//a[contains(text(),'Calendar')]"));
	        calendarLink.click();

	        WebElement newEventButton = driver.findElement(By.xpath("//a[contains(text(),'New Event')]"));
	        newEventButton.click();

	        WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='evt5']")));

	        WebElement comboBoxIcon = driver.findElement(By.xpath("//a[@id='timePickerItem_8']/img"));
	        comboBoxIcon.click();

	        WebElement comboBoxPopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='comboboxPopup']")));

	        comboBoxPopup.click();

	        subjectField.sendKeys("Other");

	        Select endTimeDropdown = new Select(driver.findElement(By.id("EndDateTime_time")));
	        endTimeDropdown.selectByVisibleText("9:00 PM");

	        WebElement saveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']"));
	        saveButton.click();

	        WebElement calendarPageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Calendar')]")));
	        calendarPageLink.click();

	        WebElement otherEventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Other')]")));
	        assert otherEventLink.isDisplayed() : "Event 'Other' is not displayed in the expected time slot.";

	        driver.close();
	    }
		
    /* TC37: Blocking an event in the calendar with weekly recurrence */
		@Test

		public void BlockingWeeklyCalendar() throws InterruptedException {
			
			login_Salesforce();

	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement homePageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Home')]")));
	        homePageLink.click();

	        WebElement currentDateLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='currentDate']/a")));
	        String currentDateText = currentDateLink.getText();

	        WebElement calendarLink = driver.findElement(By.xpath("//a[contains(text(),'Calendar')]"));
	        calendarLink.click();

	      
	        WebElement newEventButton = driver.findElement(By.xpath("//a[contains(text(),'New Event')]"));
	        newEventButton.click();

	        WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='evt5']")));

	        WebElement comboBoxIcon = driver.findElement(By.xpath("//a[@id='timePickerItem_5']/img"));
	        comboBoxIcon.click();

	        WebElement comboBoxPopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='comboboxPopup']")));
	        comboBoxPopup.click();

	        subjectField.sendKeys("Other");

	        Select endTimeDropdown = new Select(driver.findElement(By.id("EndDateTime_time")));
	        endTimeDropdown.selectByVisibleText("7:00 PM");

	        WebElement checkBox = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
	        checkBox.click();

	       
	        WebElement frequencySection = driver.findElement(By.xpath("//label[text()='Frequency']"));
	        WebElement startDateSection = driver.findElement(By.xpath("//label[text()='Start Date']"));
	        WebElement endDateSection = driver.findElement(By.xpath("//label[text()='End Date']"));

	        assert frequencySection.isDisplayed() && startDateSection.isDisplayed() && endDateSection.isDisplayed() :
	                "Frequency, Start Date, or End Date sections are not displayed.";

	        WebElement weeklyRadioButton = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
	        weeklyRadioButton.click();

	        WebElement recursEverySection = driver.findElement(By.xpath("//label[text()='Recurs Every..']"));
	        WebElement recursEveryInput = driver.findElement(By.xpath("//input[@id='rectypeinterval1']"));

	        assert recursEverySection.isDisplayed() && recursEveryInput.isDisplayed() &&
	                recursEveryInput.getAttribute("value").equals("1") : "Recurs Every.. section is not displayed or '1' is not entered.";

	        WebElement currentDayOfWeek = driver.findElement(By.xpath("//input[@id='rectypefdow']"));
	        assert currentDayOfWeek.isSelected() : "Current day of the week is not checked.";

	        WebElement endDateCheckbox = driver.findElement(By.xpath("//input[@id='rectypeenddate']"));
	        endDateCheckbox.click();

	        WebElement calendarPopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='calPopup']")));
	        calendarPopup.click(); 

	        WebElement calendarPageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Calendar')]")));
	        calendarPageLink.click();

	        WebElement otherEventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Other')]")));
	        assert otherEventLink.isDisplayed() : "Event 'Other' is not displayed in the expected time slot on the Calendar page.";

	        WebElement monthViewLink = driver.findElement(By.xpath("//a[contains(text(),'Month View')]"));
	        monthViewLink.click();

	        WebElement currentDateBlockedEvent = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//a[@class='month-link']//ancestor::td[contains(@class,'blocked')]//a[contains(text(),'Other')]")));
	        assert currentDateBlockedEvent.isDisplayed() : "Event 'Other' is not blocked on the current date.";

	       
	        String nextWeekDate = "Thursday July 25,2019"; // Adjust accordingly

	        WebElement nextWeekBlockedEvent = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//a[@class='month-link' and contains(text(),'" + nextWeekDate + "')]//ancestor::td[contains(@class,'blocked')]//a[contains(text(),'Other')]")));
	        assert nextWeekBlockedEvent.isDisplayed() : "Event 'Other' is not blocked on the week from the current date.";

	        driver.quit();
	    }
	        

	}



	



	


