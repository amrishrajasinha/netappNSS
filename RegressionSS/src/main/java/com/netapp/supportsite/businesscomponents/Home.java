package com.netapp.supportsite.businesscomponents;
/**
 * Class : Home
 * @author : UST Global
 */

import org.junit.Test;
import com.netapp.supportsite.base.HomeBase;

public class Home extends HomeBase
{


	/********************************************************************************************************************
	* Method : clickSubmenu
	* Description: To click on the submenu
	* Author: Tony George
	* Date: February-9-2017
	********************************************************************************************************************/
	@Test
	public void clickSubmenu()
	{
		waitForPageReady();
		hoverAndClickSubmenu("MainMenu","Submenu");
		waitForPageReady();
		
	}
	
	/********************************************************************************************************************
	* Method : clickSubmenu
	* Description: To click on the submenu
	* Author: Tony George
	* Date: February-9-2017
	********************************************************************************************************************/
	@Test
	public void clickFeedback()
	{
		waitForPageReady();
		navigateToFeedBackPage();
		
	}
	
	
	/********************************************************************************************************************
	* Method : clickSubmenu
	* Description: To  validate product submenu
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/
	@Test
	public void validateProductSubmenu()
	{
		waitForPageReady();
		validatesubmenu();
		
		
		
	}
	

	
	/********************************************************************************************************************
	* Method : verifyMenuText
	* Description: validate the unavailability of cases and parts tab
	* Author: sreejith
	* Date: February-9-2017
	********************************************************************************************************************/
	@Test
	public void verifyMenuText()
	{
		waitForPageReady();
		verifyMainMenuTabNotPresent();
		
	}
	
	/********************************************************************************************************************
	* Method : verifyMenuText
	* Description: To click on the submenu and validate the presence
	* Author: sreejith
	* Date: February-21-2017
	********************************************************************************************************************/
	@Test
	public void verifySubMenuText()
	{
		waitForPageReady();
		
		verifySubMenu();
		
	}
	
	/********************************************************************************************************************
	 * Method : validateMenueTab
	* Description: To Validate Menue Tab
	* Author: Harish
	* Date: Feb-23-2017
	********************************************************************************************************************/
	@Test
	public void validateMenueTab()
	{
		waitForPageReady();
		super.validateMenueTab();
		
	}
	/********************************************************************************************************************
	 * Method : VerifyFooterLinksNavigation
	* Description: To verify the navigation of the footer links
	* Author: Tony George
	* Date: Mar-03-2017
	********************************************************************************************************************/
	@Test
	public void verifyFooterLinksNavigation()
	{
		clickMultipleLinksAndVerifyNaviagatedURL("ListOfLinks","URLlist");
		clickLinkAndVerifyNaviagatedURL("RSS_Link","RSSURL");
		
	}

	
	/********************************************************************************************************************
	 * Method : VerifyFooterLinksNavigation
	* Description: To verify the navigation of the footer links
	* Author: Tony George
	* Date: Mar-03-2017
	********************************************************************************************************************/
	@Test
	public void verifyGlobalSearchHeader()
	{
		
		verifyGlobalSearchFunctionality();
	}

	/********************************************************************************************************************
	 * Method : clickMainMenu
	* Description: To click on the main menu links
	* Author: Tony George
	* Date: Mar-03-2017
	********************************************************************************************************************/
	@Test
	public void clickMainMenu()
	{
		
		clickMainMenuLink();
	}

	/********************************************************************************************************************
	 * Method : verifyNetappLogoInDifferentPages_LoggedInUser
	* Description: To verify netapp logo is present in different pages for logged in user
	* Author: Tony George
	* Date: Mar-08-2017
	********************************************************************************************************************/
	@Test
	public void verifyNetappLogoInDifferentPages_LoggedInUser()
	{
		
		verifyHeaderNetappLogo_LoggedInUser();
	}
	/********************************************************************************************************************
	 * Method : verifyNetappLogoInDifferentPages_LoggedInUser
	* Description: To verify netapp logo is present in different pages for not logged in user
	* Author: Tony George
	* Date: Mar-08-2017
	********************************************************************************************************************/
	@Test
	public void verifyNetappLogoInDifferentPages_NotLoggedIn()
	{
		
		verifyHeaderNetappLogo_NotLoggedIn();
	}


	/********************************************************************************************************************
	 * Method : verifySupportImageInDifferentPages_LoggedInUser
	* Description: To verify support image is present in different pages for logged in user
	* Author: Tony George
	* Date: Mar-09-2017
	********************************************************************************************************************/
	@Test
	public void verifySupportImageInDifferentPages_LoggedInUser()
	{
		
		verifySupportImage_LoggedInUser();
	}
	
	/********************************************************************************************************************
	* Method : verifySupportImageInDifferentPages_LoggedInUser
	* Description: To verify support image is present in different pages for not logged in uder
	* Author: Tony George
	* Date: Mar-09-2017
	********************************************************************************************************************/
	@Test
	public void verifySupportImageInDifferentPages_NotLoggedIn()
	{
		
		verifyHeaderSupportImage_NotLoggedIn();
	}
	
	/********************************************************************************************************************
	* Method : validateASECornerColumnHeader
	* Description: To Validate validate ASE Corner Column Header
	* Author: Rajmohan Dhanapal
	* Date: Mar-09-2017
	********************************************************************************************************************/
	public void validateASECornerColumnHeader()
	{
		verifyASECornerColumnHeader();
	}
	
	/********************************************************************************************************************
	* Method : validateASECornerIsNotPresent
	* Description: To Validate validate ASE Corner is not present
	* Author: Rajmohan Dhanapal
	* Date: Mar-09-2017
	********************************************************************************************************************/
	public void validateASECornerIsNotPresent()
	{
		verifyASECornerIsNotPresent();	
	}

}
