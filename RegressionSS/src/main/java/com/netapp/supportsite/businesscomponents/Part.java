package com.netapp.supportsite.businesscomponents;

import org.junit.Test;
import com.netapp.supportsite.base.PartBase;

public class Part extends PartBase
{
	/********************************************************************************************************************
	* Method : RequestAPart
	* Description: To request a part
	* Author: Tony George
	* Date: January-20-2017
	********************************************************************************************************************/
	@Test
	public void requestAPart()
	{
		waitForPageReady();
		clickSubmenu("CasesAndPart_Link","Request a Part");
		searchDetails();
		clickOnGoFromDetailsTable();
		createNewCase();
		searchPartsByCriteria();
		addOrder();
		clickSubmenu("CasesAndPart_Link","View Part Request");
		searchPartRequestDetails();
		
	}	
	
	/********************************************************************************************************************
	* Method : browsePartValidation
	* Description: Complete VAlidation of Browse Parts Function
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartValidation(){
		waitForPageReady();
		clickSubmenu("CasesAndPart_Link","Browse Parts");
		waitForPageReady();
		browsePartFieldValidation();
		browsePartSearchByPartNumber();
		waitForPageReady();
		browsePartsColumnHeaderValidation();
		validateSearchedValuesinBrowserParts();
		
	}
	
	/********************************************************************************************************************
	* Method : RequestPartForMyCompany
	* Description: Request a part for My Company from Search criteria 2.
	* Author: Alfred Dcruz
	* Date: Feb-10-2017
	********************************************************************************************************************/
	public void RequestPartForMyCompany(){
		
		waitForPageReady();
		clickSubmenu("CasesAndPart_Link","Request a Part");
		waitForPageReady();
		searchCriteriaDirectly();
		waitForPageReady();
		clickOnGoFromDetailsTable();
		waitForPageReady();
		createNewCase();
		waitForPageReady();
		searchPartsByCriteria();
		waitForPageReady();
		addOrder();
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
		clickSubmenu("CasesAndPart_Link","Request a Part");
		searchCriteriaDirectly();
		FindSerialNumberAndClickGo();
		
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
	
	
	
	
	
	
	
	
	
}
