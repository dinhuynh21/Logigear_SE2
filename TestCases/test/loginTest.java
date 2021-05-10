package test;

import org.testng.annotations.Test;

import pages.LoginPage;

public class loginTest extends TestBase{
	private LoginPage loginPage = new LoginPage();
	@Test
	public void login() {
		System.out.println("Login: ");
		loginPage.open();
		System.out.println("Finish. ");
	}
}
