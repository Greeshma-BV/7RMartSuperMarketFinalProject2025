package testScript;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends Base {
	
	@Test(priority = 1,description = "Verify user is able to add new subcategory")
	public void verifyUserIsAbleToAddSubcategory() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnNewBtnOnTheSubCategoryPage();
		subcategorypage.selectCategoryFromDropdown();
		String subcategory = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		subcategorypage.enterSubCategoryName(subcategory);
		subcategorypage.uploadImage();
		subcategorypage.clickOnSaveBtnInTheSubCategoryPage();
		boolean isAlertDisplayedForSubcategoryCreation=subcategorypage.AlertIsDisplayedSubCategoryCreation();
		Assert.assertTrue(isAlertDisplayedForSubcategoryCreation, Messages.SUBCATEGORYCREATEFAILED);
	}
	@Test(priority = 2,description = "Verify user is able to search an existing subcategory")
	public void verifyUserAbleToSearchSubcategory() throws IOException
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnSearchBtnInTheSubCategoryPage();
		subcategorypage.selectSubCategoryFromTheDropdown();
		String searchsubcategory=ExcelUtility.readStringData(1, 1, "SubCategoryPage");
		subcategorypage.enterTheSubCategoryName(searchsubcategory);
		subcategorypage.clickSearchBtnAfterFillingTheDetails();
		boolean isSearchTableDisplayed=subcategorypage.isTableDisplayed();
		Assert.assertTrue(isSearchTableDisplayed, Messages.TABLENOTDISPLAYED);
		
	}
	@Test(priority = 3,description = "Verify user is able to rest the existing search result")
	public void verifyRestButtonFunctionality() throws IOException
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnSearchBtnInTheSubCategoryPage();
		subcategorypage.selectSubCategoryFromTheDropdown();
		String searchsubcategory=ExcelUtility.readStringData(1, 1, "SubCategoryPage");
		subcategorypage.enterTheSubCategoryName(searchsubcategory);
		subcategorypage.clickSearchBtnAfterFillingTheDetails();
		subcategorypage.clickOnTheResetButton();
		boolean assertReset=subcategorypage.isRestWorking();
		Assert.assertFalse(assertReset, Messages.RESETFAILED);
	}
}
