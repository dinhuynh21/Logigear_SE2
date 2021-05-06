package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverWrapper.DriverManagement;

abstract class CoreElement implements WebElement{
	
	protected WebElement _WebElement = null;
	private By _byLocator;
	
	public CoreElement(By locator) {
		this._byLocator = locator;
	}
	
	public CoreElement(String xpath) {
		this ._byLocator =  By.xpath(xpath);
	}
	
	protected WebDriver getDriver() {
		return DriverManagement.getDriver();
	}
	
	protected WebElement waitForPresent(int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
			_WebElement = wait.until(ExpectedConditions.presenceOfElementLocated(_byLocator));
		}catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return _WebElement;
	}
	protected WebElement waitForDisplay(int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
			_WebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(_byLocator));
		}catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return _WebElement;
	}
	

}
