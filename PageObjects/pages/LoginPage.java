package pages;

import common.Constant;
import driverWrapper.DriverManagement;

public class LoginPage {
	public LoginPage open() {
		DriverManagement.getDriver().navigate().to(Constant.URL);
		return new LoginPage();
	}
}
