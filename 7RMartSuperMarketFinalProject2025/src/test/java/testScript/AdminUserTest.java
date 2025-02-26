package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {

	@Test(priority = 1, description = "Add new user to the admin usr page")
	public void VerifyUserCanAddNewAdminUser() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickAdminUser();
		adminuserpage.clickManageUser();
		adminuserpage.clickNewButton();
		String newusername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		String newpassword = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		adminuserpage.enterNewUsernameAndPassword(newusername, newpassword);
		adminuserpage.selectUserTypeFromDropdown();
		adminuserpage.clickSaveButton();
		boolean isAlertCheck=adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertCheck,Messages.NEWUSERCREATIONFAILED);
	}

}
