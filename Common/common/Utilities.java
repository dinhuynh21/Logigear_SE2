package common;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dashboard.Account;
import driverWrapper.DriverManagement;


public class Utilities {
	public static final long DEFAULT_TIMEOUT_SECONDS = 10;
	private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
	
	public static WebElement waitForVisibility(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManagement.getDriver(), DEFAULT_TIMEOUT_SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	
	public static WebElement waitForPresent(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManagement.getDriver(), DEFAULT_TIMEOUT_SECONDS);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static WebElement waitForClickAble(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManagement.getDriver(), DEFAULT_TIMEOUT_SECONDS);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	
	public static String getPageUrl() {
		String url = DriverManagement.getDriver().getCurrentUrl();
		return url;
	}
	
	public static String randomString(int count) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < count; ++i) {
			sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}
	
	public static String  randomMail(int count) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < count; ++i) {
			sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return sb.toString()+Account.USERNAME_RANDOM;
	}
	
	public static final WebElement getElement(By _by) {
		try {
			return DriverManagement.getDriver().findElement(_by);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static String getProjectPath() {
		String dir = System.getProperty("user.dir");
		return dir;
	}
}
