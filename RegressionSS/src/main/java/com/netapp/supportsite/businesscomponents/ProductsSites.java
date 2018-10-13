package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.ProductsSitesBase;



public class ProductsSites extends ProductsSitesBase{

	/********************************************************************************************************************
	* Method : productsSitesColumnHeaderValidation
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void productsSitesColumnHeaderValidation(){
		selectProductsSitesSearchValue();
		verifyProductsSitesColumnHeader();
		verifySerialNumberDropDownList();
	}
	
	/********************************************************************************************************************
	* Method : validateManageSiteHours
	* Description: Validate the Manage Site Hours functinality
	* Author: Rajmohan
	* Date: Mar-28-2017
	********************************************************************************************************************/
	public void validateManageSiteHours(){
		selectProductsSitesSearchValue();
		selectSerialNumber();
		setHoursOperation();
		clickSaveProfile();
		verifySuccessMessage();
	}
	
	/********************************************************************************************************************
	* Method : validateUnautorizedUserWarning
	* Description: Validate the unauthorized user error message
	* Author: Rajmohan Dhanapal
	* Date: Mar-29-2017 
	********************************************************************************************************************/
	public void validateUnautorizedUserWarning()
	{
		verifyUnautorizedUserWarning();
	}
}
