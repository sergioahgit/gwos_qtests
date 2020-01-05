package framework.commons.ui.interact.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class handles the interaction with the Login Page."
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-20
 * 
 */
public class LoginPage extends PageObject {

	private By usernameTextBoxLocator = By.xpath( "//input[@name='josso_username']" );
	private By passwordTextBoxLocator = By.xpath( "//input[@name='josso_password']" );
	private By loginButtonLocator     = By.xpath( "//input[@value='Login']" );
	
	/**
	 * Initializes a LoginPage object that allows the ability to interact with the Login Page.
	 * 
	 * @param driver the WebDriver
	 */
	public LoginPage( WebDriver driver, String url ) {
		
		super( driver );
		
		/* --- Let's go to the login page. --- */
		driver.get( /*"http://gwos01.example.com"*/ url );
	}
	
	/**
	 * Allows you to login into the groundwork account with the
	 * provided username/password credentials.
	 * 
	 * @param username the username
	 * @param password the password
	 * @return true if the user was successfully signed in.  Otherwise, false.
	 */
	public boolean login( String username, String password ) {
	
		if( ( null != setUsername( username ) ) && ( null != setPassword( password ) ) )
			if( null != clickLogin( ) )
				return true;
		
		return false;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public WebElement setUsername( String username ) {
		
		/* --- Let's find the username text box. --- */
		WebElement usernameTextBox = driver.findElement( this.usernameTextBoxLocator );
		if( null != usernameTextBox ) {
			
			usernameTextBox.sendKeys( username );
			return usernameTextBox;
		}
		
		/* --- Let's set the last error message. --- */
		setLastErrorMsg( new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ) + "Unable to find the 'username' text box." );
		
		return null;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public WebElement setPassword( String password ) {
		
		/* --- Let's find the username text box. --- */
		WebElement passwordTextBox = driver.findElement( this.passwordTextBoxLocator );
		if( null != passwordTextBox ) {
			
			passwordTextBox.sendKeys( password );
			return passwordTextBox;
		}
		
		/* --- Let's set the last error message. --- */
		setLastErrorMsg( new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ) + "Unable to find the 'password' text box." );
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public WebElement clickLogin( ) {
		
		/* --- Let's find the login button. --- */
		WebElement loginButton = driver.findElement( this.loginButtonLocator );
		if( null != loginButton ) {
			
			loginButton.click( );
			return loginButton;
		}

		/* --- Let's set the last error message. --- */
		setLastErrorMsg( new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ) + "Unable to find the 'login' button." );
		
		return null;
	}
}
