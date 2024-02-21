package Com.SalesForce.base;


import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	
	public class BaseSalesforceTest {
				
		protected WebDriver driver = null;
		protected Wait<WebDriver> wait = null;
		protected Logger BaseSalesforceTest=LogManager.getLogger(BaseSalesforceTest.class);
		

	    @BeforeMethod
	    public void setUp() {
	        // Initialize the driver before each test method
	        launchBrowser("edge"); 
	        System.out.println("Before Method started");
	    }

	    // Other test methods...

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser after each test method
	        closeBrowser();
	        System.out.println("After Method ended");
	    }
	    @BeforeClass
	    public static void setUpClass() {
	    	
	    	System.out.println(" inside Beforeclass setUpclass");
	    	
	    }
	    @AfterClass
	    public static void tearDownClass() {
	    	
	    	System.out.println(" inside Afterclass tearDownclass");
	    	
	    }
	    
	    @BeforeSuite
	    public static void setUpSuite() {
	    	
	    	System.out.println(" inside BeforeSiute ");
	    	
	    }
	    @AfterSuite
	    public static void tearDownSuite() {
	    	
	    	System.out.println(" inside AfterSiute");
	    	
	    }
	    

		public void launchBrowser(String browserName) {

			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				BaseSalesforceTest.info("browser instance chrome created.");
				driver.manage().window().maximize();
				BaseSalesforceTest.info("window is maximized");
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;

			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				driver.manage().window().maximize();
				break;

			case "safari":
				// Safari does not require a separate driver setup, as it is included with macOS
				driver = new SafariDriver();
				break;

			default:
				BaseSalesforceTest.info("Unsupported browser: " + browserName);
			}

			// return driver;
		}
		
		public void goToUrl(String url) {
			driver.get(url);
			BaseSalesforceTest.info(url + "is entered");
			
		}
		
		public void enterText(String Title, String data) {
			
			
			if (Title.equals(data)) {
	            System.out.println("Title is not matched");
	        } else {
	            System.out.println("Title is matched");
	        }

		}
		
		public void enterText(WebElement ele, String data) {
			
			// web element password, data is "1234" , 
			
			if (ele.isDisplayed()) {
	            
	            System.out.println("Please enter your password");
	        } else {
	            System.out.println("password field is empty");
	        }
		}
		


		

		public void enterText(WebElement ele, String data, String objectName) {
			
			
			
			
			if (ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(data);
				BaseSalesforceTest.info("username data is entered in " + objectName + " textbox");
			} else {
				BaseSalesforceTest.info(objectName + " element is not displayed");
			}
		}
		
		public void clickElement(WebElement ele, String objectName) {
			if (ele.isEnabled()) {
				ele.click();
				BaseSalesforceTest.info(objectName + "button is clicked");
				
			} else {
				BaseSalesforceTest.info(objectName+" element is not enabled");
				
			}
		}
		
		public String getTextFromElement(WebElement ele, String objectName) {
			String data = ele.getText();
			BaseSalesforceTest.info("text is extracted from "+objectName);
			return data;
		}
		
		public void closeBrowser() {
			driver.close();
			BaseSalesforceTest.info("browser instance closed");
			driver=null;
		}
		
		
		public void maximiseBrowser() {
			driver.manage().window().maximize();
			//BaseSalesforceTest.info("browser window has maximized");
		}

		public String getPageTitle() {
			return driver.getTitle();
		}

		public void refreshPage() {
			driver.navigate().refresh();
			BaseSalesforceTest.info("page is refreshed");

		}



		public void quitBrowser() {
			driver.quit();
			BaseSalesforceTest.info("all browser closed");
			driver=null;
			
		}
	
		

		public void clearElement(WebElement ele, String ObjectName) {
			if (ele.isDisplayed()) {
				ele.clear();
				BaseSalesforceTest.info(ObjectName + " is cleared");
			} else {
				BaseSalesforceTest.info(ObjectName + " element is not displayed");
			}
		}

		
	

		// ****************handling alerts reusable methods************************//
		public Alert switchToAlert() {

			Alert alert = driver.switchTo().alert();
			BaseSalesforceTest.info("switched to alert");
			return alert;
		}

		public void AcceptAlert(Alert alert) {

			BaseSalesforceTest.info("Alert accepted");
			alert.accept();

		}

		public String getAlertText(Alert alert, String objectname) {
			BaseSalesforceTest.info("etracting text in the " + objectname + "alert");
			String text = alert.getText();
			BaseSalesforceTest.info("text is extracted from alert box is==" + text);
			return text;

		}

		public void dismisAlert() {

			Alert alert = switchToAlert();
			alert.dismiss();
			BaseSalesforceTest.info("Alert dismissed");

		}
		// ******************************alert ends**************************************

		// ******************************Action class reusable methods**************************************
		

		public void mouseOverOnElement(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			BaseSalesforceTest.info(" cursor moved to web element " + objName);
		}

		public void ContextClickOnElement(WebElement ele, String objName) {
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
			BaseSalesforceTest.info("right click persormed on web element " + objName);
		}

		// ******************************Action class reusable method ends**************************************

		// ******************************Select class reusable method starts*************************************

		public void selectByTextData(WebElement element, String text, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByVisibleText(text);
			BaseSalesforceTest.info(objName + " selected " + text);

		}

		public void selectByIndexData(WebElement element, int index, String objName) {
			waitForVisibility(element, 5, index, objName);
			Select selectCity = new Select(element);
			selectCity.selectByIndex(index);
			BaseSalesforceTest.info(objName + " selected with index=" + index);

		}

		public void selectByValueData(WebElement element, String text, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByValue(text);
			BaseSalesforceTest.info(objName + " selected ");
		}
		
		public WebElement selectFromListUsingText(List<WebElement> list, String text) {
			WebElement element = null;
			for (WebElement i : list) {
				if (i.getText().equalsIgnoreCase(text)) {
					BaseSalesforceTest.info("selected=" + i.getText());
					element = i;
					break;
				}

			}
			return element;

		}

		// ******************************select class reusable method ends**************************************

		// ******************************wait reusable method starts**************************************

		public void waitUntilPageLoads() {
			BaseSalesforceTest.info("waiting until page loads with 30 sec maximum");
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		}
		public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait
			.withTimeout(Duration.ofSeconds(time))
			.pollingEvery(Duration.ofSeconds(pollingtime))
			.ignoring(ElementNotInteractableException.class)
			.withMessage(objectName+" is not visible.fluent wait time expires");

			wait.until(ExpectedConditions.visibilityOf(ele));
			BaseSalesforceTest.info(objectName + " is waited for visibility using fluent wait");
		}

		public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
			BaseSalesforceTest.info("waiting for an web element " + objName + " for its visibility");
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		}

		public void waitUntilElementToBeClickable(By locator, String objName) {
			BaseSalesforceTest.info("waiting for an web element " + objName + " to be clickable");
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		
		public void waitForAlertPresent(WebElement username) {
			BaseSalesforceTest.info( "waited for alert to display ");
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.alertIsPresent());
		}

		public void switchToNewWindowFrom(String currentWindowHandle) {
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
				if (!currentWindowHandle.equalsIgnoreCase(handle))
					driver.switchTo().window(handle);
			}
			BaseSalesforceTest.info("switched to new window");
		}
		// ******************************wait reusable method starts**************************************


		
		public void takescreenshot(String filepath) {
			 TakesScreenshot screenCapture=(TakesScreenshot)driver;
			 File src=screenCapture.getScreenshotAs(OutputType.FILE);
			 File destination=new File(filepath);
			 try {
				Files.copy(src, destination);
				BaseSalesforceTest.info("captured the screen");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				BaseSalesforceTest.info("captured the screen");
				
			}
		}
		
		public void takescreenshot(WebDriver driver2,String filepath) {
			 File src=((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
			 File destination=new File(filepath);
			 try {
				Files.copy(src, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				BaseSalesforceTest.info("captured the screen");
				
			}
		}

	}