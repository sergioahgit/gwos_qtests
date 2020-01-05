package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.commons.ui.interact.page.GroundWorkTabs;
import framework.commons.ui.interact.page.LoginPage;
import framework.commons.util.Time;
import framework.driver.WebDriverManager;
import framework.factory.WebDriverManagerFactory;
import framework.factory.WebDriverManagerFactory.DriverType;

/*
 * The LoginTest JUnit5 Test - Tests the login page credentials.
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-25
 * 
 */
class LoginTest {

	private static WebDriverManager driverManager;
	private static WebDriver driver;
	
	/* Denotes that the annotated method should be executed before all @Test, @RepeatedTest, @ParameterizedTest, or
	 * @TestFactory method in the current class; analogous to JUnit 4's @BeforeClass 
	 */
	@BeforeAll
	public static void openBrowser( ) {
	
		/* --- Let's get the DriverManager --- */
		driverManager = WebDriverManagerFactory.createDriverManager( DriverType.FIREFOX );
		
		/* --- Let's initialize the browser driver. --- */
		driver = driverManager.getWebDriver( );
	}
	
	@Test
	public void Test( ) {
		
		System.out.println( "Starting Test Code Function : " + new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ) );
		
		/* --- Let's Instantiate the Login Page to interact with it. --- */
		LoginPage loginPage = new LoginPage( driver, "http://gwos01.example.com" );
		
		/* --- Let's wait for 5 seconds before maximizing the browser. ---*/
		Time.waitFor( 5000 );
		
		/* --- Let's Maximize the browser on the main page. --- */
		loginPage.maximizeBrowser( );
				
		/* Let's scroll to the end of the page.
		 * Waiting 3 seconds before each scroll, with a timeout for a full scroll to bottom of 1 minute.
		*/
		loginPage.scrollToBottom( 3, 60 );
		
		/* --- Let's try to login. --- */
		if( !loginPage.login( "admin",  "admin" ) )
			throw new RuntimeException( loginPage.getLastErrorMsg( ) );	
		
		/* --- Let's wait for 5 seconds before maximizing the browser. ---*/
		Time.waitFor( 5000 );
		
		/* --- Let's now verify that we see the sign out option. --- */
		GroundWorkTabs gwtabs = new GroundWorkTabs( driver );
		
		/* --- Let's click the console tab. --- */
		WebElement eventConsole = gwtabs.clickEventConsoleTab( );
		if( null == eventConsole )
			throw new RuntimeException( loginPage.getLastErrorMsg( ) );	
		
		if( !eventConsole.getText( ).toLowerCase( ).contains( "event console" ) )
			throw new RuntimeException( "Test Failed : Unable to find the Event Console Tab - " + eventConsole.getText( ).toLowerCase( ) );
		
		/* --- Let's wait for 5 seconds before maximizing the browser. ---*/
		Time.waitFor( 5000 );
		
		/*--- At this point we should see the results. --- */
		System.out.println( "Ending Test Code Function : " + new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ));
	}
	
	/* Denotes that the annotated method should be executed after all @Test, @RepeatedTest, @ParameterizedTest,
	 * and @TestFactory methods in the current class; analogous to JUnit 4's @AfterClass.
	 */
	@AfterAll
	public static void closeBrowser( ) {
		
		/* --- Let's wait for 7 seconds before closing the browser, so we can see the results. ---*/
		Time.waitFor( 7000 );
		
		/* --- Once we have validated the results, we can then successfully close the browser. ---*/
		driver.quit( ); // Closing the driver once the tests are executed
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}