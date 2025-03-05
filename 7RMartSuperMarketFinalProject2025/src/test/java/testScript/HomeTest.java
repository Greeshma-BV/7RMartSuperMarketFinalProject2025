package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description = "Verify user is able to logout from the application")
	public void verifyUserAbleToLogout() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnadminButton().clickOnLogoutButton();
		boolean isSignInButtonDisplayed=homepage.isSignInButtonDisplayed();
		Assert.assertTrue(isSignInButtonDisplayed, Messages.LOGOUTFAILED);
		

	}
}
