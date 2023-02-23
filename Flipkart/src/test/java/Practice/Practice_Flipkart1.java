package Practice;

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

public class Practice_Flipkart1 { //Add to cart

	WebDriver driver;
	FlipkartHomePage flipkartHomePage;
	SearchedResultShow searchedResultShow;
	ProductDetailsPage productDetailsPage;
	@Parameters({"browser"})
	@BeforeTest
	public void launchTheBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		if(browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}
		
		
	}
	@BeforeClass
	public void createPOMObject() {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		flipkartHomePage=new FlipkartHomePage(driver);
		flipkartHomePage.clickOnExit();
		
	}
	@BeforeMethod
	public void searchTheProduct() {
		flipkartHomePage.searchForProductsBrandAndMore("oppo mobiles");
		flipkartHomePage.clickOnSearchBox();
//		SearchedResultShow searchedResultShow = new SearchedResultShow(driver);
//		searchedResultShow.getFristResultPrise();
//		searchedResultShow.getFristResultText();
//		searchedResultShow.clickOnFirstResult();
	}
	
	@Test
	public void viewProductDetails1() {
		searchedResultShow = new SearchedResultShow(driver);
		searchedResultShow.getFristResultPrise();
		searchedResultShow.getFristResultText();
		searchedResultShow.clickOnFirstResult();
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.getProductPrise();
		productDetailsPage.getProductTittle();
		productDetailsPage.clickOnAddToCartButton();
	}

	
	@AfterMethod
	public void closeTheBrowserTab() {
		driver.close();
	}
	
	@AfterClass
	public void closeTheBrowser() {
		driver.quit();
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
}
