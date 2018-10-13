package com.netapp.supportsite.base;

import com.ust.sarf.testdata.TestDataManage;

public class ProductsSitesBase extends Base{
	
	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Rajmohan Dhanapal
	* Date: Mar-07-2017 
	********************************************************************************************************************/
	public void selectProductsSitesSearchValue()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("State_Dropdown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("State_Dropdown"), TestDataManage.getData("StateValue"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Country_Dropdown"), TestDataManage.getData("CountryValue"));
		click("SearchGO_Btn");
		pause(10000);
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	
	}
	
	/********************************************************************************************************************
	* Method : verifyProductsSitesColumnHeader
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifyProductsSitesColumnHeader(){
		checkMultipleElementDisplayed("SearchColumnHeader_Field","ProductsSitesSearchColumnHeader");
	}
	
	/********************************************************************************************************************
	* Method : verifySerialNumberDropDownList
	* Description: Validate the Serial number drop down list
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifySerialNumberDropDownList(){
		String dropDownList = TestDataManage.getData("SerialNumberDropDownList").trim();
		if(dropDownList.contains("|")){
			String[] dropDownValue = dropDownList.split("[|]");
			int len = dropDownValue.length;
			for(int i=0;i<len;i++ ){
				waitForPageLoad();
				String data = dropDownValue[i];
		        verifyOptionPresentInDropDown("SerialNumber_Select",data);
			}
		}
	}
	
	/********************************************************************************************************************
	* Method : selectSerialNumber
	* Description: To Select the SerialNumber
	* Author: Rajmohan Dhanapal
	* Date: Mar-28-2017 
	********************************************************************************************************************/
	public void selectSerialNumber()
	{
		waitForPageReady();		
		selectbyVisibleText(TestDataManage.getObjectProperty("SerialNumber_Select"), TestDataManage.getData("SerialNumberValue"));
		click("SerialNumberSearchGO_Btn");
		Boolean isGoPresent = false;
		try{
			isGoPresent = isElementPresent(TestDataManage.getObjectProperty("SerialNumberSearchGO_Btn"));
		}catch(Exception e){
			
		}
		if(isGoPresent)
			click("SerialNumberSearchGO_Btn");
		waitForPageReady();	
	}
	
	/********************************************************************************************************************
	* Method : setHoursOperation
	* Description: To set the values for Hours Operation
	* Author: Rajmohan Dhanapal
	* Date: Mar-28-2017 
	********************************************************************************************************************/
	public void setHoursOperation()
	{
		
		waitForPageReady();	
		waitForElement(TestDataManage.getObjectProperty("ModayStartTime_Select"));
		selectbyVisibleText(TestDataManage.getObjectProperty("ModayStartTime_Select"), TestDataManage.getData("MondayStartTime"));
		selectbyVisibleText(TestDataManage.getObjectProperty("ModayEndTime_Select"), TestDataManage.getData("MondayEndTime"));
		clickIfNotClicked("TuesdayClosed_Checkbox");
		clickIfNotClicked("WednesdayClosed_Checkbox");
		clickIfNotClicked("ThursdayClosed_Checkbox");
		clickIfNotClicked("FridayClosed_Checkbox");
		clickIfNotClicked("SaturdayClosed_Checkbox");
		clickIfNotClicked("SundayClosed_Checkbox");
		waitForPageReady();	
	}

	/********************************************************************************************************************
	* Method : clickSaveProfile
	* Description: Click the Save profile button
	* Author: Rajmohan Dhanapal
	* Date: Mar-28-2017 
	********************************************************************************************************************/
	public void clickSaveProfile()
	{
		waitForPageReady();	
		click("CopytoEngineerArrival_Button");
		waitForPageReady();	
		clickIfNotClicked("Onsite_Checkbox");
		waitForPageReady();	
		click("SaveSiteProfile_Button");
		waitForPageReady();	
	}
	
	/********************************************************************************************************************
	* Method : verifySuccessMessage
	* Description: Validate the success message
	* Author: Rajmohan Dhanapal
	* Date: Mar-28-2017 
	********************************************************************************************************************/
	public void verifySuccessMessage()
	{
		verifyContainsText(TestDataManage.getObjectProperty("Success_Msg"),TestDataManage.getData("SuccessMessage"));
	}
	
	/********************************************************************************************************************
	* Method : verifyUnautorizedUserWarning
	* Description: Validate the unauthorized user error message
	* Author: Rajmohan Dhanapal
	* Date: Mar-29-2017 
	********************************************************************************************************************/
	public void verifyUnautorizedUserWarning()
	{
		waitForPageReady();	
		verifyContainsText(TestDataManage.getObjectProperty("UnauthorizedUserErrorHeader_Msg"),TestDataManage.getData("UnauthorizedUserErrorHeader"));
		verifyContainsText(TestDataManage.getObjectProperty("UnauthorizedUserErrorPara1_Msg"),TestDataManage.getData("UnauthorizedUserErrorPara1"));
		verifyContainsText(TestDataManage.getObjectProperty("UnauthorizedUserErrorPara2_Msg"),TestDataManage.getData("UnauthorizedUserErrorPara2"));
		verifyContainsText(TestDataManage.getObjectProperty("UnauthorizedUserErrorPara3_Msg"),TestDataManage.getData("UnauthorizedUserErrorPara3"));
	}
}
