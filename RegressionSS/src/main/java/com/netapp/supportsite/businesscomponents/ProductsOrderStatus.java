package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.ProductsOrderStatusBase;

public class ProductsOrderStatus extends ProductsOrderStatusBase{
	
	/********************************************************************************************************************
	* Method : searchAndVerifyOrderStatusFields
	* Description: Select a search criteria and search for a value
	* Author: Rajmohan Dhamnapal
	* Date: Mar-07-2017
	********************************************************************************************************************/
	public void searchAndVerifyOrderStatusFields()
	{
		selectCriteriaAndSearchValue();
		orderStatusColumnHeaderValidation();
		clickViewDetailsButton();
		orderStatusViewDetailsFieldValidation();
		checkOrderStatusDateFormat();	
	}	
	
	/********************************************************************************************************************
	* Method : searchByOrgNameAndVerifyColumnHeader
	* Description: Search by Organization Name and validate Column Header
	* Author: Rajmohan Dhamnapal
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void searchByOrgNameAndVerifyColumnHeader()
	{
		searchByOrgName();
		orderStatusColumnHeaderValidation();	
	}
	
	/********************************************************************************************************************
	* Method : searchAndVerifyOrderStatusColumnHeader
	* Description: Select a search criteria and search for a value
	* Author: Rajmohan Dhamnapal
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void searchAndVerifyOrderStatusColumnHeader()
	{
		selectCriteriaAndSearchValue();
		orderStatusColumnHeaderValidation();		
	}
	
	/********************************************************************************************************************
	* Method : validateErrorMsgWithoutanyAnyValueInSearch
	* Description: Validate error message without entering any value in search input
	* Author: Rajmohan Dhanapal
	* Date: Mar-29-2017 
	********************************************************************************************************************/
	public void validateErrorMsgWithoutanyAnyValueInSearch()
	{
		verifyErrorMsgWithoutanyAnyValueInSearch();
	}

}
