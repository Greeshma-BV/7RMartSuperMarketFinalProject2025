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
	

	public void clickOnadminButton() {
		adminclick.click();
	}
	public void clickOnLogoutButton()
	{
		logoutclick.click();
	}
	public boolean isSignInButtonDisplayed()
	{
		return signinbuttonclick.isDisplayed();
	}
	
	

}
