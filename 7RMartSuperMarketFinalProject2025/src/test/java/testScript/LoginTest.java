package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LoginTest extends Base {
	@Test(priority = 4, description = "Verification of user login with valid credentials")
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		String expected = "Dashboard | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Messages.LOGINFAILED);
	}

	@Test(priority = 1, description = "Verification of user login with valid username and invalid password",groups = {"smoke"})
	public void verifyUserLoginWithValidUsernameAndInValidPassword() throws IOException {
		//WaitUtility wait=new WaitUtility();
		//wait.waitForElementToVisible(driver, usernamefield);
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVAILDPASSWORDLOGIN);

	}

	@Test(priority = 2, description = "Verification of user login with invalid username and valid password",groups = {"smoke"})
	public void verifyUserLoginWithInValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVALIDUSERNAME);

	}

	@Test(priority = 3, description = "Verification of user login with invalid username and password",retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithInValidUsernameAndInValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket",Messages.INVALIDUSERNAMEANDPASSWORD);

	}
}
