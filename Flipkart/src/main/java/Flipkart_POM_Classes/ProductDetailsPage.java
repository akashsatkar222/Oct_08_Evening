package Flipkart_POM_Classes;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	@FindBy (xpath = "//button[text()='Add to cart']")
	private WebElement addToCart ;
	
	@FindBy (xpath = "//button[text()='Buy Now']")
	private WebElement buyNow ;
	
	@FindBy (xpath = "//span[@class='B_NuCI']")
	private WebElement productTitle ;
	
	@FindBy (xpath = "//div[@class='_30jeq3 _16Jk6d']")
	private WebElement productPrise ;
	
	@FindBy (xpath = "(//li[@class='_20Gt85 _1Y_A6W'])[4]")
	private WebElement productView ;
	
	ArrayList<String> addr;
	String txt2,rup2;
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		ArrayList<String> addr = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
	}
	
	public void clickOnAddToCartButton() {
		addToCart.click();
	}
	public void clickOnBuyNowButton() {
		buyNow.click();
	}
	public void getProductTittle() {
		txt2=productTitle.getText();
		System.out.println(txt2);
	}
	public void getProductPrise() {
		rup2=productPrise.getText();
		System.out.println(rup2);
	}
	public void clickOnProductView() {
		productView.click();
	}

}
