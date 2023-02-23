package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

public class Flipkart_AddToCart {

	WebDriver driver;
	FlipkartHomePage flipkartHomePage;
	SearchedResultShow searchedResultShow;
	ProductDetailsPage productDetailsPage;
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
			
		}
		if (browser.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\edgedriver_win64\\msedgedriver.exe");
//			WebDriver driver = new EdgeDriver();
			
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
		
		
		flipkartHomePage.searchForProductsBrandAndMore("oppo mobiles");
		flipkartHomePage.clickOnSearchBox();
	}
	@Test 
	public void toAddToCartProduct() {
		searchedResultShow = new SearchedResultShow(driver);
		searchedResultShow.clickOnFifthResult();
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.getProductTittle();
		productDetailsPage.getProductPrise();
		productDetailsPage.clickOnAddToCartButton();
	}
//	@Test 
//	public void toAddToCartProduct() {
//		searchedResultShow.clickOnFirstResult();
//		productDetailsPage = new ProductDetailsPage(driver);
//		productDetailsPage.getProductTittle();
//		productDetailsPage.getProductPrise();
//		productDetailsPage.clickOnAddToCartButton();
//	}
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
		driver = null ;
		
		System.gc();// Garbage collector
	}
	
}
