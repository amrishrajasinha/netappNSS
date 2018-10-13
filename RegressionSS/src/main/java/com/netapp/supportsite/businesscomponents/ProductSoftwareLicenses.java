package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.ProductSoftwareLicensesBase;


public class ProductSoftwareLicenses extends ProductSoftwareLicensesBase{

	/********************************************************************************************************************
	* Method : softwareLicensePageValidation
	* Description: Validate the Software License page
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void softwareLicensePageValidation(){
		verifySWLicenseSearchCriteria();
		verifyFirstSearchCriteriaDropDownList();
	}
	
	/********************************************************************************************************************
	* Method : validateMoreResourceAndFeedbakLink
	* Description: Validate the More Resource and Feedback Link
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void validateMoreResourceAndFeedbakLink(){
		verifyMoreResourceLinks();
		verifyFeedBackLink();
	}
	
	
	/********************************************************************************************************************
	* Method : validateProductDetailsHeader
	* Description: Validate the Product Details Header
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void validateProductDetailsHeader(){
		clickSearchButton();
		verifyProductDetailsHeader();
	}

}
