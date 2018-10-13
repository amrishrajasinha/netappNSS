package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.ContractsAndWarrantiesBase;


public class ContractsAndWarranties extends ContractsAndWarrantiesBase{
	
	/********************************************************************************************************************
	* Method : searchAndVerifyColumnHeader
	* Description: Select a search criteria and Validate column header
	* Author: Rajmohan Dhamnapal
	* Date: Mar-07-2017
	********************************************************************************************************************/
	public void searchAndVerifyColumnHeader()
	{
		selectCriteriaAndSearchValue();
		searchColumnHeaderValidation();
	}	
	
	/********************************************************************************************************************
	* Method : validateRequestToBuyPage
	* Description: To verify the Request to Buy or Renew Contract page links and paragraphs
	* Author: Rajmohan Dhanapal
	* Date:Mar-09-2017 
	********************************************************************************************************************/

	public void validateRequestToBuyPage(){
		searchByShowMeAll();
		clickCheckboxAndRenewBuyButton();
		verifyRequestToBuyPage();
	}

}
