package seleniumtraining;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestBase {

	  protected static String baseUrl;

	  protected WebDriver driver;
	  
	  @BeforeEach
	  public void setup () {
		  this.driver = new ChromeDriver();
	  }
	  
	  @AfterEach
	  public void quit() {
		  if (this.driver != null) {
			  this.driver.quit();
		  }
	  }
}
