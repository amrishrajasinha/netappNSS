package com.netapp.supportsite.base;

import com.ust.sarf.testdata.TestDataManage;

public class DocumentationBase extends Base {
	
	public void verifyUnloggedDocumentPageWarning(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("UnloggedWarning_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("UnloggedWarning_Text"),TestDataManage.getData("UnloggedWarning"));
	}
	
	/********************************************************************************************************************
	* Method : clickSearchDocumentLink
	* Description: To click the Search Document Link
	* Author: Rajmohan Dhanapal
	* Date: Mar-27-2017 
	********************************************************************************************************************/
	public void clickSearchDocumentLink()
	{
		waitForPageReady();
		click("DocumentName_Link");
	
	}
	
	/********************************************************************************************************************
	* Method : verifyDocumentSearch
	* Description: To verify the Serched Document
	* Author: Rajmohan Dhanapal
	* Date:Mar-27-2017 
	********************************************************************************************************************/

	public void verifyDocumentSearch(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("DocumentName_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("DocumentName_Text"),TestDataManage.getData("DocumentName"));
	}
	
	
	/********************************************************************************************************************
	 * Method : validateHTMLPDFDocumentPresence
	 * Description: Verify HTML and PDF document link. 
	 * Author: Rajmohan Dhanapal
	 * Date: March-27-2017
	 ********************************************************************************************************************/
	public void validateHTMLPDFDocumentPresence()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("DocumentPDF_Link"));
		verifyElementDisplayed("DocumentPDF_Link","PDF Document LInk");
		verifyElementDisplayed("DocumentHTML_Link","HTML Document LInk");
	}

}
