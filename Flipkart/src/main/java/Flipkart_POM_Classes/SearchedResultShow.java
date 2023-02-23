package Flipkart_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedResultShow {
	
	@FindBy (xpath = "//input[contains(@title,'Search for products')]")
	private WebElement searchForProduct ;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement search ;
	
	@FindBy (xpath = "//a[text()='Login']")
	private WebElement login ;
	
	@FindBy (xpath = "(//span[text()='Become a Seller'])[1]")
	private WebElement becomeASeller ;
	
	@FindBy (xpath = "(//div[text()='More'])[1]")
	private WebElement more ;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[1]")
	private WebElement firstResult;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[2]")
	private WebElement secondResult;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[3]")
	private WebElement thirdResult;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[4]")
	private WebElement fourthResult;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[5]")
	private WebElement fifthResult;
	
	@FindBy (xpath="(//div[@class='_30jeq3 _1_WHN1'])[1]")
	private WebElement firstResultPrise;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[1]")
	private WebElement electronics;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[2]")
	private WebElement tvAndAppliances;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[3]")
	private WebElement men;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[4]")
	private WebElement women;

	@FindBy (xpath="(//span[@class='_2I9KP_'])[5]")
	private WebElement babyAndKids;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[6]")
	private WebElement homeAndFurniture;
	
	@FindBy (xpath="(//span[@class='_2I9KP_'])[7]")
	private WebElement sportBooksAndMore;
	
	@FindBy (xpath="//a[text()='Flights']")
	private WebElement flight;
	
	@FindBy (xpath="//a[text()='Offer Zone']")
	private WebElement offerZone;
	
	Actions act;
	String txt1,rup1;
	//constructor
	public SearchedResultShow(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	//method
//	public void searchForProductsBrandAndMore(String a) {
//		searchForProduct.sendKeys("samsung mobiles");
//	}
	
//	public void clickSearchBox() {
//		search.click();
//	}
	
	public void clickOnLoginButton() {
		login.click();
	}
	
	public void clickOnBecomeASeller() {
		becomeASeller.click();
	}
	
	public void clickOnMore() {
		more.click();
	}
	public void clickOnFirstResult() {
		firstResult.click();
	}
	public void getFristResultText() {
		txt1=firstResult.getText();
		System.out.println(txt1);
	}
	public void getFristResultPrise() {
		rup1=firstResultPrise.getText();
		System.out.println(rup1);
	}
	public void clickOnSecondResult() {
		secondResult.click();
	}
	public void clickOnFifthResult() {
		fifthResult.click();
	}
	public void movePointerOnElectronics() {
		act.moveToElement(electronics).perform();
	}
	public void movePointerOnTVAndAppliances() {
		act.moveToElement(tvAndAppliances).perform();
	}
	public void movePointerOnMen() {
		act.moveToElement(men).perform();
	}
	public void movePointerOnWomen() {
		act.moveToElement(women).perform();
	}
	public void movePointerOnBabyAndKing() {
		act.moveToElement(babyAndKids).perform();
	}
	public void movePointerOnHomeAndFurniture() {
		act.moveToElement(homeAndFurniture).perform();
	}
	public void movePointerOnSportBooksAndMore() {
		act.moveToElement(sportBooksAndMore).perform();
	}
	public void clickOnFlight() {
		flight.click();
	}
	public void clickOnOfferZone() {
		offerZone.click();
	}
	
	
}
