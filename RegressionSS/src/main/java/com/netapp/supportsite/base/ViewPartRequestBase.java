package com.netapp.supportsite.base;
/**
 * Class : ViewPartRequestBase
 * @author : UST Global
 */
import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class ViewPartRequestBase extends Base
{
 

	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Tony George
	* Date: Feb-15-2017 
	********************************************************************************************************************/
	public void selectCriteriaAndSearchValue()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Select_DropDown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Select_DropDown"), TestDataManage.getData("SearchCriteria"));
		type(TestDataManage.getObjectProperty("Value_Txtbox"), TestDataManage.getData("SearchValue"));
		click("SearchGO_Btn");
		waitForPageLoad();
		if(!isElementPresent(TestDataManage.getObjectProperty("Details_Table")))
			getDetailedReport().WriteLog(Status.FAIL,"Expected : Details Table List with all cases for search criteria should be displayed", "Actual : Table Not Listed",getDriver());
			
			
		//waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	
	}
	 
	/********************************************************************************************************************
	* Method : selectViewCaseSearchForDifferentCountriesOrState
	* Description: View All cases by Search Criteria 2 for View Case. 
	* Author: Alfred Dcruz
	* Date: Jan-9-2017
	********************************************************************************************************************/
	public void selectViewCaseSearchForDifferentCountriesOrState()
	{
		String stateOrProvince = TestDataManage.getData("State/Province");
		String country = TestDataManage.getData("Country");

		String countryArray[] = country.split("\\|");
		String stateOrProvinceArray[] = stateOrProvince.split("\\|");
		
		for(int i=0; i<countryArray.length; i++){
			for(int j=0; j<stateOrProvinceArray.length; j++){
				
				waitForElement(TestDataManage.getObjectProperty("ShowMeAll_Drpdwn"));
				selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAll_Drpdwn"), TestDataManage.getData("ShowMeAll"));
				selectbyVisibleText(TestDataManage.getObjectProperty("Status_Drpdwn"), TestDataManage.getData("Status"));
				selectbyVisibleText(TestDataManage.getObjectProperty("State_Drpdwn"), stateOrProvinceArray[j]);
				selectbyVisibleText(TestDataManage.getObjectProperty("Country_Drpdwn"), countryArray[i]);
				getDriver().findElement(TestDataManage.getObjectProperty("Go2_Btn")).click();
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
		waitForElementTime(TestDataManage.getObjectProperty("BrowseDetails_Lbl"), 260);
		if(isElementPresent(TestDataManage.getObjectProperty("BrowseDetails_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS,"Table List with all cases for search criteria should be displayed", "Table Listed successfully",getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL,"Table List with all cases for search criteria should be displayed", "Table Not Listed",getDriver());
		}
	} 
	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Tony George
	* Date: Feb-15-2017 
	********************************************************************************************************************/
	public void verifyDetailsTableContainValue()
	{
		waitForElementTime(TestDataManage.getObjectProperty("Details_Table"), 260);
		if(isElementPresent(TestDataManage.getObjectProperty("NoResultFoundSearchTable_Lbl"))){
			getDetailedReport().WriteLog(Status.FAIL,"Table List with all cases for search criteria should be displayed", "Table Not Listed",getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS,"Table List with all cases for search criteria should be displayed", "Table Listed",getDriver());
		}
	
	}

	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Tony George
	* Date: Feb-15-2017 
	********************************************************************************************************************/
	public void selectCaseNumberFromDetailsTable()
	{
		String CaseNumber=TestDataManage.getData("SearchValue");
		By CaseElement=By.linkText(CaseNumber);
		waitForElement(CaseElement);
		click(CaseElement);
	
	}
	
	/********************************************************************************************************************
	 * Method : validateChatIconPresence
	 * Description: Verify Chat icon Present for the scenario. 
	 * Author: Tony George
	 * Date: Mar-23-2017
	 ********************************************************************************************************************/
	public void validateChatIconPresence()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ChatCaseinfo_Text"));
		waitForElement(TestDataManage.getObjectProperty("LiveChatIconImage_Lnk"));
		verifyElementDisplayed("LiveChatIconImage_Lnk","Chat Icon");
		verifyContainsText(TestDataManage.getObjectProperty("ChatTime_Text"), TestDataManage.getData("ChatHours"));
	}

	
}
