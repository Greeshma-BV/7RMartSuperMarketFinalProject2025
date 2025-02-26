package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement managenews;

	public void clickManageNewsMenu() {
		managenews.click();
	}

	@FindBy(xpath = "//*[text()=' New']")
	private WebElement btn_addnewNews;

	public void clickNewButton() {
		btn_addnewNews.click();
	}

	@FindBy(xpath = "//*[@id='news']")
	WebElement txt_addnewnews;

	public void enterAddNews(String newnews) {
		txt_addnewnews.sendKeys(newnews);
	}

	@FindBy(xpath = "//*[@name='create']")
	WebElement btn_saveNews;

	public void clickSaveNewsButton() {
		btn_saveNews.click();
	}
	@FindBy(xpath="//*[text()=' Alert!']")
	private WebElement alert_MagaenewsCreate;
	public boolean IsAlertDisplayed()
	{
		return alert_MagaenewsCreate.isDisplayed();
	}
}
