package com.netapp.supportsite.base;
/**
 * Class : AboutPartReturnsBase
 * @author : UST Global
 */

import com.ust.sarf.testdata.TestDataManage;

public class AboutPartReturnsBase extends Base{
	
	
	/********************************************************************************************************************
	* Method : verifyAboutPartReturnsPage
	* Description: To verify the About Part Returns & Replacements page links and paragraphs
	* Author: Rajmohan Dhanapal
	* Date: Feb-21-2017 
	********************************************************************************************************************/

	public void verifyAboutPartReturnsPage(){
		verifyContainsText(TestDataManage.getObjectProperty("AboutPartReturnsPara1_Text"),TestDataManage.getData("AboutPartReturnsPara1"));
		verifyContainsText(TestDataManage.getObjectProperty("AboutPartReturnsPara2_Text"),TestDataManage.getData("AboutPartReturnsPara2"));
		verifyContainsText(TestDataManage.getObjectProperty("AboutPartReturnsPara3_Text"),TestDataManage.getData("AboutPartReturnsPara3"));
		checkMultipleElementDisplayed("AboutPartReturns_Link1","AboutPartReturnsLinks1");
		checkMultipleElementDisplayed("AboutPartReturns_Link2","AboutPartReturnsLinks2");
	}

}
