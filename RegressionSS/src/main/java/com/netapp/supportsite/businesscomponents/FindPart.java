package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.FindPartBase;
import com.netapp.supportsite.base.HomeBase;

/**
 * Class : FindPart
 * @author : UST Global
 */

public class FindPart extends FindPartBase {

	public void searchByPartNumber(){
		browsePartSearchByPartNumber();
	}
	
	public void searchBySysConfig(){
		searchBySysConfigSearch();
	}
	
	public void searchByCategory(){
		searchPartByCategory();
		
	}
	
	public void searchByCategoryOnlyDropdown(){
		searchByCategoryOnly();
		
	}
	
	/********************************************************************************************************************
	* Method : validatePartNumberInformtionBySearchBySysConfig
	* Description: Verify part number information to be matched with SAP.
	* Author: Alfred
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void validatePartNumberInformtionBySearchBySysConfig(){
		searchBySysConfig();
		clickFirstPartNumberFromList();
		verifyPartInformationPage();
	}
	
	/********************************************************************************************************************
	* Method : validatePartNumberInformtionBySearchByPartNumberTwice
	* Description: Verify part number information to be matched with SAP.
	* Author: Alfred
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void validatePartNumberInformtionBySearchByPartNumberTwice(){
		searchByPartNumber();
		clickOnNewSearchButton();
		browsePartSearchByPartNumber1();
		clickFirstPartNumberFromList();
		verifyPartInformationPage();
	}
	
	/********************************************************************************************************************
	* Method : validatePartNumberInformtionByCategoryDropdown
	* Description: Verify part number information to be matched with SAP.
	* Author: Alfred
	* Date: Mar-06-2017
	********************************************************************************************************************/
	public void validatePartNumberInformtionByCategoryDropdown(){
		searchByCategoryOnlyDropdown();
		clickFirstPartNumberFromList();
		verifyPartInformationPage();
	}
	
