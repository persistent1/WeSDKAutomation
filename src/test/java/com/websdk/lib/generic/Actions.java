package com.websdk.lib.generic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions 
{
	public void click(WebElement element)
	{
		Log.debug("Clicking on web element " + element.getAttribute("id"));
		element.click();
	}
	
	public void sendKeys(WebElement element, String keysToSend)
	{
		Log.debug("send keys on web element " + element.getAttribute("id"));
		element.sendKeys(keysToSend);
	}

	public void sendKeys(WebElement element, Keys keysToSend) {
		Log.debug("send keys on web element " + element.getAttribute("id"));
		element.sendKeys(keysToSend);
	}
	
	public boolean scrollPageIntoView(WebDriver driver, String ElementTag,String LocateBy, int timeOut)
	{
	
		boolean result = false;
		int timer = 1;
		WebElement element = null;
		try{
			 
			while(timer<timeOut)
			{
				if(element==null)
				{
					element = (WebElement) Browser.getWaits().wait(driver, ElementTag, LocateBy,ExpectedCondition.visibilityOfElementLocated, 2, null);
					//JavascriptExecutor js = (JavascriptExecutor)driver;
					//WebElement searchElement = driver.findElement(By.linkText(eventName));
					org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					actions.keyUp(Keys.CONTROL).build().perform();
					//Object response = js.executeScript("arguments[0].scrollIntoView(true);", element);
					//Thread.sleep(5000); 	
					timer++;
				}else
				{
					return true;
				}
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		return result;
	}
	public boolean scrollPageIntoView(WebDriver driver, String ElementTag, int timeOut)
	{
	
		boolean result = false;
		int timer = 1;
		WebElement element = null;
		try{
			 
			while(timer<timeOut)
			{
				if(element==null)
				{
					element = (WebElement) Browser.getWaits().wait(driver, ElementTag,ExpectedCondition.visibilityOfElementLocated, 2, null);
					org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					actions.keyUp(Keys.CONTROL).build().perform(); 	
					timer++;
				}else
				{
					return true;
				}
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		return result;
	}

	public void clear(WebElement element) {
		element.clear();
	}
	
}
