package com.netapp.supportsite.businesscomponents;

import java.util.ArrayList;

import org.junit.Test;

import com.netapp.supportsite.base.CreateCaseBase;
import com.netapp.supportsite.base.SAPBase;
import com.ust.sarf.testdata.TestDataManage;


public class SAP extends SAPBase
{
	/********************************************************************************************************************
	* Method : login
	* Description: To set the username, password and login the user 
	* Author:Tony George
	* Date: Feb-21-2017
	********************************************************************************************************************/
	CreateCaseBase cr= new CreateCaseBase();
	String CaseNumber=cr.CaseNo;
	
	@Test
	public void SAPlogin()
	{
		openNewBrowserWindow();
		String url = TestDataManage.getData("Url");
		getDriver().navigate().to(url); 
		waitForPageReady();
		//verifyTitle()
		enterCredentials();
		waitForPageReady();


	}
	
	/********************************************************************************************************************
	* Method : validateTransactionDetailPage
	* Description: Validate the Transaction Detail Page in SAP login
	* Author: Rajmohan Dhanapal
	* Date: Feb-23-2017
	 * @throws Exception 
	********************************************************************************************************************/
	public void validateTransactionDetailPage() throws Exception{
		searchTransaction(CaseNumber);
		VerifyTransactionDetailPage(CaseNumber);
	}


	/********************************************************************************************************************
	* Method : validateTransactionDetailPage
	* Description: Validate the Transaction Detail Page in SAP login
	* Author: Rajmohan Dhanapal
	* Date: Feb-23-2017
	 * @throws Exception 
	********************************************************************************************************************/
	public void VerifyCaseDetailsInSAP() throws Exception
	{
		String Case =GetCaseNumber();
		SAPlogin();
		searchTransaction(Case);
		VerifyTransactionDetailPage(Case);
	}

	/********************************************************************************************************************
	* Method : navigateToLeftMenuLinks
	* Description: Navigate to Left Links pages.
	* Author: Alfred Dcruz
	* Date: Mar-07-2017
	 * @throws Exception 
	********************************************************************************************************************/
	public void navigateToLeftMenuLinks() throws Exception
	{
		
		SAPlogin();
		navigateToMenu();
		
	}

	/********************************************************************************************************************
	* Method : validatePartsInformationWithSupportSiteForVariousSearch
	* Description: To verify test evironment parts information with SAP displayed parts information.
	* Author:Alfred
	* Date: Mar-07-2017
	 * @throws Exception 
	********************************************************************************************************************/
	
	@Test
	public void validatePartsInformationWithSupportSiteForVariousSearch() throws Exception
	{
		String partNumber = getPartNumber();
		ArrayList<String> partInfoList = getPartInformation();
		waitForPageLoad();
		SAPlogin();
		navigateToMenu();
		selectDropDownsearchFor();
		selectSubCriteriaSearchFor();
		clickOnPartNumberSAP(partNumber);
		validatePartInformation(partInfoList);
	}
	
	/********************************************************************************************************************
	* Method : validateTransactionDetailPage
	* Description: Validate the Transaction Detail Page in SAP login for 
	* Author:Sreejith
	* Date: Feb-23-2017
	 * @throws Exception 
	********************************************************************************************************************/
	public void validateTransactionDetailPageForLogisticesUser() throws Exception{
		String CaseNumber =GetCaseNumber();
		SAPlogin();
		searchTransaction(CaseNumber);
		VerifyTransactionDetailPage_Logistices(CaseNumber);
	}


}
