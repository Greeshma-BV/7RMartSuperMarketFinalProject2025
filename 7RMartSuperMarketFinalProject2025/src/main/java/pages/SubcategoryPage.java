package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubcategoryPage {
	public WebDriver driver;

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//p[text()='Sub Category'])[1]")
	private WebElement subcategoryclick;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbuttonclick;
	@FindBy(id = "cat_id")
	private WebElement category;
	@FindBy(id = "subcategory")
	private WebElement txt_subcategory;
	@FindBy(id = "main_img")
	private WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement buttonsave;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement subcategorysearch;
	@FindBy(id = "un")
	private WebElement searchcategory;
	@FindBy(name = "ut")
	private WebElement txt_searchsubcategory;
	@FindBy(name = "Search")
	private WebElement searchbuttonclick;
	@FindBy(xpath="//*[text()=' Reset']")
	private WebElement btn_Reset;
	@FindBy(xpath="//*[text()=' Alert!']")
	private WebElement alertSubCategory;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	private WebElement resultTable;
	@FindBy(xpath="(//div[@class='row'])[2]")
	private WebElement resetAssert;
	
	public void selectSubCategory() {
		subcategoryclick.click();

	}

	public void clickOnNewBtnOnTheSubCategoryPage() {
		newbuttonclick.click();
	}

	public void selectCategoryFromDropdown() {
		Select categorydropdown = new Select(category);
		categorydropdown.selectByVisibleText("Vegetables");
	}

	public void enterSubCategoryName(String subcategory) {
		txt_subcategory.sendKeys(subcategory);
	}

	public void uploadImage() {
		choosefile.sendKeys(
				"C:\\Users\\grees\\eclipse-workspace\\7RMartFinalProject2\\src\\test\\resources\\leafyVegitable.jpg");

	}

	public void clickOnSaveBtnInTheSubCategoryPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(buttonsave));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttonsave);
		
	}
	public  boolean AlertIsDisplayedSubCategoryCreation()
	{
		return alertSubCategory.isDisplayed();
	}

	public void clickOnSearchBtnInTheSubCategoryPage() {
		subcategorysearch.click();
	}

	public void selectSubCategoryFromTheDropdown() {
		Select searchcategorydrpdown = new Select(searchcategory);
		searchcategorydrpdown.selectByVisibleText("Toys");
	}

	public void enterTheSubCategoryName(String searchsubcategory) {
		txt_searchsubcategory.sendKeys(searchsubcategory);// "SOFT TOYS190225100824"
	}

	public void clickSearchBtnAfterFillingTheDetails() {
		searchbuttonclick.click();

	}
	public boolean isTableDisplayed()
	{
		return resultTable.isDisplayed();
	}
	
	public void clickOnTheResetButton()
	{
		btn_Reset.click();
	}
	public boolean isRestWorking()
	{
		return resetAssert.isDisplayed();
	}

}
