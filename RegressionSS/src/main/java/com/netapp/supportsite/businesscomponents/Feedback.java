package com.netapp.supportsite.businesscomponents;

import org.junit.Test;

import com.netapp.supportsite.base.FeedbackBase;

public class Feedback extends FeedbackBase{

	/********************************************************************************************************************
	* Method : validateFeedbackReportAnIssue
	* Description: To fill in all the details for case creation
	* Author: Alfred Dcruz
	* Date: February-15-2017
	********************************************************************************************************************/
	@Test
	public void validateFeedbackReportAnIssue()
	{
		submitFeedbackFormForIssueReport();
		
	}

	/********************************************************************************************************************
	* Method : verifyChatIconForAutoSupport
	* Description: validate chat icon for auto support catogery
	* Author: Alfred Dcruz
	* Date: February-15-2017
	********************************************************************************************************************/
	@Test
	public void verifyChatIconForAutoSupport()
	{
		ValidateChatIconForAutoSupportCatogery();
		
	}

}
