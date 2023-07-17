package seleniumtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class HomePageTest extends TestBase {

	  private HomePage homepage;
	  

	  @BeforeEach
	  public void initPageObjects() {
		baseUrl = "https://ksiegarniainternetowa.de/";
	    this.homepage = PageFactory.initElements(driver, HomePage.class);
	  }
	  
	  @Test
	  public void testSetLanguageToPolish() {
		  driver.get(baseUrl);
		  this.homepage.setLanguage("Polish");
		  Assertions.assertTrue(this.homepage.getHeader().contains("Tania wysyłka"), "Set language doesnt match language on Page, return sample: "+this.homepage.getHeader());
	  }
	  
	  @Test
	  public void testSetLanguageToGerman() {
		  driver.get(baseUrl);
		  this.homepage.setLanguage("German");
		  Assertions.assertTrue(this.homepage.getHeader().contains("Günstige Versandkosten"), "Set language doesnt match language on Page, return sample: "+this.homepage.getHeader());
	  }
	  
	  @Test
	  public void testSetCurrencyToPolish() {
		  driver.get(baseUrl);
		  this.homepage.setCurrency("Złoty Polski");
		  String price = driver.findElement(By.className("price")).getText();
		  Assertions.assertTrue(price.contains("zł"));
	  }
	  
	  @Test
	  public void testSetCurrencyToGerman() {
		  driver.get(baseUrl);
		  this.homepage.setCurrency("Euro");
		  String price = driver.findElement(By.className("price")).getText();
		  Assertions.assertTrue(price.contains("€"));
	  }
	}
