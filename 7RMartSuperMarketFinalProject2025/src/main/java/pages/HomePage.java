package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Admin")
	private WebElement adminclick;
	@FindBy(linkText = "Logout")
	private WebElement logoutclick;
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement signinbuttonclick;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageuser;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement managenews;
	@FindBy(xpath = "(//p[text()='Sub Category'])[1]")
	private WebElement subcategoryclick;

	public HomePage clickOnadminButton() {
		adminclick.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logoutclick.click();
		return new LoginPage(driver);
	}

	public boolean isSignInButtonDisplayed() {
		return signinbuttonclick.isDisplayed();
	}

	public AdminUserPage clickManageUser() {
		manageuser.click();
		return new AdminUserPage(driver);
	}
	public ManageNewsPage clickManageNewsMenu() {
		managenews.click();
		return new ManageNewsPage(driver);

	}
	public SubcategoryPage selectSubCategory() {
		subcategoryclick.click();
		return new SubcategoryPage(driver);

	}

}
