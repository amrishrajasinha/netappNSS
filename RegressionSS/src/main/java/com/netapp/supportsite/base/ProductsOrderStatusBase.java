package com.netapp.supportsite.base;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class ProductsOrderStatusBase extends Base{
	
	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Rajmohan Dhanapal
	* Date: Mar-07-2017 
	********************************************************************************************************************/
	public void selectCriteriaAndSearchValue()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Select_DropDown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Select_DropDown"), TestDataManage.getData("SearchType"));
		type(TestDataManage.getObjectProperty("Value_Txtbox"), TestDataManage.getData("SearchValue"));
		click("SearchGO_Btn");
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	
	}
	
	/********************************************************************************************************************
	* Method : orderStatusColumnHeaderValidation
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void orderStatusColumnHeaderValidation(){
		checkMultipleElementDisplayed("OrderStatus_Field","OrderStatusSearchColumnHeader");
	}
	
	/********************************************************************************************************************
	* Method : clickViewDetailsButton
	* Description: TO click on View Details button
	* Author: Rajmohan Dhanapal
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void clickViewDetailsButton()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ViewDetails_Button"));
		click("ViewDetails_Button");

	}
	
	/********************************************************************************************************************
	* Method : orderStatusViewDetailsFieldValidation
	* Description: Validate the View detail fields
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void orderStatusViewDetailsFieldValidation(){
		waitForPageLoad();
		checkMultipleElementDisplayed("ViewDetails_Field","OrderStatusViewDetailFields");
	}
	
	/********************************************************************************************************************
	* Method : checkOrderStatusDateFormat
	* Description: Validate Order Status Date Format
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/	
	public void checkOrderStatusDateFormat(){
		String inputDate=getElement(TestDataManage.getObjectProperty("OrderDate_Text")).getText();
		if (inputDate.matches("([0-9]{2})-([A-Z]{3})-([0-9]{4})"))
			getDetailedReport().WriteLog(Status.PASS,"Date should be in format DD-MMM-YYYY", "Date is in format DD-MMM-YYYY ",getDriver());
		else
			getDetailedReport().WriteLog(Status.FAIL,"Date should be in format DD-MMM-YYYY", "Date is not in format DD-MMM-YYYY ",getDriver());
	}
	
	/********************************************************************************************************************
	* Method : searchByOrgName
	* Description: 	Search by Organization Name
	* Author: Rajmohan Dhanapal
	* Date: Mar-08-2017 
	********************************************************************************************************************/
	public void searchByOrgName()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("OrderStatus_DropDown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("OrderStatus_DropDown"), TestDataManage.getData("OrderStatus"));
		selectbyVisibleText(TestDataManage.getObjectProperty("DateRange_DropDown"), TestDataManage.getData("DateRange"));
		click("SearchGO2_Btn");
		pause(10000);
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	
	}
	
	/********************************************************************************************************************
	* Method : verifyErrorMsgWithoutanyAnyValueInSearch
	* Description: Validate error message without entering any value in search input
	* Author: Rajmohan Dhanapal
	* Date: Mar-29-2017 
	********************************************************************************************************************/
	public void verifyErrorMsgWithoutanyAnyValueInSearch()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Select_DropDown"));
		click("SearchGO_Btn");
		waitForPageReady();
		verifyContainsText(TestDataManage.getObjectProperty("SearchWarning_Msg"),TestDataManage.getData("SearchWarning"));
	}

}
