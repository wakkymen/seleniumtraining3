package seleniumtraining;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

class HomePageTest extends TestBase {

	  private HomePage homepage;
	  

	  @Before
	  public void initPageObjects() {
		baseUrl = "https://ksiegarniainternetowa.de/";
	    this.homepage = PageFactory.initElements(driver, HomePage.class);
	  }

	  @Test
	  public void testHomePageHasAHeader() {
	    driver.get(baseUrl);
	    Assert.assertFalse("".equals(homepage.header.getText()));
	  }
	  
	  @Test
	  public void testSetLanguageToPolish() {
		  driver.get(baseUrl);
		  this.homepage.setLanguage("Polish");
		  Assert.assertTrue("Set language doesnt match language on Page", this.languageMatch()=="Polish");
	  }
	  
	  private String languageMatch() {
		  switch(this.homepage.header.getText()) {
		  case "Tania wysyłka do Niemiec od 1€ do 4€!":
			  return "Polish";
		  case "Günstige Versandkosten in Deutschland ab 1€ bis 4€!":
			  return "German";
			 default:
				 return "";
		  }
	  }

	@Test
	  public void testSetLanguageToGerman() {
		driver.get(baseUrl);
		  this.homepage.setLanguage("German");
		  Assert.assertTrue("Set language doesnt match language on Page", this.languageMatch()=="German");
	  }
	  
	  @Test
	  public void testSetCurrencyToPolish() {
		  this.homepage.setCurrency("Polski Złoty");
		  String price = driver.findElement(By.className("price")).getText();
		  Assert.assertTrue(price.contains("zł"));
	  }
	  
	  @Test
	  public void testSetCurrencyToGerman() {
		  this.homepage.setCurrency("Euro");
		  String price = driver.findElement(By.className("price")).getText();
		  Assert.assertTrue(price.contains("€"));
	  }
	}
