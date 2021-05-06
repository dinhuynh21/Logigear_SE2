package driverWrapper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import common.DriverType;

public class DriverManagement {
	private static Map<String, WebDriver> map  = new HashMap<String, WebDriver>();

	public static void createDriver(DriverType type) {
		new Driver(type, false, null);
	}
	public static void createDriver(DriverType type, String hub) {
		new Driver(type, true, hub);
	}
	
	
	
	protected static String getThreadId() {
		return String.valueOf(Thread.currentThread().getId());
	}
	
	public static WebDriver getDriver() {
		return map.get(getThreadId());
	}
	
	protected static void addDriver(WebDriver driver) {
		try {
			map.put(getThreadId(), driver);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
