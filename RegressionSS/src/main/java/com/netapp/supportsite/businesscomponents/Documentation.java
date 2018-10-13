package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.DocumentationBase;

public class Documentation extends DocumentationBase {
	
	/********************************************************************************************************************
	* Method : validateUnLoggedDocumentaionPage
	* Description: To validate the UnLogged Documentaion Page
	* Author: Rajmohan Dhanapal
	* Date: March-27 -2017
	********************************************************************************************************************/
	
	public void validateUnLoggedDocumentaionPage(){
		waitForPageReady(); 
		verifyUnloggedDocumentPageWarning();
		clickSearchDocumentLink();
		verifyDocumentSearch();
		validateHTMLPDFDocumentPresence();
	}

}
