package seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Page {

	@FindBy(how = How.TAG_NAME, using = "h1")
	  @CacheLookup
	  public WebElement header;
	  
	  protected boolean isLogged;
		
	  	private By currencyBy = By.cssSelector("#customerCurrency option[selected=selected]");
		private By currencyListBy = By.cssSelector("#customerCurrency");
		private By languageBy = By.cssSelector(".language-list img.selected");
		private By languageListBy = By.cssSelector(".language-list");

	  public HomePage(WebDriver webDriver) {
	    super(webDriver);
	  }

	  public String getCurrency() {
			return this.driver.findElement(currencyBy).getText();
		}
		
		public String getLanguage() {
			return this.driver.findElement(languageBy).getAttribute("title");
		}

		
		/**
		 * only Polish or German are accepted
		 */
		public HomePage setLanguage(String language) {
			this.driver.findElement(languageListBy).findElement(By.cssSelector("a[title='"+language+"']")).click();
			return this;
		}

		/**
		 * only Polski Złoty or Euro are accepted
		 */
		public HomePage setCurrency(String currency) {
			Select currencySelect = new Select(this.driver.findElement(currencyListBy));
			currencySelect.selectByVisibleText(currency);
			return this;
		}
}
