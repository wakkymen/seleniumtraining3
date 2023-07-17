package seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends Page {
	
private WebElement contents;
	
	public WishlistPage(WebDriver driver) {
		super(driver);
		this.contents = this.driver.findElement(By.cssSelector(".cart"));
	}
	
	public String getTitle() {
		return this.driver.findElement(By.cssSelector(".page .page-title")).getText();
	}
	
	public WebElement getContents() {
		return contents;
	}
	
	public WishlistPage removeFromList(String attributeSelector) {
		WebElement e = contents.findElement(By.cssSelector("tr.cart-item-row["+attributeSelector+"]"));
		e.findElement(By.cssSelector("td.remove-from-cart")).click();
		this.driver.findElement(By.cssSelector("input.update-wishlist-button"));
		return this;
	}
	
	public WishlistPage addToCart (String attributeSelector) {
		WebElement e = contents.findElement(By.cssSelector("tr.cart-item-row["+attributeSelector+"]"));
		e.findElement(By.cssSelector("td.add-to-cart")).click();
		this.driver.findElement(By.cssSelector("input.update-wishlist-button"));
		return this;
	}


}
