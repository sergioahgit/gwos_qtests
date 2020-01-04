package framework.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * This class defines a Firefox Driver Manager responsible for managing the
 * options for the Firefox GECKO driver.
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-25
 * 
 */
public class FirefoxWebDriverManager extends WebDriverManager {

	@Override
	protected void createWebDriver() {
		
		//System.setProperty( "webdriver.gecko.driver", "C:\\geckodriver-v0.26.0-win64\\geckodriver.exe" );
		
		System.setProperty( "webdriver.gecko.driver", "/opt/geckodriver-v0.26.0-linux64/geckodriver" );
		
		/* --- Let's initialize the browser driver. --- */
		driver = new FirefoxDriver( );
		System.out.println( "Creating WebDriver" );
	}
}
