package framework.factory;

import framework.driver.WebDriverManager;
import framework.driver.FirefoxWebDriverManager;

/*
 * This is an factory class in charge of creating WebDrivers.
 * FirefoxWebDriverManager, ChromeWebDriverManager, and any additional managers.
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-25
 * 
 */
public class WebDriverManagerFactory {

	public static enum DriverType {
	
		FIREFOX, CHROME, SAFARI, IE, OPERA;
	}
	
	/**
	 * Returns a WebDriverManager
	 * @param type given a DriverType, it returns the WebDriverManager
	 * @return the WebDriverManager.
	 */
	public static WebDriverManager createDriverManager( DriverType type ) {
		
		WebDriverManager webDriverManager;
		switch( type ) {
		
			case FIREFOX: {
			
				webDriverManager = new FirefoxWebDriverManager( );
				break;
			}
			
			default: {
				
				webDriverManager = new FirefoxWebDriverManager( );
				break;
			}
		}
		
		return webDriverManager;
	}
}
