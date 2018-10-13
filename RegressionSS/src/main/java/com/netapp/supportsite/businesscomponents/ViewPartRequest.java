package com.netapp.supportsite.businesscomponents;

import org.junit.Test;

import com.netapp.supportsite.base.ViewPartRequestBase;

public class ViewPartRequest extends ViewPartRequestBase
{

	/********************************************************************************************************************
	* Method : SearchDetails
	* Description: Select a search criteria and search for a value
	* Author: Tony George
	* Date: Feb-15-2017
	********************************************************************************************************************/
	@Test
	public void searchDetails()
	{
		selectCriteriaAndSearchValue();
		
	}	
	/********************************************************************************************************************
	* Method : SearchDetails
	* Description: Select a search criteria and search for a value
	* Author: Tony George
	* Date: Feb-15-2017
	********************************************************************************************************************/
	@Test
	public void searchAndVerifyInDetailsTable()
	{
		selectCriteriaAndSearchValue();
		verifyDetailsTableContainValue();
		
	}
	
	/********************************************************************************************************************
	* Method : BrowseAndVerifyInDetailsTableForDifferentStatus
	* Description: Select a search criteria and search for a value
	* Author: Alfred Dcruz
	* Date: Feb-15-2017
	********************************************************************************************************************/
	@Test
	public void BrowseAndVerifyInDetailsTableForDifferentStatus()
	{
		waitForPageLoad();
		selectViewCaseSearchForDifferentCountriesOrState();
		
	}
	/********************************************************************************************************************
	* Method : NavigateToCaseDetailsPageBySelectingTheCaseNumber
	* Description: To navigate to the case details page after clicking the case number from list
	* Author: Tony George
	* Date: Mar-23-2017
	********************************************************************************************************************/
	@Test
	public void navigateToCaseDetailsPageBySelectingTheCaseNumber()
	{
		selectCaseNumberFromDetailsTable();
		
	}

	/********************************************************************************************************************
	* Method : NavigateToCaseDetailsPageBySelectingTheCaseNumber
	* Description: To navigate to the case details page after clicking the case number from list
	* Author: Tony George
	* Date: Mar-23-2017
	********************************************************************************************************************/
	@Test
	public void verifyChatIconPresent()
	{
		validateChatIconPresence();
		
	}






}

