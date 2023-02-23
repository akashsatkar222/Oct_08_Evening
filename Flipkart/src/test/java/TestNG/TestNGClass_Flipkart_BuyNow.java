package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Flipkart_POM_Classes.FlipkartHomePage;
import Flipkart_POM_Classes.ProductDetailsPage;
import Flipkart_POM_Classes.SearchedResultShow;
import browser.BrowserSetup;

public class TestNGClass_Flipkart_BuyNow {
	
	WebDriver driver;
	FlipkartHomePage flipkartHomePage;
	SearchedResultShow searchedResultShow;
	ProductDetailsPage productDetailsPage;
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
		}
		if (browserName.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObject() {
		driver.get("https://www.flipkart.com/");
		
		flipkartHomePage = new FlipkartHomePage(driver);
		flipkartHomePage.clickOnExit();
		
		
	}
	@BeforeMethod
	public void searchTheProduct() {
		
		flipkartHomePage.searchForProductsBrandAndMore("samsung mobiles");
		flipkartHomePage.clickOnSearchBox();
	}
	@Test 
	public void toBuyTheProduct() {
		searchedResultShow = new SearchedResultShow(driver);
 		searchedResultShow.clickOnFirstResult();
 		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.getProductTittle();
		productDetailsPage.getProductPrise();
		productDetailsPage.clickOnBuyNowButton();
	}
	
    @AfterMethod
	public void afterMethod() {
        driver.close();
	}
	@AfterClass
	public void clearPOMObject() {
		flipkartHomePage = null;
		searchedResultShow = null;
		productDetailsPage = null;
	}
	@AfterTest
	public void closeTheBrowser() {
		driver.quit();
		driver = null;
		
		System.gc();
	}

}
