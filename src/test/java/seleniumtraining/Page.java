package seleniumtraining;

import org.openqa.selenium.WebDriver;

public abstract class Page {

	  protected WebDriver driver;

	  /*
	   * Constructor injecting the WebDriver interface
	   * 
	   * @param webDriver
	   */
	  public Page(WebDriver driver) {
	    this.driver = driver;
	  }

	  public String getTitle() {
	    return driver.getTitle();
	  }

}
