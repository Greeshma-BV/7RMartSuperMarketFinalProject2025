package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	@Test(priority = 1, description = "Add new user to the admin usr page")
	public void VerifyUserCanAddNewAdminUser() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickAdminUser().clickManageUser().clickNewButton();
		FakerUtility faker=new FakerUtility();
		String newusername = faker.createUsername();
		String newpassword = faker.createPassword();
		adminuserpage.enterNewUsernameAndPassword(newusername, newpassword).selectUserTypeFromDropdown().clickSaveButton();
		boolean isAlertCheck=adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertCheck,Messages.NEWUSERCREATIONFAILED);
	}

}
