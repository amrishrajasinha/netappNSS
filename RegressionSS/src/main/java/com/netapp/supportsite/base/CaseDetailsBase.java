package com.netapp.supportsite.base;

/**
 * Class : CaseDetailsBase
 * @author : UST Global
 */
import com.ust.sarf.testdata.TestDataManage;

public class CaseDetailsBase extends Base
{
	public static String CaseNo;
	
	
	/********************************************************************************************************************
	 * Method : fillAndUpdateCase
	 * Description: Validate update  case note 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void fillAndUpdateCase()
	{
		
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForPageLoad();
		pause(20000);
		verifyText(TestDataManage.getObjectProperty("UpdatedNote_textarea"), TestDataManage.getData("CaseNote"));
	}
	
	
	/********************************************************************************************************************
	 * Method : verifyContactInfoAndStatus
	 * Description:  to verify the contact info and status
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void verifyContactInfoAndStatus()
	{
		verifyText(TestDataManage.getObjectProperty("FirstName_textarea"), TestDataManage.getData("FirstName"));
		verifyText(TestDataManage.getObjectProperty("lastname_textarea"), TestDataManage.getData("lastname"));
		verifyText(TestDataManage.getObjectProperty("Emailid_textarea"), TestDataManage.getData("Emailid"));
		verifyText(TestDataManage.getObjectProperty("status_textarea"), TestDataManage.getData("status"));



	}
	
	
	/********************************************************************************************************************
	 * Method : fillAndCloseCase
	 * Description: Validate close case note 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void fillAndCloseCase()
	{
	//Click close case checkbox
		checkBoxClick("CheckboxClose", "Checkbox_box");
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForStale(TestDataManage.getObjectProperty("UpdateCase_Btn"));
		//waitForPageLoad();
	//	pause(10000);
		//verifyText(TestDataManage.getObjectProperty("UpdatedNote_textarea"), TestDataManage.getData("CaseNote"));
	}
	
	

	/********************************************************************************************************************
	 * Method : fillAndCloseCase
	 * Description: Validate close case note 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void reOpenExistingcase()
	{
	//Click close case checkbox
		checkBoxClick("CheckboxClose", "Checkbox_box");
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForStale(TestDataManage.getObjectProperty("UpdateCase_Btn"));
	
		pause(8000);
		//waitForPageLoad();
		verifyContainsText(TestDataManage.getObjectProperty("status_textarea"), TestDataManage.getData("status"));
	}
	
}