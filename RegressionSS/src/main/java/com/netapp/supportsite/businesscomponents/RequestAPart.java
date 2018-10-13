package com.netapp.supportsite.businesscomponents;

import org.junit.Test;

import com.netapp.supportsite.base.RequestAPartBase;

/**
 * Class : RequestAPart
 * @author : UST Global
 */
public class RequestAPart extends RequestAPartBase
{
	/********************************************************************************************************************
	* Method : searchPartNumberSearch1
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void searchPartNumberSearch1()
	{
		waitForPageReady();
		searchDetails();
		
	}	
	
	/********************************************************************************************************************
	* Method : validateChatIconDisplayedForRequestAPart
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void validateChatIconDisplayedForRequestAPart()
	{
		waitForPageReady();
		searchDetails();
		clickGoForPartNumber();
		clickOnCreateNewCaseButton();
		verifyChatIconPresent();
		
	}	
	
	/********************************************************************************************************************
	* Method : searchCategorySearch2
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void searchCategorySearch2()
	{
		waitForPageReady();
		searchDetailsByCategory();
		
	}	
	
	/********************************************************************************************************************
	* Method : searchMyCustomerCriteria3
	* Description: Search part number from Search Criteria 3
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void searchMyCustomerCriteria3()
	{
		waitForPageReady();
		browseByMyCustomer();
		
	}
	
	/********************************************************************************************************************
	* Method : navigateToCreateRequestForPartCriteria3Search
	* Description: Search part number from Search Criteria 3
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCreateRequestForPartCriteria3Search()
	{
		searchMyCustomerCriteria3();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueButton();
		
	}
	
	/********************************************************************************************************************
	* Method : verifyChaticonNotPresentRMAPage
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void verifyChaticonNotPresentRMAPage()
	{
		waitForPageReady();
		searchDetails();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueAgreementButton();
		VerifyChatIconNotPresent();
		
	}
	
	/********************************************************************************************************************
	* Method : verifyChaticonNotPresentRMAPage
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void verifyChaticonPresentRMAPage()
	{
		waitForPageReady();
		searchDetails();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueAgreementButton();
		verifyChatIconPresent();
		
	}
	
	/********************************************************************************************************************
	* Method : clickGoForSelectedPartNumberSearch
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void clickGoForSelectedPartNumberSearch()
	{
		waitForPageReady();
		clickGoForPartNumber();
		
	}
	
	/********************************************************************************************************************
	* Method : validateExpiredContractTitle
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void validateExpiredContractTitle()
	{
		waitForPageReady();
		searchDetails();
		clickGoForSelectedPartNumberSearch();
		validateTitleExpiredContract();
		
	}	
	
	/********************************************************************************************************************
	* Method : ShowSerialNumberAndSelectFromList
	* Description: Navigates to the request part page by clicking on the GO button based the serial number provided
	* Author: Tony George
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void showSerialNumbersAndSelectFromList()
	{
		waitForPageReady();
		searchDetailsByCategory();
		//searchCriteriaDirectly();
		clickSerialNumberFromBrowseListForRequestAPart();
		//FindSerialNumberAndClickGo();
		
		
	}	
	
	/********************************************************************************************************************
	* Method : verifyChaticonForExpiredContract
	* Description: Verify chat icon is not present for the expired serial number
	* Author: Tony George
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void verifyChaticonNotPresentForExpiredContract()
	{
		waitForPageReady();
		AcceptAgreement();
		VerifyChatIconNotPresent();
		
	}
	/********************************************************************************************************************
	* Method : verifyChaticonPresent
	* Description: Verify chat icon and hover text
	* Author: Tony George
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void verifyChaticonPresent()
	{
		verifyChatIconAndHoverText();
		
	}
	/********************************************************************************************************************
	* Method : verifyChaticonPresent
	* Description: Verify chat icon and hover text
	* Author: Tony George
	* Date: Feb-14-2017
	********************************************************************************************************************//*
	@Test
	public void SearchAndSelectTheSerialNumber()
	{
		searchPartsByCriteria();
		
	}*/
	
	/********************************************************************************************************************
	* Method : navigateToCreateRequestForPart
	* Description: navigate to request a part creation page by entering required in the previous pages.
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCreateRequestForPart()
	{
		searchDetails();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueButton();
		
	}
	
	/********************************************************************************************************************
	* Method : navigateToCreateRequestForPartCustomerSearch
	* Description: navigate to request a part creation page by entering required in the previous pages.
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCreateRequestForPartCustomerSearch()
	{
		browseByMyCustomer();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueButton();
		
	}
	
	/********************************************************************************************************************
	* Method : navigateToCreateRequestForPartforMyCompanySearch
	* Description: navigate to request a part creation page by entering required in the previous pages.
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCreateRequestForPartforMyCompanySearch()
	{
		searchDetailsByCategory();
		clickGoForPartNumber();
		clickCreateNewCaseOrContinueAgreementButton();
		
	}
	
	/********************************************************************************************************************
	* Method : navigateToCreateRequestForPartforAutoSupportOFF
	* Description: navigate to request a part creation page by entering required in the previous pages.
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCreateRequestForPartforAutoSupportOFF()
	{
		searchDetailsByCategory();
		clickGoForPartNumberAutoSupportONorOFF();
		clickCreateNewCaseOrContinueButton();
		
	}
	
	/********************************************************************************************************************
	* Method : createRequestForPartByEnteringOrder
	* Description: navigate to request a part creation page by entering required in the previous pages.
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************//*
	@Test
	public void createRequestForPartByEnteringOrder()
	{
		waitForPageLoad();
		addOrder();
	}*/
	
