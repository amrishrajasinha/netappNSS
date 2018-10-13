package com.netapp.supportsite.base;

import com.ust.sarf.testdata.TestDataManage;

public class ProductSoftwareLicensesBase extends Base{

	
	/********************************************************************************************************************
	* Method : verifySWLicenseSearchCriteria
	* Description: Validate the searche criteria in Software License
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifySWLicenseSearchCriteria(){
		checkMultipleElementDisplayed("SearchCriteria_Text","SoftwareLicenseSearchCriteria");
	}
	
	/********************************************************************************************************************
	* Method : verifyFirstSearchCriteriaDropDownList
	* Description: Validate the Serial number drop down list
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifyFirstSearchCriteriaDropDownList(){
		String dropDownList = TestDataManage.getData("SearchCiteria1DropDownList").trim();
		if(dropDownList.contains("|")){
			String[] dropDownValue = dropDownList.split("[|]");
			int len = dropDownValue.length;
			for(int i=0;i<len;i++ ){
				waitForPageLoad();
				String data = dropDownValue[i];
		        verifyOptionPresentInDropDown("SearchCiteria1_Select",data);
			}
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyMoreResourceLinks
	* Description: Validate the More Resource links
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifyMoreResourceLinks(){
		checkMultipleElementDisplayed("SoftwareLicense_Link","MoreResourcesLinks");
	}
	
	/********************************************************************************************************************
	* Method : verifyFeedBackLink
	* Description: Validate the Feedback Link
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifyFeedBackLink(){
		click("Feedback_Link");
		waitForPageLoad();
		verifyPageTitle("Give Us Feedback");
	}
	
	/********************************************************************************************************************
	* Method : verifyFeedBackLink
	* Description: Validate the Feedback Link
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void clickSearchButton(){
		click("SearchGO2_Btn");
		waitForPageLoad();
		pause(8000);
	}
	
	/********************************************************************************************************************
	* Method : verifyProductDetailsHeader
	* Description: Validate the Product Details header
	* Author: Rajmohan
	* Date: Mar-08-2017
	********************************************************************************************************************/
	public void verifyProductDetailsHeader(){
		waitForClickable(TestDataManage.getObjectProperty("EmailResults_Btn"));
		checkMultipleElementDisplayed("ProductDetails_Field","ProductDetailsField");
	}
}
