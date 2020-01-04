package framework.common.ui.interact.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.commons.ui.condition.page.ScrollToBottomPage;
import framework.commons.ui.util.Wait;

/*
 * This abstract class must be extended by every page object."
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-25
 * 
 */
public abstract class PageObject {

	protected WebDriver driver = null;
	protected JavascriptExecutor javaScriptExecutor = null;
	
	/* --- Stores the last error message. --- */
	private String lastErrorMsg = "";
	
	public PageObject( WebDriver driver ) {
		
		this.driver = driver;
		this.javaScriptExecutor = ( JavascriptExecutor ) driver;
	}
	
	/**
	 * Maximizes the browser.
	 */
	public void maximizeBrowser( ) {
	
		/* --- Let's Maximize the browser. --- */
		driver.manage( ).window( ).maximize( );
	}
	
	/**
	 * Scrolls to bottom of page, scrolling between intervals of given seconds
	 * @param interval wait number of seconds between scrolling.
	 * @param timeout the number of seconds
	 */
	public void scrollToBottom( long interval, int timeout ) {
		
		/* --- Let's scroll to the end of the page, just to make sure the element that we are trying to click is viewable. --- */
		if( !Wait.until( driver, new ScrollToBottomPage( interval, false ), timeout ) )
			throw new RuntimeException( "Unable to scroll to bottom of page." );
	}
	
	/**
	 * Returns the WebDriver.
	 * 
	 * Returns the WebDriver
	 * @return the WebDriver
	 */
	public WebDriver getWebDriver( ) {
		
		return driver;
	}
	
	/**
	 * Returns the JavascriptExcutor.
	 * 
	 * @return the JavascriptExecutor
	 */
	public JavascriptExecutor getJavascriptExecutor( ) {
		
		return javaScriptExecutor;
	}
	
	/**
	 * Sets the last error message.
	 * @param msg message to be set.
	 */
	protected void setLastErrorMsg( String msg ) {
		
		this.lastErrorMsg = msg;
	}
	
	/**
	 * Returns the last error encountered
	 * @return
	 */
	public String getLastErrorMsg( ) {
		
		return this.lastErrorMsg;
	}
}
