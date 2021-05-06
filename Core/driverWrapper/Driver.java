package driverWrapper;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.Constant;
import common.DriverType;

public class Driver extends CoreDriver{
	
	private static DesiredCapabilities caps;
	private WebDriver _driver;
	
	public Driver( DriverType type, boolean parallel, String hub) {
		try {
			System.out.println("Create driver type: "+ type);
			switch (type.getValue()) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Core\\core.drivers\\chromedriver.exe");
				if(parallel) {
					caps = DesiredCapabilities.chrome();
					_driver = new RemoteWebDriver(new URL(hub), caps);
				} else {
					_driver = new ChromeDriver();
				}
				
				DriverManagement.addDriver(_driver);
				
				break;
			case "Firefox":
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Core\\core.drivers\\geckodriver.exe");
				if(parallel) {
					caps = DesiredCapabilities.firefox();
					_driver = new RemoteWebDriver(new URL(hub), caps);
				} else {
					_driver = new FirefoxDriver();
				}
				
				DriverManagement.addDriver(_driver);
				
				break;
			
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static JavascriptExecutor jsExecutor() {
		return ((JavascriptExecutor) getDriver());
	}
	public static Object executeScript(String script, Object... args) {
		return jsExecutor().executeScript(script);
	}
	
	public static void setImplicitlyWait() {
		setImplicitlyWait(Constant.TIMEOUT);
	}
	
	public static void setImplicitlyWait(int timeOutInSecond) {
		getDriver().manage().timeouts().implicitlyWait(timeOutInSecond, TimeUnit.SECONDS);
	}

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
}