	/********************************************************************************************************************
	* Method : validateBrowsePartNotDisplayed
	* Description: Verify Browse for part not displayed for user.
	* Author: Alfred
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void validateBrowsePartNotDisplayed(){
		searchPartByCategory();
		verifyPartNotDisplayed();
	}
	
	/********************************************************************************************************************
	* Method : validateBrowsePartForSearch1NotDisplayed
	* Description: Verify Browse for part not displayed for user.
	* Author: Alfred
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void validateBrowsePartForSearch1NotDisplayed(){
		searchByPartNumber();
		verifySearchInvalid();
	}
	
	/********************************************************************************************************************
	* Method : browsePartValidation
	* Description: Complete VAlidation of Browse Parts Function
	* Author: RajmohanCreateCase_CustomerUser
	* 
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartValidation(){
		browsePartFieldValidation();
		browsePartSearchByPartNumber();
		waitForPageReady();
		browsePartsColumnHeaderValidation();
		validateSearchedValuesinBrowserParts();
		
	}
	
	
	/********************************************************************************************************************
	* Method : verifyChatIconPresentForFindPart
	* Description: Validate the Chat icon present
	* Author: Rajmohan Dhanapal
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatIconPresentForFindPart()
	{
	waitForPageReady();
	verifyFindPartPageComponent();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIntakeForm
	* Description: Validate the Chat intake form
	* Author: Rajmohan Dhanapal
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForm()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	validateFindPartChatProvideInformation();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatMandatoryFieldWarning
	* Description: Validate warning message of mandatory fields in chat
	* Author: Rajmohan Dhanapal
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatMandatoryFieldWarning()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	clearchatIntakeFormMandatoryFields();
	waitForPageReady();
	//clickChatButton();
	waitForPageReady();
	validateChatMandatoryFieldError();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatCancelFunctionality
	* Description: Validate Functinality of Chat cancel button
	* Author: Rajmohan Dhanapal
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatCancelFunctionality()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	clickChatCancelButton();
	waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatNotAvailableForSerialNumber
	* Description: Validate Functinality of Chat cancel button
	* Author: Alfred Dcruz
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatNotAvailableForSerialNumber()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	enterSerialNumberForChatIntake();
	waitForPageReady();
	verifyInvalidSerialNumberForChat();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatNotAvailableForDeclinedSerialNumber
	* Description: Validate Functinality of Chat cancel button
	* Author: Alfred Dcruz
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatNotAvailableForDeclinedSerialNumber()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	enterSerialNumberForChatIntake();
	waitForPageReady();
	verifyDeclinedSerialNumberForChat();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatNotAvailableForExpiredSerialNumber
	* Description: Validate Functinality of Chat cancel button
	* Author: Alfred Dcruz
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatNotAvailableForExpiredSerialNumber()
	{
	waitForPageReady();
	clickFindPartChatIcon();
	waitForPageReady();
	clickLivePartChatContinue();
	waitForPageReady();
	enterSerialNumberForChatIntake();
	waitForPageReady();
	verifyHyperLinkForChatWindow();
	}
	
	/********************************************************************************************************************
	* Method : verifyErrorForInvalidBrowse3
	* Description: Validate Functinality of Chat cancel button
	* Author: Alfred Dcruz
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyErrorForInvalidBrowse3()
	{
	waitForPageReady();
	searchPartByCategory();
	verifySearchInvalid();
	}
	
	/********************************************************************************************************************
	* Method : VerifychatDisplayedforValidSerialNumber
	* Description: Verify chat is displayed for a valid serial number
	* Author: Sobhana P
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatDisplayedforValidSerialNumber(){
		waitForPageReady();
		verifyFindPartPageComponent();
		clickFindPartChatIcon();
		clickLivePartChatContinue();
		validateFindPartChatProvideInformation();
		setChatIntakeFormInfo();
		clickChatButton();
		verifyChatOpenedInNewWindow();		
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIconNotPresentwithFindPart
	* Description: Validate the Chat icon present
	* Author: Rajmohan Dhanapal
	* Date: February-16-2017
	********************************************************************************************************************/
	public void verifyChatIconNotPresentwithFindPart()
	{
	waitForPageReady();
	validateChatIconNotPresencewithFindPart();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIconNotPresentwithoutFindPart
	* Description: Validate the Chat icon present
	* Author: Rajmohan Dhanapal
	* Date: February-16-2017
	********************************************************************************************************************/
	public void verifyChatIconNotPresentwithoutFindPart()
	{
	waitForPageReady();
	validateChatIconNotPresenceWithoutFindPart();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatInavalidEmail
	* Description: Verify error message for incalid email
	* Author: Rajmohan
	* Date: February-16-2017
	********************************************************************************************************************/
	public void verifyChatInavalidEmail(){
		waitForPageReady();
		verifyFindPartPageComponent();
		clickFindPartChatIcon();
		clickLivePartChatContinue();
		setChatIntakeFormInfo();
		clickChatButton();
		validateEmailChatWarning();		
	}
	/********************************************************************************************************************
	* Method : verifyChatWarningASPSerial
	* Description: Validate Chat Warning for the ASP user for linked Serial number
	* Author: Rajmohan Dhanapal
	* Date: February-21-2017
	********************************************************************************************************************/
	public void verifyChatWarningASPSerial(){
		waitForPageReady();
		verifyFindPartPageComponent();
		clickFindPartChatIcon();
		clickLivePartChatContinue();
		validateFindPartChatProvideInformation();
		setChatIntakeFormInfo();
		validateChatWarningASPSerial();
	}

	/********************************************************************************************************************
	* Method : verifyChatIconPartRequest
	* Description: Validate the Chat icon present
	* Author: Tony George
	* Date: February-14-2017
	********************************************************************************************************************/
	public void verifyChatIconPartRequest()
	{
	waitForPageReady();
	VerifyChatIconPresent_PartRequest();
	}
	/********************************************************************************************************************
	* Method : validateChatIntakeFormDisplayed
	* Description: validate Chat Intake Form Displayed
	* Author: Harish
	* Date: February-23-2017
	********************************************************************************************************************/
	public void validateChatIntakeFormDisplayed(){
		waitForPageReady();
		verifyFindPartPageComponent();
		clickFindPartChatIcon();
		clickLivePartChatContinue();
		verifyIntakeFormDisplayed();
	}
	/********************************************************************************************************************
	* Method : clickOnNewSearchAndValidate
	* Description: Click on new search and validate the pages
	* Author: Tony George
	* Date: Feb-23-2017
	********************************************************************************************************************/
	public void clickOnNewSearchAndValidate()
	{
		ClickOnNewSearch();
		browsePartFieldValidation();
		browsePartSearchByPartNumber();
		waitForPageReady();
		browsePartsColumnHeaderValidation();
		validateSearchedValuesinBrowserParts();
	}
	
	/********************************************************************************************************************
	* Method : SelectSiteAndRequestRMA
	* Description: To select the site and Request RMA
	* Author: Tony George
	* Date: Feb-21-2017 
	********************************************************************************************************************/
	public void CreateCase_IBMUser()
	{
		checkMultipleElementDisplayed("BrowseParts_Field","BrowsePartsFields");
		browsePartSearchByPartNumber();
		waitForPageReady();
		browsePartsColumnHeaderValidation();
		validateSearchedValuesinBrowserParts();
		addOrderAndCreateCase_RCA();
	}
	
	/********************************************************************************************************************
	* Method : validateChatTiming_BrowseParts
	* Description: To validate the chat timings in browse parts page
	* Author: Tony George
	* Date: Mar-21-2017 
	********************************************************************************************************************/
	public void validateChatTiming_BrowseParts()
	{
		verifyBrowsePartChatHours();
	}
	/********************************************************************************************************************
	* Method : validateChatTiming
	* Description: To validate the chat timings
	* Author: Tony George
	* Date: Mar-28-2017 
	********************************************************************************************************************/
	public void validateChatTiming()
	{
		verifyChatHours();
	}

	/********************************************************************************************************************
	* Method : searchPartAndVerifyChatIntakeForm
	* Description: To search for a part number and verify the chat intake form
	* Author: Tony George
	* Date: Mar-29-2017 
	********************************************************************************************************************/
	public void searchPartAndVerifyChatIntakeForm()
	{
		browsePartSearchByPartNumber();
		verifyChatIntakeForm();
		verifyChatIntakeFields();
	}


	/********************************************************************************************************************
	* Method : SelectSiteAndRequestRMA
	* Description: To select the site and Request RMA
	* Author: Sreejith
	* Date: Mar-26-2017 
	********************************************************************************************************************/
	public void CreateCase_CustomerUser()
	{
		searchPartByCategory();
	}

	/********************************************************************************************************************
	* Method : navigateToProfile
	* Description: To navigate to profile page
	* Author: Sreejith
	* Date: Mar-26-2017 
	********************************************************************************************************************/
	public void navigateToProfile()
	{
		HomeBase home=new HomeBase();
		home.clickMyProfile("ClickUserProfile_Link", "Profile");
	}

}
