package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(priority = 1,description = "Verify that user is able to add new news in the Manage news field")
	public void verifyUserAbleToAddNewNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSigninButton();
		String newnews = ExcelUtility.readStringData(1, 0, "ManageNewsPage"); 
		managenewspage=homepage.clickManageNewsMenu().clickNewButton().enterAddNews(newnews).clickSaveNewsButton();
		boolean isAltertshowingForManageNews=managenewspage.IsAlertDisplayed();
		Assert.assertTrue(isAltertshowingForManageNews,Messages.NEWSCREATFAILED);
	}

}
