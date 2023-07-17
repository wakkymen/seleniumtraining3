package seleniumtraining;


import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

class TestBase {

	  protected static String baseUrl;

	  protected WebDriver driver;
	  
	  @BeforeEach
	  public void setup () {
		  ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File("chrome-win64/chrome.exe")).build();
		  this.driver = new ChromeDriver(service);
	  }
	  
	  @AfterEach
	  public void quit() {
		  if (this.driver != null) {
			  this.driver.quit();
		  }
	  }
}
