package com.netapp.supportsite.base;

import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class FeedbackBase extends Base {
	
	/********************************************************************************************************************
	* Method : submitFeedbackFormForIssueReport
	* Description: Enter values for Feedback form and submit.
	* Author: Alfred Dcruz
	* Date: Feb-15-2017
	********************************************************************************************************************/
	public void submitFeedbackFormForIssueReport(){
		
		/*waitForPageLoad();
		click(By.id("cboxClose"));*/
		waitForElement(TestDataManage.getObjectProperty("Category1_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Category1_Drpdwn"), TestDataManage.getData("Category1"));
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("Category2_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Category2_Drpdwn"), TestDataManage.getData("Category2"));
		type(TestDataManage.getObjectProperty("Comments_Txtarea"), TestDataManage.getData("Comments"));
		click(TestDataManage.getObjectProperty("submit_Btn"));
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("FeedbackSubmitted_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Feedback Form submitted succesfully displayed", "Feedback Form submitted", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Feedback Form submitted succesfully displayed", "Feedback Form Not submitted - FAIL", getDriver());
		}
	}

	/********************************************************************************************************************
	* Method : ValidateChatIconForAutoSupportCatogery
	* Description: validate chat icon present for autosupport catogery
	* Author: Tony George
	* Date: March-23-2017
	********************************************************************************************************************/
	public void ValidateChatIconForAutoSupportCatogery()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("Category1_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Category1_Drpdwn"), TestDataManage.getData("Category1"));
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("LiveChatIconImage_Lnk"));
		verifyElementDisplayed("LiveChatIconImage_Lnk","Chat Icon");
		verifyContainsText(TestDataManage.getObjectProperty("ChatTime_Text"), TestDataManage.getData("ChatHours"));
		
	}
	
	
	
}
