package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.Constant;
import common.DriverType;
import driverWrapper.DriverManagement;
import pages.LoginPage;

public class TestBase {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Run beforeMethod");
		DriverManagement.createDriver(DriverType.Chrome);
		DriverManagement.getDriver().navigate().to(Constant.URL);
		DriverManagement.getDriver().manage().window().maximize();
		LoginPage loginPage = new LoginPage();
		loginPage.open();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Run after Method");
		DriverManagement.getDriver().quit();
	}

}
