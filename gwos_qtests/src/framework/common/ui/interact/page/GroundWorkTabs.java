package framework.common.ui.interact.page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.commons.ui.util.Wait;

/**
 * This class handles the interaction with the Tabs."
 * 
 * @author : Sergio A. Hernandez
 * @version : 1.0
 * @since 2019-12-20
 * 
 */
public class GroundWorkTabs extends PageObject {

	private By eventConsoleTabLocator  = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/console']" );
	private By statusTabLocator        = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/status']" );
	private By viewsTabLocator         = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/nagvis']" );
	private By reportsTabLocator       = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/reports']" );
	private By autoDiscoveryTabLocator = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/auto-disc']" );
	private By configurationTabLocator = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/config']" );
	private By businessTabLocator      = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/business-tools']" );
	private By groundworkAdministrationTabLocator = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/groundwork-administration']" );
	private By advancedTabLocator      = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/advanced']" );
	private By resourcesTabLocator     = By.xpath( "//a[@class='TabIcon DefaultPageIcon' and @href='/portal/classic/resources']" );

	/**
	 * Initializes a GroundWorkTabs object that allows the ability to interact with the Tabs.
	 * 
	 * @param driver the WebDriver
	 */
	public GroundWorkTabs( WebDriver driver ) {
		
		super( driver );
	}

	/**
	 * Selects/Clicks the given tabLocator.
	 * 
	 * @param click true to click the tabLocator when found.
	 * @param tabLocator the tagLocator that identifies the Tab Locator to click.
	 * @return the selected/clicked WebElement.
	 */
	private WebElement clickTab( boolean click, By tabLocator ) {
		
		/* --- Wait for the EvenT Console Tab to become clickable. --- */
		WebElement eventConsoleTab = Wait.elementToBeClickable( driver, tabLocator, 5 );
		if( null != eventConsoleTab ) {
		
			try {
			
				if( click ) {
					
					/* --- Let's click the Event Console tab. --- */
					eventConsoleTab.click( );
					
					/* This will force a StaleElementReferenceException exception.
					 * We must then try to find the WebElement again.
					*/
					eventConsoleTab.getText( );
				}
				
				return eventConsoleTab;
				
			} catch ( StaleElementReferenceException sere ) {
				
				/* --- We should then try to gain access to the newly created WebElement, but not click on it. --- */
				return clickTab( false, tabLocator );
			}
		}
		
		/* --- Let's set the last error message. --- */
		setLastErrorMsg( new Object( ) { }.getClass( ).getEnclosingMethod( ).getName( ) + "Unable to find the 'Tab Locator'." );
		
		return null;
	}
	
	/**
	 * Selects/Clicks the "Event Console" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickEventConsoleTab( ) {
		
		return clickTab( true, this.eventConsoleTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Status" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickStatusTab( ) {
		
		return clickTab( true, this.statusTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Views" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickViewsTab( ) {
		
		return clickTab( true, this.viewsTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Reports" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickReportsTab( ) {
		
		return clickTab( true, this.reportsTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Auto Discovery" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickAutoDiscoveryTab( ) {
		
		return clickTab( true, this.autoDiscoveryTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Configuration" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickConfigurationTab( ) {
		
		return clickTab( true, this.configurationTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Business" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickBusinessTab( ) {
		
		return clickTab( true, this.businessTabLocator );
	}
	
	/**
	 * Selects/Clicks the "GroundWork Administration" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickGroundWorkAdministrationTab( ) {
		
		return clickTab( true, this.groundworkAdministrationTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Advanced" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickAdvancedTab( ) {
		
		return clickTab( true, this.advancedTabLocator );
	}
	
	/**
	 * Selects/Clicks the "Resources" Tab.
	 * 
	 * @return the selected/clicked WebElement.
	 */
	public WebElement clickResourcesTab( ) {
		
		return clickTab( true, this.resourcesTabLocator );
	}
}