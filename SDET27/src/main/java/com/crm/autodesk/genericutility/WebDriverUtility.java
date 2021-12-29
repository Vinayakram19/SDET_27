package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters.CronExpressionConverter;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author VINAYAKARAM J
 *
 */

public class WebDriverUtility {
	private JavascriptException JavascriptException;

	/**
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	
	public void WaitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	/**
	 * wait for page to load before identifying any synchronized[Java Script actions] element in DOM [HTML-Document]
	 * @param driver
	 */

    public void WaitForPageToLoadForJSElement(WebDriver driver) {
	 
	 driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
    
    /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param Element
     */
    public void WaitForElementToBeCheckable(WebDriver driver, WebElement Element) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    			wait.until(ExpectedConditions.elementToBeClickable(Element));
    			
    }
    
    
    /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param Element
     * @param pollingtime
     * @throws Throwable
     */
    public void WaitForElementWithCustomTimeOut(WebDriver driver, WebElement Element,int pollingtime) throws Throwable {
      
    	FluentWait wait=new FluentWait(driver);
            wait.pollingEvery(pollingtime, TimeUnit.SECONDS);
            wait.wait();
            wait.until(ExpectedConditions.elementToBeClickable(Element));	
}
    /**
     * used to Switch to Any Window based on Window Title
     * @param driver
     * @param PartialwindowTitle
     */
    
    
    public void SwitchToWindow(WebDriver driver, String PartialwindowTitle) {
    	Set<String> set= driver.getWindowHandles();
    	Iterator<String> it =set.iterator();
    	
    	while(it.hasNext()) {
    		String wid = it.next();
    		driver.switchTo().window(wid);
    		String CurrentwindowTitle = driver.getTitle();
    		if(CurrentwindowTitle.contains(PartialwindowTitle)) {
    		     break;
    		     
    		}
    	}
    	}		
    		
    	/**
    	 *used to switch to Alert Window & Click On OK button 	
    	 * @param driver
    	 */
    		
    	
    	public void switchToAlertWindowAndAccept(WebDriver driver)
    	{
    		driver.switchTo().alert().accept();
    	}
    	
    	/**
    	 * used to switch to alert window & click on cancel
    	 * @param driver
    	 */
    	public void SwitchToAlertWindowAndCancel(WebDriver driver) {
    		driver.switchTo().alert().dismiss();
    	}
    	
    	/**
    	 * used to switch to frame window based on index
    	 * @param driver
    	 * @param index
    	 */
    	public void SwitchToFrame(WebDriver driver, int index) {
    		driver.switchTo().frame(index);
    	}
    	/**
    	 * used to switch to frame window based on id or name attribute
    	 * @param driver
    	 * @param id_name_attribute
    	 */
    	
    	public void SwitchToFrame(WebDriver driver, String id_name_attribute) {
    		
    		driver.switchTo().frame(id_name_attribute);
    	}
    	
    	/**
    	 *used to select the value from dropdown based on index 
    	 * @param element
    	 * @param index
    	 */
    	public void select(WebElement element,int index) {
    		
          Select se1 = new Select(element);
          se1.selectByIndex(index);
    	}
    	
    	/**
    	 * used to select the value of dropdown based on value /option available in GUI
    	 * @param element
    	 * @param text
    	 */
    	public void select(WebElement element,String text) {
    		Select s1 =new Select(element);
    		s1.selectByVisibleText(text);
    		
    	}
    	
    	/**
    	 * used to place mouse cursor on specified element
    	 * @param driver
    	 * @param element
    	 */
    	public void MouseOverOnElement(WebDriver driver, WebElement element) {
    		
    		Actions act = new Actions(driver);
    		act.moveToElement(element).perform();
    	}
    	
    	/**
    	 * used to right on specified element
    	 * @param driver
    	 * @param element
    	 */
    	public void RightClickOnElement(WebDriver driver, WebElement element) {
    		Actions act = new Actions(driver);
    		act.contextClick(element).perform();
    		
    	}
    	
    	/**
    	 * 
    	 * @param driver
    	 * @param javaScript
    	 */
    	public void executeJavaScript(WebDriver driver, String javaScript) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeAsyncScript(javaScript, null);
    		
    	}
    	
    	public  void WaitAndClick(WebElement element) throws InterruptedException {
    		int count = 0;
    		while(count<20) {
    			try {
					element.click();
    				break;
    				
				} catch (Throwable e) {
					Thread.sleep(1000);
					count++;
				}
    		}		
    	}
    	
    	public void TakeScreenShot(WebDriver driver, String screenshotName) throws Throwable {
    		
    		TakesScreenshot ts = (TakesScreenshot)driver;
    		File src = ts.getScreenshotAs(OutputType.FILE);
    		File dest = new File("./screenshot/"+screenshotName+".PNG" );
    		
    		Files.copy(src, dest);
    		
    	
    	}
    	
    	/**
    	 * pass enter key appertain in toBrowser
    	 * @param driver
    	 */
    	
    	public void PassEnterKey(WebDriver driver) {
    		
    		Actions act = new Actions(driver);
    		act.sendKeys(Keys.ENTER).perform();
    	}
    	
    	/**
    	 * maximize the browser 
    	 * @param driver
    	 */
    	public void maximiseWindow(WebDriver driver) {
    		driver.manage().window().maximize();
    		
    	}
    	
}