package driverWrapper;

import org.openqa.selenium.WebDriver;

abstract class CoreDriver implements WebDriver{
	
	protected static WebDriver getDriver() {
		return DriverManagement.getDriver();
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
	public String getTitle() {
		return getDriver().getTitle();
	}
}
