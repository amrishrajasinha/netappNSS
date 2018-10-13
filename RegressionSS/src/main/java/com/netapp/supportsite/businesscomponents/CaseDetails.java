package com.netapp.supportsite.businesscomponents;
/**
 * Class : CaseDetails
 * @author : UST Global
 */

import com.netapp.supportsite.base.CaseDetailsBase;

public class CaseDetails extends CaseDetailsBase
{
	/********************************************************************************************************************
	 * Method : verifyCaseDetailInfo
	 * Description: To verify the case details info page
	 * Author: Sreejith
	 * Date: February-23-2017
	 ********************************************************************************************************************/
	public void verifyCaseDetailInfo()
	{
		verifyContactInfoAndStatus();

	}
	
	/********************************************************************************************************************
	 * Method : updateAndVerifyCaseNote
	 * Description: To verify the case details info page
	 * Author: Alfred
	 * Date: February-23-2017
	 ********************************************************************************************************************/
	public void updateAndVerifyCaseNote()
	{
		fillAndUpdateCase();

	}
	/********************************************************************************************************************
	 * Method : updateAndVerifyCaseNote
	 * Description: To  close a existing case
	 * Author: Sreejith
	 * Date: march-20-2017
	 ********************************************************************************************************************/
	public void closeCase()
	{
		waitForPageReady();
		fillAndCloseCase();

	}
	
	/********************************************************************************************************************
	 * Method : updateAndVerifyCaseNote
	 * Description: To  close a existing case
	 * Author: Sreejith
	 * Date: march-20-2017
	 ********************************************************************************************************************/
	public void verifyReopenCaseScenario()
	{
		waitForPageReady();
		reOpenExistingcase();

	}
	
}