package com.netapp.supportsite.base;

import com.ust.sarf.testdata.TestDataManage;

public class ContractsAndWarrantiesBase extends Base{
	
	/********************************************************************************************************************
	* Method : SelectCriteriaAndSearchValue
	* Description: To Select the dropdown and search for a value
	* Author: Rajmohan Dhanapal
	* Date: Mar-09-2017 
	********************************************************************************************************************/
	public void selectCriteriaAndSearchValue()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Select_DropDown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Select_DropDown"), TestDataManage.getData("SearchType"));
		type(TestDataManage.getObjectProperty("Value_Txtbox"), TestDataManage.getData("SearchValue"));
		click("SearchGO_Btn");
		pause(5000);
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	
	}
	
	/********************************************************************************************************************
	* Method : searchColumnHeaderValidation
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Mar-09-2017
	********************************************************************************************************************/
	public void searchColumnHeaderValidation(){
		checkMultipleElementPresent("Search_Field","SearchColumnHeader");
	}
	
	/********************************************************************************************************************
	* Method : searchByShowMeAll
	* Description: 	Search by Show me all
	* Author: Rajmohan Dhanapal
	* Date: Mar-09-2017 
	********************************************************************************************************************/
	public void searchByShowMeAll()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("ShowMeAll_DropDown"));
		selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAll_DropDown"), TestDataManage.getData("ShowMeAll"));
		click("SearchGO2_Btn");
		waitForElementTime(TestDataManage.getObjectProperty("Details_Table"), 150);
	
	}
	
	/********************************************************************************************************************
	* Method : clickCheckboxAndRenewBuyButton
	* Description: To click the Checkbox, RenewBuy Button And Submit
	* Author: Rajmohan Dhanapal
	* Date: Mar-09-2017 
	********************************************************************************************************************/
	public void clickCheckboxAndRenewBuyButton()
	{
		waitForPageReady();
		click("Renew_Checkbox");
		waitForPageReady();
		click("BuyRenew_Button");
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Company_Txtbox"));
		type(TestDataManage.getObjectProperty("Company_Txtbox"),TestDataManage.getData("Company"));
		click("SubmitRequest_Button");
	
	}
	
	/********************************************************************************************************************
	* Method : verifyRequestToBuyPage
	* Description: To verify the Request to Buy or Renew Contract page links and paragraphs
	* Author: Rajmohan Dhanapal
	* Date:Mar-09-2017 
	********************************************************************************************************************/

	public void verifyRequestToBuyPage(){
		waitForElement(TestDataManage.getObjectProperty("RequesttoBuy_Text"));
		pause(5000);
		verifyContainsText(TestDataManage.getObjectProperty("RequesttoBuy_Text"),TestDataManage.getData("RequesttoBuyText"));
	}


}
