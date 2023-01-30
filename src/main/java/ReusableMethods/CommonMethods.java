package ReusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.utility;

public class CommonMethods extends utility {
	
		public void clicking(WebElement e)
		{
			e.click();
		}
		
		public void passingText(WebElement e, String text)
		{
			e.sendKeys(text);
		}
		
		public void waiting(WebElement e)
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(e));
		}
		
		public void waiting1(WebElement e)
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		
		
		public void selectDropdown(WebElement e, String text)
		{
			Select s1 = new Select(e);
			s1.selectByVisibleText(text);
			
		}
		
		public void selectItemQuantityFromBootstrapDropdown(String xpath, String text)
		{
			List<WebElement> l= driver.findElements(By.xpath(xpath));
			for(WebElement e:l)
			{
				if(e.getText().equalsIgnoreCase(text))
				{
					e.click();
					break;
				}
			}
			
		}
		
		
		public void scrollDown()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
		}
		
		public void scrollTolement(WebElement e)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e);
		}
		
		public void enterAction()
		{
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).build().perform();
		}
		
		public void window_handles()
		{
			String parent = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for (String child : windows)
			{
				if (!parent.equalsIgnoreCase(child))
					driver.switchTo().window(child);
			}
		}
		
		public void screenCapture(String filePath)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File file=ts.getScreenshotAs(OutputType.FILE);
			try {
				FileInputStream fileInputStream= new FileInputStream(file);
				FileUtils.copyFile(file, new File(filePath));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		public WebElement specificElement(String xpath)
		{
			return driver.findElement(By.xpath(xpath));
		}
		
		public List<WebElement> getElements(String xpath)
		{
			return driver.findElements(By.xpath(xpath));
		}

	}



