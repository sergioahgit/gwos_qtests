package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.common.ui.interact.page.LoginPage;
import framework.common.ui.interact.page.GroundWorkTabs;
import framework.commons.util.Time;
import framework.driver.WebDriverManager;
import framework.factory.WebDriverManagerFactory;
import framework.factory.WebDriverManagerFactory.DriverType;

/*
 * The GroundWorkTabTest JUnit5 Test - Tests the each tab to make sure they are clickable.
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-25
 * 
 */
class GroundWorkTabsTest {

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
		
		/* --- Let's click the event console tab. --- */
		WebElement eventConsoleTab = gwtabs.clickEventConsoleTab( );
		if( null == eventConsoleTab )
			throw new RuntimeException( gwtabs.getLastErrorMsg( ) );	
		
		/* --- Verify the "Event Console" is what we clicked. --- */
		if( !eventConsoleTab.getText( ).toLowerCase( ).contains( "event console" ) )
			throw new RuntimeException( "Test Failed : Unable to find the 'Event Console' Tab - Found: " + eventConsoleTab.getText( ).toLowerCase( ) );
		
		/* --- Let's click the status tab. --- */
		WebElement statusTab = gwtabs.clickStatusTab( );
		if( null == statusTab )
			throw new RuntimeException( gwtabs.getLastErrorMsg( ) );	
		
		/* --- Verify the "Status" is what we clicked. --- */
		if( !statusTab.getText( ).toLowerCase( ).contains( "status" ) )
			throw new RuntimeException( "Test Failed : Unable to find the 'Status' Tab - Found: " + statusTab.getText( ).toLowerCase( ) );
		
		/* --- Let's click the views tab. --- */
		WebElement viewsTab = gwtabs.clickViewsTab( );
		if( null == viewsTab )
			throw new RuntimeException( gwtabs.getLastErrorMsg( ) );	
		
		/* --- Verify the "Views" is what we clicked. --- */
		if( !viewsTab.getText( ).toLowerCase( ).contains( "views" ) )
			throw new RuntimeException( "Test Failed : Unable to find the 'Views' Tab - Found: " + viewsTab.getText( ).toLowerCase( ) );
		
		/* --- Let's click the reports tab. --- */
		WebElement reportsTab = gwtabs.clickReportsTab( );
		if( null == reportsTab )
			throw new RuntimeException( gwtabs.getLastErrorMsg( ) );	
		
		/* --- Verify the "Reports" is what we clicked. --- */
		if( !reportsTab.getText( ).toLowerCase( ).contains( "reports" ) )
			throw new RuntimeException( "Test Failed : Unable to find the 'Reports' Tab - Found: " + reportsTab.getText( ).toLowerCase( ) );
		
		/* --- All more tabs as needed. --- */
		
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