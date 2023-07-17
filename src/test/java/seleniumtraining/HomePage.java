package seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Page {
	  
	protected boolean isLogged;
		
	private By currencyBy = By.cssSelector("#customerCurrency option[selected=selected]");
	private By currencyListBy = By.cssSelector("select#customerCurrency");
	private By languageBy = By.cssSelector(".language-list img.selected");
	private By languageListBy = By.cssSelector(".language-list");
	private By contentHeaderBy = By.cssSelector(".page-body h1 a");
		
	public HomePage(WebDriver webDriver) {
	    super(webDriver);
	}

	public String getCurrency() {
		return this.driver.findElement(currencyBy).getText();
	}
		
	public String getLanguage() {
		return this.driver.findElement(languageBy).getAttribute("title");
	}

	public String getHeader() {
		return this.driver.findElement(contentHeaderBy).getText();
	}
		
	/**
	 * only Polish or German are accepted
	 */
	public HomePage setLanguage(String language) {
		this.driver.findElement(languageListBy).findElement(By.cssSelector("a[title='"+language+"']")).click();
		return this;
	}

	/**
	 * only Złoty Polski or Euro are accepted
	 */
	public HomePage setCurrency(String currency) {
		Select currencySelect = new Select(this.driver.findElement(currencyListBy));
		currencySelect.selectByVisibleText(currency);
		return this;
	}
}
