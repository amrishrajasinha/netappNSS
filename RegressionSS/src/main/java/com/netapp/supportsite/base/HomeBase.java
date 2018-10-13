package com.netapp.supportsite.base;

/**
 * Class : HomeBase
 * @author : UST Global
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class HomeBase extends Base 
{
	/********************************************************************************************************************
	 * Method : ClickSubmenu
	 * Description: To move to the main menu and click the submenu
	 * Author: Tony George
	 * Date: Feb-09-2017
	 * Modified By:Sreejith
	 * Date:Feb-10-2017
	 * Modified By:Rajmohan
	 * Date:Feb-27-2017
	 * Description: modified Xpath and element location strategy
	 * Modified By:Sreejith
	 * Date:Mar-28-2017
	 * Description: Added java script executor for clicking the submenu
	 ********************************************************************************************************************/
	public void hoverAndClickSubmenu(String MainMenu,String SubMenu)
	{
		waitForPageReady();
		String mainMenuLocator= setXpath("Menu_Link",MainMenu);
		waitForElement(By.xpath(mainMenuLocator));
		WebElement element  =getDriver().findElement(By.xpath(mainMenuLocator));
		// Code for mousehover - Commenting as user to click now and not mousehover
		//String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		//((JavascriptExecutor) getDriver()).executeScript(mouseOverScript,element);
		click(By.xpath(mainMenuLocator));
		By subMenuLink = By.linkText(TestDataManage.getData(SubMenu));
		//String subMenuLocator= setXpath("Menu_Link",SubMenu);
		//	if(isDisplayedWait(By.xpath(subMenuLocator))){
		if(isDisplayedWait(subMenuLink)){
			//	pause(4000);
			click(subMenuLink);
			/*WebElement element1 =  getDriver().findElement(By.xpath(subMenuLocator));
			JavascriptExecutor executor = (JavascriptExecutor)getDriver();
			executor.executeScript("arguments[0].click();", element1);
			getDetailedReport().WriteLog(Status.PASS, "Click Element: "+subMenuLocator+". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());*/
		}	
		waitForPageReady();
	}


	/********************************************************************************************************************
	 * Method : ClickSubmenu
	 * Description: To move to the main menu and click the submenu
	 * Author: Tony George
	 * Date: Feb-09-2017
	 * Modified By:Sreejith
	 * Date:Feb-10-2017
	 * Description: modified Xpath and element location strategy
	 ********************************************************************************************************************/
	public void clickMyProfile(String MainMenuLocator,String SubMenu)
	{
		click(MainMenuLocator);
		//Actions action = new Actions(getDriver());
		/*	WebElement element  =getDriver().findElement(TestDataManage.getObjectProperty(MainMenuLocator));
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) getDriver()).executeScript(mouseOverScript,element);
		 */
		//action.moveToElement(element).build().perform();
		//pause(3000);
		//String submenu="//*[text()='"+SubMenu+"']";
		By subMenuLink = By.linkText(SubMenu);
		if(isDisplayedWait(subMenuLink)){
			//if(isDisplayedWait(By.xpath(submenu))){
			click(subMenuLink);
			//getDriver().findElement(By.xpath(submenu)).click();
			//getDetailedReport().WriteLog(Status.PASS, "Click Element: "+submenu+". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());
			/*WebElement element2  =getDriver().findElement(By.xpath(submenu));
		action.moveToElement(element2).build().perform();
		element2.click();*/
		}	

		waitForPageReady();
	}
	/********************************************************************************************************************
	 * Method : navigateProfilePage
	 * Description: To navigate to profile page
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void navigateProfilePage()

	{

		clickMyProfile("ClickUserProfile_Link", "My Profile");

	}


	/********************************************************************************************************************
	 * Method : navigateProfilePage
	 * Description: To navigate to profile page
	 * Author:Sreejith
	 * Date: Feb-12-2017
	 ********************************************************************************************************************/
	public void validatesubmenu()

	{
		hoverAndClickSubmenu("MainMenu_product","SubMenu_Contracts");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("ActualContractTextpreset"), TestDataManage.getData("SubMenu_Contracts"));

		hoverAndClickSubmenu("MainMenu_product","Submenu_Sites");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("ActualSiteTextpresent"), TestDataManage.getData("Submenu_Sites"));

		hoverAndClickSubmenu("MainMenu_product","Submenu_SoftwareLicences");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("ActualSoftwarelicencesTextpresent"), TestDataManage.getData("Submenu_SoftwareLicences"));




	}


	/********************************************************************************************************************
	 * Method : navigateToFeedBackPage
	 * Description: To navigate to Feedback page
	 * Author: Alfred Dcruz
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void navigateToFeedBackPage()

	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("FeedBack_Lnk"));
		click(TestDataManage.getObjectProperty("FeedBack_Lnk"));

	}


	/********************************************************************************************************************
	 * Method : verifyMenuTab
	 * Description: To navigate to submenu  page
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 * @return 
	 ********************************************************************************************************************/
	public void  verifySubMenu()

	{
		waitForElement(TestDataManage.getObjectProperty("CaseAndParts_Text"));
		click("CaseAndParts_Text");
		String ActualText=getDriver().findElement(TestDataManage.getObjectProperty("Submenu_text")).getText();
		System.out.println(ActualText);

		String ExpectedText = TestDataManage.getData("Submenu");
		System.out.println(ExpectedText);

		if(ActualText.equalsIgnoreCase(ExpectedText))

			getDetailedReport().WriteLog(Status.FAIL, "Field Details: verfying  view case text not present: "+ExpectedText+ ". Expected Button/Link  click", "Actual text is  present .", getDriver());
		else
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: verfying  view Case text not present: "+ExpectedText+ ". Expected Button/Link  click", "Actual text is not present .", getDriver());

		}
	}

	/********************************************************************************************************************
	 * Method : verifyMainMenuTabNotPresent
	 * Description: To verify Menu tab not present
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void verifyMainMenuTabNotPresent()

	{

		//	verifyText(By.xpath(menu), TestDataManage.getData("MainMenu"));
		String ActualmainText=getDriver().findElement(TestDataManage.getObjectProperty("CaseAndParts_Text")).getText();
		System.out.println(ActualmainText);
		String ExpectedText = TestDataManage.getData("MainMenu");
		System.out.println(ExpectedText);

		if(ActualmainText.equalsIgnoreCase(ExpectedText))

			getDetailedReport().WriteLog(Status.FAIL, "Field Details: verfying  Case and parts menu  text not present: "+ExpectedText+ ". Expected Button/Link  click", "Actual text is  present .", getDriver());
		else
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: verfying   Case and parts menu  text not present: "+ExpectedText+ ". Expected Button/Link  click", "Actual text is not present .", getDriver());

		}

	}
	/********************************************************************************************************************
	 * Method : validateMenuTab
	 * Description: To Validate Menu Tab
	 * Author: Harish
	 * Date: Feb-23-2017
	 ********************************************************************************************************************/
	public void validateMenueTab()

	{
		waitForPageLoad();
		String elementLocator = "//*[text()='%s']";
		String menu=TestDataManage.getData("MainMenu");
		menu=menu.trim();
		menu = String.format(elementLocator, menu);
		if(!isElementPresent(By.xpath(menu))){
			getDetailedReport().WriteLog(Status.PASS, "Menu Field is Not Displayed: "+menu+ ". Expected Menu Should Not Display", "Menu Not Displayed  .", getDriver());
		}else {
			getDetailedReport().WriteLog(Status.FAIL, "Menu Field is Displayed: "+menu+ ". Expected Menu Should Not Display", " But Menu is Displayed  .", getDriver());		
		}
	}	


	/********************************************************************************************************************
	 * Method : VerifyGlobalSearchFunctionality
	 * Description: To verify the global search Functionality
	 * Author: Tony George
	 * Date: Mar-07-2017
	 ********************************************************************************************************************/
	public void verifyGlobalSearchFunctionality()
	{
		//SwitchToFrameByName("srchIframe");
		WebElement e = getElement(By.xpath("//iframe[@class='sasrchIframe srchIframe']"));
		getDriver().switchTo().frame(e);
		waitForElement(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"));
		verifyElementEnabled("GlobalSearch_Icon");
		//verifyPropertyContains(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"), "placeholder", "I need support on...");
		//verifyValuePresent(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"), "I need support on...");
		click(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"));
		verifyValuePresent(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"), "");
		type(TestDataManage.getObjectProperty("GlobalSearch_Txtbox"), TestDataManage.getData("SearchKeyword"));
		getElement(TestDataManage.getObjectProperty("GlobalSearch_Txtbox")).sendKeys(Keys.ENTER);
		//click("GlobalSearch_Icon");
		/*if(isElementPresent(By.xpath("//h1[text()='Not Found']"))){

		}*/
		waitForElement(TestDataManage.getObjectProperty("DefaultSearchResults_Header"));
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("DefaultSearchResults_Header")))
		{
			getDetailedReport().WriteLog(Status.PASS, "The search results should be displayed after searching for value", "The search results is displayed after searching for value : "+TestDataManage.getData("SearchKeyword"), getDriver());	
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "The search results should be displayed after searching for value", "The search results is not displayed after searching for value : "+TestDataManage.getData("SearchKeyword"), getDriver());	
		}
		verifyContainsText(TestDataManage.getObjectProperty("Results_Header"), TestDataManage.getData("SearchKeyword"));
	}	

	/********************************************************************************************************************
	 * Method : ClickMainMenuLink
	 * Description: To click on the main menu link
	 * Author: Tony George
	 * Date: Mar-08-2017
	 ********************************************************************************************************************/
	public void clickMainMenuLink()
	{
		waitForPageLoad();
		String menu = setXpath("Menu_Link", "MainMenu");
		By element=By.xpath(menu);
		waitForElement(element);
		click(element);

	}	

	/********************************************************************************************************************
	 * Method : VerifyHeaderNetappLogo
	 * Description: To verify the netapp logo is present in pages
	 * Author: Tony George
	 * Date: Mar-08-2017
	 ********************************************************************************************************************/
	public void verifyHeaderNetappLogo_LoggedInUser()
	{
		String getMenus = TestDataManage.getData("MenuList").trim();
		String[] MenuList = getMenus.split("[|]");
		for(int i=0;i<MenuList.length;i++)
		{
			String[] Submenu = MenuList[i].split("[,]");
			String mainMenuLocator = String.format(TestDataManage.getObjectValue("Menu_Link","XPATH"), Submenu[0].trim());
			waitForElement(By.xpath(mainMenuLocator));
			click(By.xpath(mainMenuLocator));
			By subMenuLink = By.linkText(Submenu[1]);
			if(isDisplayedWait(subMenuLink)){
				click(subMenuLink);
				/*}	

				// Commenting as the Supportsite UI has changed - Headers changed
			waitForElement(element);

			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) getDriver()).executeScript(mouseOverScript,getDriver().findElement(By.xpath("//*[text()='"+Submenu[0]+"']")));

			By Subelement=By.xpath("//*[text()='"+Submenu[1]+"']");
			waitForElement(Subelement);
			if(isDisplayedWait(Subelement))
			{
				getDriver().findElement(Subelement).click();
				 */				waitForElement(TestDataManage.getObjectProperty("NetappHeader_Logo"));
				 if(isElementPresent("NetappHeader_Logo"))
				 {
					 getDetailedReport().WriteLog(Status.PASS, "Expected:The Netapp logo should be present in the "+Submenu[1]+" page", "Actual:The Netapp logo is present in the "+Submenu[1]+" page", getDriver());
				 }
				 else
				 {
					 getDetailedReport().WriteLog(Status.FAIL, "Expected:The Netapp logo should be present in the "+Submenu[1]+" page", "Actual:The Netapp logo is not present in the "+Submenu[1]+" page", getDriver());
				 }
				 click("NetappHeader_Logo");
				 String NavigatedURL = getDriver().getCurrentUrl();
				 if(NavigatedURL.contains("home/CssDashboard"))
				 {
					 getDetailedReport().WriteLog(Status.PASS, "Expected:Should navigate to the home page when clicking the netapp logo from "+MenuList[i]+" page", "Actual:Navigated to the home page after clicking on the Netapp logo from "+MenuList[i]+" page", getDriver());	
				 }
				 else
				 {
					 getDetailedReport().WriteLog(Status.FAIL, "Expected:Should navigate to the home page when clicking the netapp logo from "+MenuList[i]+" page", "Actual:Did not navigate to the home page after clicking the Netapp logo from "+MenuList[i]+" page", getDriver());
				 }

				 /*waitForElement(TestDataManage.getObjectProperty("RecentCase_Header"));
				if(isElementPresent("RecentCase_Header"))
				{
					getDetailedReport().WriteLog(Status.PASS, "Expected:Should navigate to the home page when clicking the netapp logo from "+Submenu[1]+" page", "Actual:Navigated to the home page after clicking on the Netapp logo from "+Submenu[1]+" page", getDriver());
				}
				else
				{
					getDetailedReport().WriteLog(Status.FAIL, "Expected:Should navigate to the home page when clicking the netapp logo from "+Submenu[1]+" page", "Actual:Did not navigate to the home page after clicking the Netapp logo from "+Submenu[1]+" page", getDriver());
				}
				  */

			}

		}	

	}

	/********************************************************************************************************************
	 * Method : verifySupportImage_LoggedInUser
	 * Description: To verify the support image in all pages and the click is not happening for the support image
	 * Author: Tony George
	 * Date: Mar-08-2017
	 ********************************************************************************************************************/
	public void verifySupportImage_LoggedInUser()
	{
		String getMenus = TestDataManage.getData("MenuList").trim();
		String[] MenuList = getMenus.split("[|]");
		for(int i=0;i<MenuList.length;i++)
		{
			String[] Submenu = MenuList[i].split("[,]");

			String mainMenuLocator = String.format(TestDataManage.getObjectValue("Menu_Link","XPATH"), Submenu[0].trim());
			waitForElement(By.xpath(mainMenuLocator));
			click(By.xpath(mainMenuLocator));
			By subMenuLink = By.linkText(Submenu[1]);
			if(isDisplayedWait(subMenuLink)){
				click(subMenuLink);


				// Commenting as the Supportsite UI has changed - Headers changed 

				/*	By element=By.xpath("//*[text()='"+Submenu[0]+"']");
			waitForElement(element);

			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) getDriver()).executeScript(mouseOverScript,getDriver().findElement(By.xpath("//*[text()='"+Submenu[0]+"']")));

			By Subelement=By.xpath("//*[text()='"+Submenu[1]+"']");
			waitForElement(Subelement);
			if(isDisplayedWait(Subelement))
			{
				getDriver().findElement(Subelement).click();
				 */	waitForElement(TestDataManage.getObjectProperty("SupportImage_Header"));
				 if(isElementPresent("SupportImage_Header"))
				 {
					 getDetailedReport().WriteLog(Status.PASS, "Expected:The Support Image should be present in the "+Submenu[1]+" page", "Actual:The Support Image is present in the "+Submenu[1]+" page", getDriver());
				 }
				 else
				 {
					 getDetailedReport().WriteLog(Status.FAIL, "Expected:The Support Image should be present in the "+Submenu[1]+" page", "Actual:The Support Image is not present in the "+Submenu[1]+" page", getDriver());
				 }
				 String CurrentUrl=getDriver().getCurrentUrl();
				 click("SupportImage_Header");
				 String AfterClickUrl=getDriver().getCurrentUrl();
				 if(CurrentUrl.equalsIgnoreCase(AfterClickUrl))
				 {
					 getDetailedReport().WriteLog(Status.PASS, "Expected:Click should not happen for the support image from the "+Submenu[1]+" page", "Actual:Click didn't happen for the support image from the "+Submenu[1]+" page as it didn't get navigated from the current url "+CurrentUrl+" URL even after the click", getDriver());	
				 }
				 else
				 {
					 getDetailedReport().WriteLog(Status.FAIL, "Expected:Click should not happen for the support image from the "+Submenu[1]+" page", "Actual:Click happened for the support image from the "+Submenu[1]+" page as it naviagated to "+AfterClickUrl+" URL after click ", getDriver());	
				 }



			}

		}	

	}

	/********************************************************************************************************************
	 * Method : verifyHeaderNetappLogo_NotLoggedIn
	 * Description: To verify the logo 
	 * Author: Tony George
	 * Date: Mar-08-2017
	 ********************************************************************************************************************/
	public void verifyHeaderNetappLogo_NotLoggedIn()
	{
		waitForPageLoad();
		String getMenus = TestDataManage.getData("MainMenuList").trim();
		String[] MenuList = getMenus.split("[|]");
		for(int i=0;i<MenuList.length;i++)
		{

			By element=By.xpath("//*[text()='"+MenuList[i]+"']");
			waitForElement(element);
			click(element);
			waitForElement(TestDataManage.getObjectProperty("NetappHeader_Logo"));
			if(isElementPresent("NetappHeader_Logo"))
			{
				getDetailedReport().WriteLog(Status.PASS, "Expected:The Netapp logo should be present in the "+MenuList[i]+" page", "Actual:The Netapp logo is present in the "+MenuList[i]+" page", getDriver());
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Expected:The Netapp logo should be present in the "+MenuList[i]+" page", "Actual:The Netapp logo is not present in the "+MenuList[i]+" page", getDriver());
			}
			click("NetappHeader_Logo");
			waitForPageLoad();
			String NavigatedURL = getDriver().getCurrentUrl();
			if(NavigatedURL.contains("HomePage"))
			{
				getDetailedReport().WriteLog(Status.PASS, "Expected:Should navigate to the home page when clicking the netapp logo from "+MenuList[i]+" page", "Actual:Navigated to the home page after clicking on the Netapp logo from "+MenuList[i]+" page", getDriver());	
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Expected:Should navigate to the home page when clicking the netapp logo from "+MenuList[i]+" page", "Actual:Did not navigate to the home page after clicking the Netapp logo from "+MenuList[i]+" page", getDriver());
			}

		}
		getDriver().navigate().back();
	}


	/********************************************************************************************************************
	 * Method : verifyASECornerColumnHeader
	 * Description: To Validate validate ASE Corner Column Header
	 * Author: Rajmohan Dhanapal
	 * Date: Mar-09-2017
	 ********************************************************************************************************************/
	public void verifyASECornerColumnHeader()
	{
		checkMultipleElementPresent("ASECornerColumnHeader_Field","ASECornerColumnHeader");	
	}

	/********************************************************************************************************************
	 * Method : verifyASECornerIsNotPresent
	 * Description: To Validate validate ASE Corner is not present
	 * Author: Rajmohan Dhanapal
	 * Date: Mar-09-2017
	 ********************************************************************************************************************/
	public void verifyASECornerIsNotPresent()
	{
		verifyElementNotPresent("ASECorner_Text");	
	}

	/********************************************************************************************************************
	 * Method : verifyHeaderSupportImage_NotLoggedIn
	 * Description: To verify the support image in different pages
	 * Author: Tony George
	 * Date: Mar-09-2017
	 ********************************************************************************************************************/
	public void verifyHeaderSupportImage_NotLoggedIn()
	{
		waitForPageLoad();
			
			waitForElement(TestDataManage.getObjectProperty("SupportImage_Header"));
			if(isElementPresent("SupportImage_Header"))
			{
				getDetailedReport().WriteLog(Status.PASS, "Expected:The Support Image should be present in the page", "Actual:The Support Image is present in the page", getDriver());
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Expected:The Support Image should be present in the page", "Actual:The Support Image is not present in the page", getDriver());
			}
			getDriver().navigate().back();
			pause(5000);
	}

	/********************************************************************************************************************
	 * Method : clickMultipleLinksAndVerifyNaviagatedURL
	 * Description: To click on the multiple link and verify the navigated URL
	 * Author: Tony George
	 * Updated : Salba
	 * Date:Oct-11-2017
	 ********************************************************************************************************************/
	public void clickMultipleLinksAndVerifyNaviagatedURL(String link,String URL)
	{
		String getlinks = TestDataManage.getData(link).trim();
		String[] LinkList = getlinks.split("[|]");
        pause(5000);
		String getUrls = TestDataManage.getData(URL).trim();
		String[] UrlList = getUrls.split("[|]");
		int len = LinkList.length;
		By Locator = null;

		for(int i=0;i<LinkList.length;i++)
		{
			String test=LinkList[i];
			if(test.equalsIgnoreCase("Contact Us")){
				pause(10000);
				Locator= By.xpath("//a[text()='"+LinkList[i]+"']");
			}
			else
				pause(5000);
				Locator= By.linkText(test);

			if(isElementPresent(Locator)){
				pause(10000);
				click(Locator);
				pause(5000);
				waitForPageLoad();
				if(i==0)
				{
					pause(5000);
					if(isElementPresent(By.id("cboxClose")))
					{
					click(By.id("cboxClose"));// cookie pop up
					waitForPageLoad();
					}
				}
				pause(5000);
				String NavigatedURL = getDriver().getCurrentUrl();
				if(NavigatedURL.contains(UrlList[i]))
				{
					getDetailedReport().WriteLog(Status.PASS,"Need to navigate to the "+UrlList[i]+" after clicking the "+LinkList[i]+" link" ,"Navigated to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link", getDriver()); 
				}
				else
				{
					getDetailedReport().WriteLog(Status.FAIL,"Need to navigate to the "+UrlList[i]+" after clicking the "+LinkList[i]+" link" ,"Did not Navigate to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link . Instead navigated to "+NavigatedURL, getDriver()); 
				}
				getDriver().navigate().back();
				waitForPageLoad();
			}else
				getDetailedReport().WriteLog(Status.FAIL,"Verifying the link "+LinkList[i]+" " ,"Could not find the "+LinkList[i]+" link", getDriver()); 

		}
	}
















}