	/********************************************************************************************************************
	* Method : validateSupportErrorForInvalidUser
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void validateSupportErrorForInvalidUser()
	{
		waitForPageReady();
		searchDetailsByCategory();
		verifySupportErrorDisplayedForSearch();
		
	}
	
	/********************************************************************************************************************
	* Method : validateSupportErrorForInvalidUser
	* Description: Search part number from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void validateInvalidHostOrSytemError()
	{
		waitForPageReady();
		searchPartNumberSearch1();
		verifyInvalidSystemorHostError();
		
	}
	/********************************************************************************************************************
	* Method : addOrderPageValidation
	* Description: To verify the Add order page
	* Author: Tony George
	* Date: Feb-20-2017
	********************************************************************************************************************/
	@Test
	public void addOrderPageValidation()
	{
	
		checkMultipleElementDisplayed("BrowseParts_Field", "BrowsepartTableHeaders");
		
	}
	
	/********************************************************************************************************************
	* Method : NavigateToRMAAndVerifyChatIntakeForm
	* Description: To navigate to the RMA and verify the chat intake form
	* Author: Tony George
	* Date: Feb-20-2017
	********************************************************************************************************************/
	@Test
	public void navigateToRMAAndVerifyChatIntakeForm()
	{
		showSerialNumbersAndSelectFromList();
		openChatIntakeForm();
		verifyChatIntakeForm();
		
	}
	/********************************************************************************************************************
	* Method : navigateToPartSelectionAndVerifyChatIntakeForm
	* Description: To navigate to the RMA and verify the chat intake form
	* Author: Tony George
	* Date: Feb-20-2017
	********************************************************************************************************************//*
	@Test
	public void navigateToPartSelectionAndVerifyChatIntakeForm()
	{
		showSerialNumbersAndSelectFromList();
		browsePartSearchByPartNumber();
		openChatIntakeForm();
		verifyChatIntakeForm();
		
	}*/
	
	/********************************************************************************************************************
	* Method : verifyUserhaveNoAccessToSearchRMA
	* Description: Verify user have no acccess to search RMA
	* Author: Tony George
	* Date: Feb-17-2017
	********************************************************************************************************************/
	@Test
	public void verifyUserhaveNoAccessToSearchRMA()
	{
		verifyRMASearchNotPreset();
		
	}
	/********************************************************************************************************************
	* Method : verifyUserhaveNoAccessToShowRMA
	* Description: Verify user have no acccess to view RMA
	* Author: Tony George
	* Date: Feb-17-2017
	********************************************************************************************************************/
	@Test
	public void verifyUserhaveNoAccessToViewRMA()
	{
		verifyUserNotAbleToViewRMA();
		
	}
	/********************************************************************************************************************
	* Method : VerifyChatOpensInNewTab
	* Description: Click chat and verify chat opens in new tab
	* Author: Tony George
	* Date: Feb-22-2017
	********************************************************************************************************************/
	@Test
	public void VerifyChatOpensInNewTab()
	{
		openChatIntakeForm();
		clickOnChatbuttonAndVerifyNewTab();
	}
		

	/********************************************************************************************************************
	* Method : SelectSiteAndRequestRMA
	* Description: To select the site and Request RMA
	* Author: Tony George
	* Date: Feb-21-2017 
	********************************************************************************************************************/
	public void SelectSiteAndRequestRMA()
	{
		selectSiteAndClickFindRMA();
	}

	/********************************************************************************************************************
	* Method : searchSerialNumberAndValidateTable
	* Description: Search serialnumber from Search Criteria 1
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	@Test
	public void searchSerialNumberAndValidateTable()
	{
		waitForPageReady();
		searchDetails();
		verifyDetailsTable();
		
	}	
	
	

	/********************************************************************************************************************
	* Method : SelectSiteAndFindRMA
	* Description: To select the site and Request RMA for Logistic user
	* Author: Sreejith
	* Date: Feb-21-2017 
	********************************************************************************************************************/
	public void SelectSiteAndFindRMA()
	{
		selectSiteAndClickFindRMA();

	}
	
	
	/********************************************************************************************************************
	* Method : SelectSiteAndRequestRMA_logisticeUSer
	* Description: To select the site and Request RMA for Logistic user
	* Author: Sreejith
	* Date: Feb-21-2017 
	********************************************************************************************************************/
	public void createPartRequest_CustomerUser()
	{
		
		searchDetailsByCategory();
		clickSerialNumberFromBrowseListForRequestAPart();
		
		//AcceptAgreement();
		//searchDetailsByCategory();
	
	}
	


}
