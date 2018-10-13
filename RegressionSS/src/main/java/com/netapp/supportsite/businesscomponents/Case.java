package com.netapp.supportsite.businesscomponents;

import org.junit.Test;

import com.netapp.supportsite.base.CaseBase;

public class Case extends CaseBase
{

	/********************************************************************************************************************
	* Method : CreateCase
	* Description: Create a Case
	* Author: Alfred Dcruz
	* Date: February-9-201
	********************************************************************************************************************/
	@Test
	public void verifyChatIconNotPresentForCreateCase()
	{
		waitForPageReady();
		clickSubmenu("CasesAndPart_Link","Create Case"); 
		searchForBrowseListForCreateCase();
		waitForPageReady();
		selectSerialNumberFromBrowseList();
		waitForPageReady();
		describeTheProblemForCase();
		waitForPageReady();
		fillAgreementPage();
		waitForPageReady();
		fillReviewArticlesPage();
		waitForPageReady();
		verifyChatIconNotPresent();
		waitForPageReady();
		fillCaseAndContactPage();	// Case Created

		//clickSubmenu("CasesAndPart_Link","View Cases");
		//searchCase();
	}
	
	public void SearchCriteria2ForDifferentCountriesOrStates()
	{
		waitForPageLoad();
		validateViewCaseSearchForDifferentCountriesOrState();
	}
	
	@Test
	public void verifyChatIconPresentForCreateCase()
	{
		waitForPageReady();
		clickSubmenu("CasesAndPart_Link","Create Case"); 
		searchForSerialNumberForCreateCase();
		waitForPageReady();
		selectSerialNumberFromBrowseList();
		waitForPageReady();
		describeTheProblemForCase();
		waitForPageReady();
		//fillAgreementPage();
		waitForPageReady();
		fillReviewArticlesPage();
		waitForPageReady();
		fillExtraInformationPage();
		waitForPageReady();
		validateChatIconPresent();
		
		waitForPageReady();
		clickChatIcon();
		waitForPageReady();
		
		clickChatContinue();
		waitForPageReady();
		validateProvideInformationChat();
		
	}

}
