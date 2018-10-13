package com.netapp.supportsite.base;

import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class CaseBase extends Base
{	
	/********************************************************************************************************************
	* Method : searchForSerialNumberForCreateCase
	* Description: To Search for a serial number to select
	* Author: Alfred Dcruz
	* Date: Jan-7-2017
	********************************************************************************************************************/
	public void searchForSerialNumberForCreateCase()
	{
		waitForElement(TestDataManage.getObjectProperty("SerialNumber_Txtbox"));
		type(TestDataManage.getObjectProperty("SerialNumber_Txtbox"), TestDataManage.getData("SerialNumber"));
		click("Go_Btn");
		
	}
	
	/********************************************************************************************************************
	* Method : searchForBrowseListForCreateCase
	* Description: To Search for All Serial Numbers For My Company
	* Author: Alfred Dcruz
	* Date: Jan-7-2017
	********************************************************************************************************************/
	public void searchForBrowseListForCreateCase()
	{
		
		waitForElement(TestDataManage.getObjectProperty("Browse_Btn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Browse_Btn"), TestDataManage.getData("BrowseCategory"));
		click("Go_Btn");
	}
	
	/********************************************************************************************************************
	* Method : selectSerialNumberFromBrowseList
	* Description: To select required serial number from listed table
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void selectSerialNumberFromBrowseList()
	{		
		waitForElement(TestDataManage.getObjectProperty("SerialNumber_Lbl"));
		// Select required(expired/secure/nonsecure...) serial number to be selected.
		
		if(isElementPresent(By.xpath(setXpath("SerialNumberToSelect_Lnk","SerialNumber"))))
		{
			if(waitForClickable(TestDataManage.getObjectProperty("NextPage_Link")))
			{
				click(TestDataManage.getObjectProperty("NextPage_Link"));
				waitForPageReady();
			}
			else{
				System.out.println("This is the last page. Required Serial number cannot be found.");
				getDetailedReport().WriteLog(Status.FAIL,"Serial number not found", "Serial number not found",getDriver());
			}
		}
		else{
			//click(setXpath("SerialNumberToSelect_Lnk","SerialNumber"));
			click(By.xpath(setXpath("SerialNumberToSelect_Lnk","SerialNumber")));
			
		}
	}
	
	/********************************************************************************************************************
	* Method : describeTheProblemForCase
	* Description: Describe the case by answering the Questions and commenting reason for the case.
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void describeTheProblemForCase()
	{
		switchToNewWindow();
		waitForElement(TestDataManage.getObjectProperty("Question1_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question1_Drpdwn"), TestDataManage.getData("Catogery1"));
		waitForElement(TestDataManage.getObjectProperty("Question2_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question2_Drpdwn"), TestDataManage.getData("Catogery2"));
		waitForElement(TestDataManage.getObjectProperty("Question3_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question3_Drpdwn"), TestDataManage.getData("Catogery3"));
		type(TestDataManage.getObjectProperty("Description_Txtarea"), TestDataManage.getData("Description"));
		click("ProblemGo_Btn");
	}
	
	/********************************************************************************************************************
	* Method : fillAgreementPage
	* Description: Click radio button for selecting Agreement and Click Continue.
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void fillAgreementPage()
	{
		/* Write code for selecting Agreement for payment if required for test case */
		
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
		click(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
	}
	
	/********************************************************************************************************************
	* Method : fillReviewArticlesPage
	* Description: Click Continue for Review article page and navigate to Case and Contact Page.
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void fillReviewArticlesPage()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
		click("ContinueWithCreation_Btn");
	}
	
	/********************************************************************************************************************
	* Method : fillExtraInformationPage
	* Description: Click Continue for Extra Information page and navigate to Case and Contact Page.
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void fillExtraInformationPage()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
		click("Continue_Btn");
	}
	
	/********************************************************************************************************************
	* Method : fillCaseAndContactPage
	* Description: Fill case and Contact Page and create case.
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void fillCaseAndContactPage()
	{
		waitForElement(TestDataManage.getObjectProperty("IssueObservered_Txtarea"));
		type(TestDataManage.getObjectProperty("IssueObservered_Txtarea"), TestDataManage.getData("IssueObserved"));
		type(TestDataManage.getObjectProperty("MaintainanceActivities_Txtarea"), TestDataManage.getData("RecentChanges"));
		type(TestDataManage.getObjectProperty("OSVersion_Txtarea"), TestDataManage.getData("OSVersion"));
		type(TestDataManage.getObjectProperty("DescribeEnviornmnet_Txtarea"), TestDataManage.getData("Enviornment"));
		click("CaseCreationGo_Btn");
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("CaseNumber_Txt"));
		String CaseNum= getText(TestDataManage.getObjectProperty("CaseNumber_Txt"));
		System.out.println("Case created successfully with Case number:" + CaseNum);
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIconNotPresent
	* Description: Verify Chat icon Not Present for the scenario. 
	* Author: Alfred Dcruz
	* Date: Jan-8-2017
	********************************************************************************************************************/
	public void verifyChatIconNotPresent()
	{
		waitForPageReady();
		if(isElementPresent(TestDataManage.getObjectProperty("LiveChatIcon_Lnk"))){
			getDetailedReport().WriteLog(Status.FAIL,"Chat Icon should not be present", "Chat Icon is present",getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS,"Chat Icon should not be present", "Chat Icon is not present",getDriver());
		}
	}	
	
	/********************************************************************************************************************
	* Method : validateViewCaseSearchForDifferentCountriesOrState
	* Description: View All cases by Search Criteria 2 for View Case. 
	* Author: Alfred Dcruz
	* Date: Jan-9-2017
	********************************************************************************************************************/
	public void validateViewCaseSearchForDifferentCountriesOrState()
	{
		String stateOrProvince = TestDataManage.getData("StateOrProvince");
		String country = TestDataManage.getData("Country");

		String countryArray[] = country.split("\\|");
		String stateOrProvinceArray[] = stateOrProvince.split("\\|");
		
		for(int i=0; i<countryArray.length; i++){
			for(int j=0; j<stateOrProvinceArray.length; j++){
				String ObjectForSelectingStateOrProvince = "//label[contains(text(),'" + stateOrProvinceArray[j] + "')]/following::input[@type='checkbox'][0]";
				waitForElement(TestDataManage.getObjectProperty("ShowMeAllForViewCase_Drpdwn"));
				selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAllForViewCase_Drpdwn"), TestDataManage.getData("ShowMeAllCategory"));
				selectbyVisibleText(TestDataManage.getObjectProperty("StatusForViewCase_Drpdwn"), TestDataManage.getData("StatusForViewCase"));
				selectbyVisibleText(TestDataManage.getObjectProperty("CountriesForViewCase_Drpdwn"), countryArray[i]);
				click(ObjectForSelectingStateOrProvince);
				click(TestDataManage.getObjectProperty("ViewCaseGo2_Btn"));
				waitForPageLoad();
				ValidateTableListForSearchCriteria2();
			}
		}
	}
	
	/********************************************************************************************************************
	* Method : ValidateTableListForSearchCriteria2
	* Description: View All cases by Search Criteria 2 for View Case. 
	* Author: Alfred Dcruz
	* Date: Jan-9-2017
	********************************************************************************************************************/
	public void ValidateTableListForSearchCriteria2()
	{
		if(isElementPresent(TestDataManage.getObjectProperty("TableListForViewCase_Table"))){
			getDetailedReport().WriteLog(Status.PASS,"Table List with all cases for search criteria should be displayed", "Table Listed successfully",getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL,"Table List with all cases for search criteria should be displayed", "Table Not Listed",getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : validateChatIconPresent
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateChatIconPresent()
	{
		waitForPageReady();
		verifyElementDisplayed("LiveChatIconImage_Lnk","Chat Icon");
	}
	
	/********************************************************************************************************************
	* Method : clickChatIcon
	* Description: Click the live Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void clickChatIcon()
	{
		waitForPageReady();
		click("LiveChatIconImage_Lnk");
	}
	
	/********************************************************************************************************************
	* Method : clickChatContinue
	* Description: Click the live Chat Continue Button 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void clickChatContinue()
	{
		waitForPageReady();
		click("ChatContinue_Button");
	}
	
	/********************************************************************************************************************
	* Method : validateProvideInformationChat
	* Description: Validate the Provide Information form in live Chat
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateProvideInformationChat()
	{
		waitForPageReady();
		verifyElementDisplayed("ChatProvideInfForm_Title","ProvideInfForm");
		waitForPageReady();
		verifyElementDisplayed("ProvideInfFormChat_Button","Chat Button");
		CheckDropdownSortList("ChatProductArea_Select");
	}
	 
	/********************************************************************************************************************
	* Method : validateChatWarning
	* Description: Validate Chat Warning without Product Area
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateChatWarning()
	{
		verifyAlertTextAndAccept("Need to check");
	}
	
	
}
