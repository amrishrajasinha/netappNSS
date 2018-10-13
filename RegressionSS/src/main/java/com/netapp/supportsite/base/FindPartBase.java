package com.netapp.supportsite.base;
/**
 * Class : FindPartBase
 * @author : UST Global
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class FindPartBase extends Base {
	
	
	/********************************************************************************************************************
	* Method : clickOnNewSearchButton
	* Description: TO click on new search Button
	* Author: Alfred Dcruz
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void clickOnNewSearchButton()
	{
		waitForElementTime(TestDataManage.getObjectProperty("NewSearch_Btn"),200);
		waitForElement(TestDataManage.getObjectProperty("NewSearch_Btn"));
		click("NewSearch_Btn");
	}
	/********************************************************************************************************************
	* Method : verifyPartInformationPage
	* Description: TO Verify Part information page.
	* Author: Alfred Dcruz
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void verifyPartInformationPage()
	{
		Boolean MktgPN_Lbl,MfgPN_Lbl,CompIdentifier_Lbl,EndofHW_Lbl,Description_Lbl,Category_Lbl,
		Platform_Lbl,DiskShelfType_Lbl,MinRevOntap_Lbl,MinRevNetCache_Lbl,FirmwareDisk_Lbl,
		SysConfigOut_Lbl,Dependencies_Lbl,AlternateParts_Lbl,WarningNote_Lbl,Notes_Lbl,CustomerOrderable_lbl,
		QualDevONTAP_Lbl;

		waitForPageLoad();
		switchToNewWindow();
		waitForElementTime(TestDataManage.getObjectProperty("MktgPN_Lbl"), 100);
		MktgPN_Lbl = isElementPresent(TestDataManage.getObjectProperty("MktgPN_Lbl"));
		MfgPN_Lbl = isElementPresent(TestDataManage.getObjectProperty("MfgPN_Lbl"));
		CompIdentifier_Lbl = isElementPresent(TestDataManage.getObjectProperty("CompIdentifier_Lbl"));
		EndofHW_Lbl = isElementPresent(TestDataManage.getObjectProperty("EndofHW_Lbl"));
		Description_Lbl = isElementPresent(TestDataManage.getObjectProperty("Description_Lbl"));
		Category_Lbl = isElementPresent(TestDataManage.getObjectProperty("Category_Lbl"));
		Platform_Lbl = isElementPresent(TestDataManage.getObjectProperty("Platform_Lbl"));
		DiskShelfType_Lbl = isElementPresent(TestDataManage.getObjectProperty("DiskShelfType_Lbl"));
		MinRevOntap_Lbl = isElementPresent(TestDataManage.getObjectProperty("MinRevOntap_Lbl"));
		MinRevNetCache_Lbl = isElementPresent(TestDataManage.getObjectProperty("MinRevNetCache_Lbl"));
		FirmwareDisk_Lbl = isElementPresent(TestDataManage.getObjectProperty("FirmwareDisk_Lbl"));
		SysConfigOut_Lbl = isElementPresent(TestDataManage.getObjectProperty("SysConfigOut_Lbl"));
		Dependencies_Lbl = isElementPresent(TestDataManage.getObjectProperty("Dependencies_Lbl"));
		AlternateParts_Lbl = isElementPresent(TestDataManage.getObjectProperty("AlternateParts_Lbl"));
		WarningNote_Lbl = isElementPresent(TestDataManage.getObjectProperty("WarningNote_Lbl"));
		Notes_Lbl = isElementPresent(TestDataManage.getObjectProperty("Notes_Lbl"));
		CustomerOrderable_lbl = isElementPresent(TestDataManage.getObjectProperty("CustomerOrderable_lbl"));
		QualDevONTAP_Lbl = isElementPresent(TestDataManage.getObjectProperty("QualDevONTAP_Lbl"));

		if(MktgPN_Lbl&&MfgPN_Lbl&&CompIdentifier_Lbl&&EndofHW_Lbl&&Description_Lbl&&Category_Lbl&&
				Platform_Lbl&&DiskShelfType_Lbl&&MinRevOntap_Lbl&&MinRevNetCache_Lbl&&FirmwareDisk_Lbl&&
				SysConfigOut_Lbl&&Dependencies_Lbl&&AlternateParts_Lbl&&WarningNote_Lbl&&Notes_Lbl&&CustomerOrderable_lbl&&
				QualDevONTAP_Lbl){
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Part Number information should be displayed", "Part Number information is displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Case invalid. Part Number information should be displayed", "Part Number information is not displayed - FAIL", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : clickFirstPartNumberFromList
	* Description: TO click on first Part number from List
	* Author: Alfred Dcruz
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void clickFirstPartNumberFromList()
	{
		waitForPageLoad();
		waitForElementTime(TestDataManage.getObjectProperty("FirstPartNumberFromList_Lnk"),200);
		waitForElement(TestDataManage.getObjectProperty("FirstPartNumberFromList_Lnk"));
		click("FirstPartNumberFromList_Lnk");

	}
	
	/********************************************************************************************************************
	* Method : browsePartFieldValidation
	* Description: Validate the fields in Browse Parts fields
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartFieldValidation(){
		checkMultipleElementDisplayed("BrowseParts_Field","BrowsePartsFields");
		verifyElementDisplayed("BrowseFindPart1_Button","Search by Part Number");
		verifyElementDisplayed("BrowseFindPart2_Button","Search by 'sysconfig' Output");
		verifyElementDisplayed("BrowseFindPart3_Button","Search by Category");
	}
	
	/********************************************************************************************************************
	* Method : browsePartSearchByPartNumber
	* Description: Search Part number using SearchByPartNumber 
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartSearchByPartNumber1(){
		type(TestDataManage.getObjectProperty("FindByPartNO_Input"), TestDataManage.getData("PartNumber2"));
		click("BrowseFindPart1_Button");
	}

	/********************************************************************************************************************
	* Method : browsePartSearchByPartNumber
	* Description: Search Part number using SearchByPartNumber 
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartSearchByPartNumber(){
		type(TestDataManage.getObjectProperty("FindByPartNO_Input"), TestDataManage.getData("PartNumber"));
		click("BrowseFindPart1_Button");
	}
	
	/********************************************************************************************************************
	* Method : searchByCategoryOnly
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void searchByCategoryOnly()
	{
		waitForPageLoad();
		waitForElementTime(TestDataManage.getObjectProperty("BrowseCategory_Drpdwn"),60);
		selectbyVisibleText(TestDataManage.getObjectProperty("BrowseCategory_Drpdwn"), TestDataManage.getData("Category"));
		click("BrowseFindPart3_Button");
	}
	
	/********************************************************************************************************************
	* Method : searchBySysConfig
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void searchBySysConfigSearch()
	{
		waitForPageLoad();
		waitForElementTime(TestDataManage.getObjectProperty("SysConfigCategory_Drpdwn"),60);
		selectbyVisibleText(TestDataManage.getObjectProperty("SysConfigCategory_Drpdwn"), TestDataManage.getData("Category"));
		type(TestDataManage.getObjectProperty("SysConfigOutput_Text"), TestDataManage.getData("Keywords"));
		click("BrowseFindPart2_Button");
	}

	/********************************************************************************************************************
	* Method : searchPartByCategory
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void searchPartByCategory()
	{
		waitForPageLoad();
		waitForElementTime(TestDataManage.getObjectProperty("BrowseCategory_Drpdwn"),60);
		selectbyVisibleText(TestDataManage.getObjectProperty("BrowseCategory_Drpdwn"), TestDataManage.getData("Category"));
		selectbyVisibleText(TestDataManage.getObjectProperty("DiskShelf_Drpdwn"), TestDataManage.getData("DiskShelf"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Platform_Drpdwn"), TestDataManage.getData("Platform"));
		click("BrowseFindPart3_Button");
	}
	
	/********************************************************************************************************************
	* Method : verifySearchInvalid
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void verifySearchInvalid()
	{
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("BrowseCategory3Error_Lbl"))||isElementPresent(TestDataManage.getObjectProperty("SerialNumberNotFoundError_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Error Displayed for Browse for Find a Part", "Error displayed succesfully", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Case invalid. Error Displayed for Browse for Find a Part", "Error not dosplayed - FAIL", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyPartNotDisplayed
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void verifyPartNotDisplayed()
	{
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("SupportError_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Part should not be listed for User", "Part not displayed: Error Displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Part should not be listed for User", "Part displayed - FAIL", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : BrowsePartsColumnHeaderValidation
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartsColumnHeaderValidation(){
		checkMultipleElementDisplayed("BrowseParts_Field","BrowsePartsSearchColumnHeader");
		verifyElementDisplayed("BrowsePartsNewSearch_Button","New Search");
	}

	public void validateSearchedValuesinBrowserParts(){
		String givenPartNumber = TestDataManage.getData("PartNumber").trim();
		String validPartNumber;
		if(!givenPartNumber.equalsIgnoreCase("^")){
			if(givenPartNumber.contains("*")){
				validPartNumber = givenPartNumber.split("[*]")[0];
			}
			else{
				validPartNumber=givenPartNumber;
			}
			String partNumberCount=getText("BrowsePartsSearchCount_Text").trim();
			partNumberCount=partNumberCount.split("[:]")[1];
			partNumberCount=partNumberCount.trim();
			int countPartNumber = Integer.parseInt(partNumberCount);
			for(int i=1;i<=countPartNumber;i++){
				String data = String.format(TestDataManage.getObjectValue("BrowsePartsSearchResult_Text", "xpath"), i);
				if(getDriver().findElement(By.xpath(data)).getText().contains(validPartNumber)){
					getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected Given Value"+" "+validPartNumber, "Actual Value"+ " "+getDriver().findElement(By.xpath(data)).getText()+" Contains given value "+validPartNumber, getDriver());
				}
				else{
					getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected Given Value", "Actual Value"+ " "+getDriver().findElement(By.xpath(data)).getText(), getDriver());
				}
				
			}
	}
	}
	
	/********************************************************************************************************************
	* Method : verifyFindPartPageComponent
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyFindPartPageComponent()
	{
		waitForElement(TestDataManage.getObjectProperty("FindPart_Text"));
		verifyElementDisplayed("FindPart_Text","Find Part");
		waitForElement(TestDataManage.getObjectProperty("FindPartLiveChatIconImage_Lnk"));
		verifyElementDisplayed("FindPartLiveChatIconImage_Lnk", "Chat Icon");
	}
	
	/********************************************************************************************************************
	* Method : verifyBrowsePartChatHours
	* Description: Verify Chat hours Present for the browse part
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyBrowsePartChatHours()
	{
		waitForElement(TestDataManage.getObjectProperty("FindPart_Text"));
		verifyElementDisplayed("FindPart_Text","Find Part");
		waitForElement(TestDataManage.getObjectProperty("FindPartLiveChatIconImage_Lnk"));
		verifyElementDisplayed("FindPartLiveChatIconImage_Lnk", "Chat Icon");
		verifyContainsText(TestDataManage.getObjectProperty("ChatHours_Text"), TestDataManage.getData("ChatHours"));
	}
	
	
	
	/********************************************************************************************************************
	* Method : VerifyChatIconPresent_PartRequest
	* Description: Verify Chat icon add for part request
	* Author: Tony George
	* Date: Feb-23-2017
	********************************************************************************************************************/
	public void VerifyChatIconPresent_PartRequest()
	{
		waitForElement(TestDataManage.getObjectProperty("AddToOrderChatIconImage_Lnk"));
		verifyElementDisplayed("AddToOrderChatIconImage_Lnk", "Chat Icon");
	}
	
	
	/********************************************************************************************************************
	* Method : clickFindPartChatIcon
	* Description: Click the live Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void clickFindPartChatIcon()
	{
		if(isDisplayedWait(TestDataManage.getObjectProperty("FindPartLiveChatIconImage_Lnk"))){
				//waitForElement(TestDataManage.getObjectProperty("FindPartLiveChatIconImage_Lnk"));
			click("FindPartLiveChatIconImage_Lnk");
		}else
			getDetailedReport().WriteLog(Status.FAIL, "Expected Live Chat Icon should be present", "Actual Live Chat Icon is not present.", getDriver()); 
			
	}
	
	/********************************************************************************************************************
	* Method : clickLivePartChatContinue
	* Description: Click the live Chat Continue Button 
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void clickLivePartChatContinue()
	{
		pause(5000);
		boolean isEnabled=getDriver().findElement(TestDataManage.getObjectProperty("ChatMessageAllow_Lbl")).isDisplayed();
		if(isEnabled == true){
			
		waitForElement(TestDataManage.getObjectProperty("ChatIconAllowContinue_Btn"));
		click("ChatIconAllowContinue_Btn");
		}else{
			waitForElement(TestDataManage.getObjectProperty("ChatContinue_Button"));
			click("ChatContinue_Button");
		}
	}
	
	/********************************************************************************************************************
	* Method : validateFindPartChatProvideInformation
	* Description: Validate the Provide Information form in live Chat
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void validateFindPartChatProvideInformation()
	{
		waitForPageReady();
		verifyElementDisplayed("ChatProvideInfForm_Title","Provide Information");
		waitForPageReady();
		verifyElementDisplayed("ProvideInfFormChat_Button","Chat Button");
	}
	
	/********************************************************************************************************************
	* Method : validateFindPartChatProvideInformationChat
	* Description: Validate the Provide Information form in live Chat
	* Author: Rajmohan Dhanapal
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void clearchatIntakeFormMandatoryFields()
	{
		clearTextBox("ChatSerNumber_TextBox");
		clearTextBox("ChatSerNumber_TextBox");
		clearTextBox("ChatSerNumber_TextBox");
		clearTextBox("ChatSerNumber_TextBox");
	}
	
	/********************************************************************************************************************
	* Method : enterSerialNumberForChatIntake
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void enterSerialNumberForChatIntake()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		type(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), TestDataManage.getData("Keywords"));
		click(TestDataManage.getObjectProperty("ChatFirstName_TextBox"));
	}
	
	/********************************************************************************************************************
	* Method : enterSerialNumberForChatIntake
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyInvalidSerialNumberForChat()
	{
		waitForElementTime(TestDataManage.getObjectProperty("InvalidSerialNumberForChat_Lbl"), 60);
		if(isElementPresent(TestDataManage.getObjectProperty("InvalidSerialNumberForChat_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Invalid Serial number error should be displayed", "Invalid Serial number error Displayed. ", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Case invalid. Invalid Serial number error should be displayed", "Invalid Serial number error not Displayed. ", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyDeclinedSerialNumberForChat
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyDeclinedSerialNumberForChat()
	{
		waitForElementTime(TestDataManage.getObjectProperty("DeclinedSerialNumberForChat_Lbl"), 60);
		if(isElementPresent(TestDataManage.getObjectProperty("DeclinedSerialNumberForChat_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Invalid Serial number error should be displayed", "Invalid Serial number error Displayed. ", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Case invalid. Invalid Serial number error should be displayed", "Invalid Serial number error not Displayed. ", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyExpiredSerialNumberForChat
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyHyperLinkForChatWindow()
	{
		waitForPageLoad();
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("SupportSiteChat_Lnk"));
		if(isElementPresent(TestDataManage.getObjectProperty("SupportSiteChat_Lnk")) && isElementPresent(TestDataManage.getObjectProperty("ContactUsChat_Lnk"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: SupportSite and ContactUs should be present", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		
		String windowHandle = getDriver().getWindowHandle();
		click(TestDataManage.getObjectProperty("SupportSiteChat_Lnk"));
		switchToNewWindow();
		if(getCurrentUrl().contains("http://mysupport-tst.corp.netapp.com/cssportal")){
			getDetailedReport().WriteLog(Status.PASS, "Element present: URL should navigate to the required page", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		getDriver().close();
		getDriver().switchTo().window(windowHandle);
		waitForElement(TestDataManage.getObjectProperty("ContactUsChat_Lnk"));
		click(TestDataManage.getObjectProperty("ContactUsChat_Lnk"));
		waitForPageReady();
		switchToNewWindow();
		if(getCurrentUrl().contains("http://www.netapp.com/us/services-support/ngs-contacts.aspx")){
			getDetailedReport().WriteLog(Status.PASS, "Element present: URL should navigate to the required page", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		getDriver().close();
		getDriver().switchTo().window(windowHandle);
	}
	
	/********************************************************************************************************************
	* Method : clickChatButton
	* Description: Click the live Chat Button in intake form
	* Author: Rajmohan Dhanapal
	* Date: FEB-14-2017
	********************************************************************************************************************/
	public void clickChatButton()
	{
		waitForElement(TestDataManage.getObjectProperty("ProvideInfFormChat_Button"));
		click("ProvideInfFormChat_Button");
	}
	
	/********************************************************************************************************************
	* Method : clickChatCancelButton
	* Description: Click the Chat Cancel Button in intake form
	* Author: Rajmohan Dhanapal
	* Date: FEB-14-2017
	********************************************************************************************************************/
	public void clickChatCancelButton()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatCancel_Button"));
		click("ChatCancel_Button");
	}
	
	/********************************************************************************************************************
	* Method : clickChatButton
	* Description: Click the live Chat Button in intake form
	* Author: Rajmohan Dhanapal
	* Date: FEB-14-2017
	********************************************************************************************************************/
	public void validateChatMandatoryFieldError()
	{
		waitForPageReady();
		verifyContainsText(TestDataManage.getObjectProperty("ChatSerNumberRequiredmsg_Text"),"Required");
		//VerifyContainsText(TestDataManage.getObjectProperty("ChatFirstNameRequiredmsg_Text"),"Required");
		verifyElementIsDisable("ProvideInfFormChat_Button");
	}
	
	/********************************************************************************************************************
     * Method : chatIntakeForInformation
     * Description: Fill Required fields of Chat Intake form
     * Author: Sobhana P
     * Modified : Rajmohan
     * Date: FEB-16-2017
     ********************************************************************************************************************/
     public void setChatIntakeFormInfo(){
   	  setTextBox("IntakeSerialNumber", "ChatSerNumber_TextBox");
   	  setTextBox("IntakeEmail", "ChatEmail_TextBox");
   	  getDriver().findElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox")).sendKeys(Keys.TAB);
     } 
     
	/********************************************************...
	 /********************************************************************************************************************
	      * Method : verifyChatOpenedInNewWindow
	      * Description: Verify after clicking chat button whether new window opened
	      * Author: Sobhana P
	      * Date: FEB-14-2017
	      ********************************************************************************************************************/  
     public void verifyChatOpenedInNewWindow(){
	      waitForPageReady();
	      
	   	  String mainWindow=switchToNewWindow();
	      //switchToNewWindow();
	   	  Capabilities caps = ((RemoteWebDriver) getDriver()).getCapabilities();
	      String browserName = caps.getBrowserName();
	      if(browserName.contains("internet explorer")){
	    	  if(isElementPresent(TestDataManage.getObjectProperty("IESSLContiune_Lnk"))){
	    		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
	    		  jse.executeScript("document.getElementById('overridelink').click();");
//	    	  click(By.id("overridelink"));
	    	  }
	      }
	      waitForPageReady();
	      verifyContainsText(TestDataManage.getObjectProperty("NewChatWindow_Text"),"Support Live Chat");
	      click("NewChatWindowExit_Button");
	      verifyAlertTextAndAccept("Are you sure you want to disconnect your current chat");
	     // switchToNewWindow();
	      getDriver().switchTo().window(mainWindow);
	     } 
	     
	 	/********************************************************************************************************************
	 	* Method : validateChatIconNotPresencewithFindPart
	 	* Description: Verify Chat icon not Present for the scenario. 
	 	* Author: Rajmohan Dhanapal
	 	* Date: Jan-15-2017
	 	********************************************************************************************************************/
	 	public void validateChatIconNotPresencewithFindPart()
	 	{
	 		waitForElement(TestDataManage.getObjectProperty("FindPart_Text"));
	 		verifyElementDisplayed("FindPart_Text","Find Part");
	 		waitForPageReady();
	 		verifyElementNotPresent("FindPartLiveChatIconImage_Lnk");
	 	}
	 	
	 	/********************************************************************************************************************
	 	* Method : validateChatIconNotPresenceWithoutFindPart
	 	* Description: Verify Chat icon anf Find Part not Present for the scenario. 
	 	* Author: Rajmohan Dhanapal
	 	* Date: Jan-16-2017
	 	********************************************************************************************************************/
	 	public void validateChatIconNotPresenceWithoutFindPart()
	 	{
	 		waitForPageReady();
	 		verifyElementNotPresent("FindPartLiveChatIconImage_Lnk");
	 	}
	 	
		/********************************************************************************************************************
		* Method : validateEmailChatWarning
		* Description: Validate Chat Warning for invalid email
		* Author: Rajmohan Dhanapal
		* Date: Jan-16-2017
		********************************************************************************************************************/
		public void validateEmailChatWarning()
		{
			verifyAlertTextAndAccept("You have entered an invalid email address!");
		}
		
		/********************************************************************************************************************
		* Method : validateChatWarningASPSerial
		* Description: Validate Chat Warning for the ASP user for linked Serial number
		* Author: Rajmohan Dhanapal
		* Date: Jan-21-2017
		********************************************************************************************************************/
		public void validateChatWarningASPSerial()
		{
			 waitForPageReady();
			 verifyContainsText(TestDataManage.getObjectProperty("ChatWarnimg_Text"),"Please contact Fujitsu Technology Solutions GmbH for support of this product");
			 waitForPageReady();
			 click("ChatWarnimgDismiss_Buttom");
			 waitForPageReady();

		}
		/********************************************************************************************************************
		* Method : verifyIntakeFormDisplayed
		* Description: To verify intake Form Displayed
		* Author: Harish
		* Date: Feb-23-2017 
		********************************************************************************************************************/
		public void verifyIntakeFormDisplayed()
		{
			waitForPageLoad();
			if(isElementPresent(TestDataManage.getObjectProperty("ChatProvideInfForm_Title"))){
				getDetailedReport().WriteLog(Status.PASS, "Chat Intake form display for User", "Chat Intake form displayed", getDriver());
			}
			else{
				getDetailedReport().WriteLog(Status.FAIL, "Chat Intake form disply for User", "But Intake form not displayed - FAIL", getDriver());
			}
		}


		/********************************************************************************************************************
		* Method : ClickOnNewSearch
		* Description: TO click on new search
		* Author: Tony George
		* Date: Feb-24-2017
		********************************************************************************************************************/
		public void ClickOnNewSearch()
		{
		waitForElement(TestDataManage.getObjectProperty("BrowsePartsNewSearch_Button"));
		click("BrowsePartsNewSearch_Button");

		}

		/********************************************************************************************************************
		* Method : SelectSiteAndClickFindRMA
		* Description: To Select the site and find RMA
		* Author: Tony George
		* Date: Feb-23-2017
		********************************************************************************************************************/
		public void addOrderAndCreateCase_RCA()
		{
			waitForElement(TestDataManage.getObjectProperty("Qty_Txtbox"));	
			type(TestDataManage.getObjectProperty("Qty_Txtbox"),"1");
			click("AddToOrder_Txtbox");
			waitForElement(TestDataManage.getObjectProperty("FailureInformation_TextArea"));
			verifyElementDisplayed("RCA_Checkbox", "RCA Checkbox");
			verifyElementDisplayed("FailureInformation_TextArea", "Failure Information Text Area");
			click("RCA_Checkbox");
			type(TestDataManage.getObjectProperty("Mobile_Txtbox"), "1234567");
			click("ContinueRMA_Btn");
			waitForPageLoad();
			waitForElement(TestDataManage.getObjectProperty("SubmitRMA_Btn"));	
			click("SubmitRMA_Btn");
		}
		/********************************************************************************************************************
		* Method : verifyBrowsePartChatHours
		* Description: Verify Chat hours Present for the browse part
		* Author: Rajmohan Dhanapal
		* Date: Jan-14-2017
		********************************************************************************************************************/
		public void verifyChatHours()
		{
			waitForElement(TestDataManage.getObjectProperty("ChatHours_Text"));
			verifyContainsText(TestDataManage.getObjectProperty("ChatHours_Text"), TestDataManage.getData("ChatHours"));
		}

		/********************************************************************************************************************
		* Method : VerifyChatIntakeForm
		* Description: To verify the chat intake form
		* Author: Tony George
		* Date: Feb-21-2017 
		********************************************************************************************************************/
		public void verifyChatIntakeFields()
		{
			waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
			verifyElementIsDisable("ChatSerNumber_TextBox");
			verifyContainsValue(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), TestDataManage.getData("IntakeSerialNumber"));
			verifyElementEnabled("ChatFirstName_TextBox");
			verifyContainsValue(TestDataManage.getObjectProperty("ChatFirstName_TextBox"), TestDataManage.getData("FirstName"));
			verifyElementEnabled("ChatLastName_TextBox");
			verifyContainsValue(TestDataManage.getObjectProperty("ChatLastName_TextBox"), TestDataManage.getData("LastName"));
			verifyElementEnabled("ChatEmail_TextBox");
			verifyContainsValue(TestDataManage.getObjectProperty("ChatEmail_TextBox"), TestDataManage.getData("IntakeEmail"));
			clearTextBox("ChatEmail_TextBox");
			type(TestDataManage.getObjectProperty("ChatEmail_TextBox"), "netapp@test.com");
			verifyElementNotPresent("ChatIntakeProductArea_Select");
			verifyElementNotPresent("ChatIntakeCaseCatogery_Select");
			verifyContainsText(TestDataManage.getObjectProperty("ChatIntakeChatNote_Txt"), TestDataManage.getData("ChatNote"));
		}
}
