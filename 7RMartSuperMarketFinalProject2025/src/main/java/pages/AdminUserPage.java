package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@class='nav-link'])[10]")
	private WebElement adminuser;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageuser;
	@FindBy(xpath = "//*[text()=' New']")
	private WebElement btn_Newuser;
	@FindBy(id = "username")
	private WebElement txt_newusername;
	@FindBy(id = "password")
	private WebElement txt_password;
	@FindBy(id = "user_type")
	private WebElement drpdwn_usertype;
	@FindBy(name = "Create")
	private WebElement btn_save;
	@FindBy(xpath="//*[text()=' Search']")private WebElement btnSearchUser;
	@FindBy(xpath="//input[@class='form-control'][@id='un']")private WebElement txt_existinguser;
	@FindBy(xpath="//select[@id='ut']") private WebElement drp_existingusertype;
	@FindBy(xpath="//button[@name='Search']")private WebElement btn_search;
	@FindBy(xpath="//*[text()=' Reset']")private WebElement btn_mainReset;
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissible']") 
	private WebElement alert;
	public void clickAdminUser() {
		adminuser.click();
	}

	public void clickManageUser() {
		manageuser.click();
	}

	public void clickNewButton() {
		btn_Newuser.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}

	public void enterNewUsernameAndPassword(String newusername, String newpassword) {
		txt_newusername.sendKeys(newusername);
		txt_password.sendKeys(newpassword);

	}

	public void selectUserTypeFromDropdown() {
		Select select = new Select(drpdwn_usertype);
		select.selectByVisibleText("Staff");
	}

	public void clickSaveButton() {
		btn_save.click();
	}

}
