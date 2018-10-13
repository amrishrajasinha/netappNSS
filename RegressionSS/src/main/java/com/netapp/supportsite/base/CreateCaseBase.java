package com.netapp.supportsite.base;
/**
 * Class : CreateCaseBase
 * @author : UST Global
 */

import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class CreateCaseBase extends Base
{
	public static String CaseNo;
	
	/********************************************************************************************************************
	* Method : fillCaseAndContactPage
	* Description: Fill case and Contact Page and create case.
	* Author: Alfred Dcruz
	* Modified:Sreejith
	* Description: Added extra  time to handle the wait
	* Date: Feb-23-2017
	********************************************************************************************************************/
	public void fillCaseAndContactPage()
	{
		waitForPageLoad();
		sleepFor(8000);
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueCaseCreation_Link")))
		{
			click(TestDataManage.getObjectProperty("ContinueCaseCreation_Link"));
		}
		sleepFor(8000);
		waitForElement(TestDataManage.getObjectProperty("IssueObservered_Txtarea"));
		type(TestDataManage.getObjectProperty("IssueObservered_Txtarea"), TestDataManage.getData("IssueObserved"));
		type(TestDataManage.getObjectProperty("MaintainanceActivities_Txtarea"), TestDataManage.getData("RecentChanges"));
		type(TestDataManage.getObjectProperty("OSVersion_Txtarea"), TestDataManage.getData("OSVersion"));
		type(TestDataManage.getObjectProperty("DescribeEnviornmnet_Txtarea"), TestDataManage.getData("Enviornment"));
		if(isElementPresent(TestDataManage.getObjectProperty("AutoSupportOFFReason_Drpdwn")))
		selectbyVisibleText(TestDataManage.getObjectProperty("AutoSupportOFFReason_Drpdwn"),TestDataManage.getData("AutoSupportOFFReason"));
		click("CaseCreationGo_Btn");
		waitForPageLoad();
		waitForElementTime(TestDataManage.getObjectProperty("CaseNumber_Txt"), 180);
		String caseNum= getText(TestDataManage.getObjectProperty("CaseNumber_Txt"));
		CaseNo=caseNum;
		getDetailedReport().WriteLog(Status.PASS, "Verifying Case for the user", "Case successfully created - "+caseNum+" . ", getDriver());
	}

	
	/********************************************************************************************************************
	* Method : validateChatIconPresent
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateChatIconPresent()
	{
		waitForPageReady();
		//Verify user is in Case and Contact Page		
		waitForElement(TestDataManage.getObjectProperty("IssueObservered_Txtarea"));
		verifyElementDisplayed("LiveChatIconImage_Lnk","Chat Icon");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : validateLiveChatTiming
	* Description: Verify the timings of the live chat
	* Author: Tony George
	* Date: March-14-2016
	********************************************************************************************************************/
	public void validateLiveChatTiming()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatTiming_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("ChatTiming_Txt"), TestDataManage.getData("ChatTiming"));
		
	}
	
	
	
	/********************************************************************************************************************
	* Method : validateChatIconNotPresent
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	public void validateChatIconNotPresent()
	{
		waitForPageReady();
		//Verify user is in Case and Contact Page		
		waitForElement(TestDataManage.getObjectProperty("IssueObservered_Txtarea"));
		if(isElementPresent("LiveChatIconImage_Lnk")==false){
			getDetailedReport().WriteLog(Status.PASS, " Expected: Chat Icon should Not be Displyaed", "Actual: Chat Icon Not Displayed. ", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, " Expected: Chat Icon should Not be Displyaed", "Actual: Chat Icon Displayed. ", getDriver());
		}
		waitForPageReady();
		
	}
	
	/********************************************************************************************************************
	* Method : clickChatIcon
	* Description: Click the live Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void clickChatIcon()
	{
		waitForPageReady();
		click("LiveChatIconImage_Lnk");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : clickChatContinue
	* Description: Click the live Chat Continue Button 
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void clickChatContinue()
	{
		waitForPageReady();
		click("ChatContinue_Button");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : validateProvideInformationChat
	* Description: Validate the Provide Information form in live Chat
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateProvideInformationChat()
	{
		waitForPageReady();
		verifyElementDisplayed("ChatProvideInfForm_Title","ProvideInf");
		waitForPageReady();
		verifyElementDisplayed("ProvideInfFormChat_Button","Chat Button");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : validateChatWarningForProductArea
	* Description: Validate Chat Warning without Product Area
	* Author: Rajmohan Dhanapal
	* Date: Jan-10-2017
	********************************************************************************************************************/
	public void validateChatWarningForProductArea()
	{
		verifyAlertTextAndAccept("Product Area can't be empty!");
	}
	
	/********************************************************************************************************************
	* Method : validateProductAreaDropDownSort
	* Description: Validate the Product Area Drop Down is sorted 
	* Author: Rajmohan Dhanapal
	* Date: Jan-17-2017
	********************************************************************************************************************/
	public void validateProductAreaDropDownSort()
	{
		waitForPageReady();
		verifyElementDisplayed("ChatProvideInfForm_Title","ProvideInf");
		waitForPageReady();
		CheckDropdownSortList("ChatProductArea_Select");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : validateProductAreaDefaultDropDown
	* Description: Validate the Product Area default Drop Down value
	* Author: Rajmohan Dhanapal
	* Date: Jan-17-2017
	********************************************************************************************************************/
	public void validateProductAreaDefaultDropDown()
	{
		waitForPageReady();
		verifyElementDisplayed("ChatProvideInfForm_Title","ProvideInf");
		waitForPageReady();
		checkDefaultDropdownValue("ChatProductArea_Select","Select One");
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : clickChatButton
	* Description: Click the live Chat Button in intake form
	* Author: Rajmohan Dhanapal
	* Date: FEB-17-2017
	********************************************************************************************************************/
	public void clickChatButton()
	{
		waitForElement(TestDataManage.getObjectProperty("ProvideInfFormChat_Button"));
		click("ProvideInfFormChat_Button");
	}
	/********************************************************************************************************************
	* Method : validateChatIntakeText
	* Description: validate Chat Intake Text
	* Author: Harish
	* Date: FEB-21-2017
	********************************************************************************************************************/
	public void validateChatIntakeText()
	{
		waitForElement(TestDataManage.getObjectProperty("Chat_IntakeText"));
		verifyElementDisplayed("Chat_IntakeText","Chat Intake text");
	}
	

	/********************************************************************************************************************
	 * Method : updatecase
	 * Description: Validate update  case note 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void fillAndUpdateCase()
	{
		waitForElement(TestDataManage.getObjectProperty("Opencase_Link"));
		click("Opencase_Link");
		waitForElement(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"));
		type(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"), TestDataManage.getData("ProblemSummary"));
		fillCaseAndContactPage();
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("UpdatedNote_textarea"), TestDataManage.getData("CaseNote"));
	}

	/********************************************************************************************************************
	 * Method : updateCase
	 * Description: set priority level
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void setPriorityLevel()
	{
		waitForElement(TestDataManage.getObjectProperty("Opencase_Link"));
		click("Opencase_Link");
		waitForElement(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"));
		type(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"), TestDataManage.getData("ProblemSummary"));
		fillCaseAndContactPage();
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("UpdatedNote_textarea"), TestDataManage.getData("CaseNote"));


	}

	/********************************************************************************************************************
	 * Method : createCasePriority
	 * Description: To set the case priority
	 * Author: Sreejith
	 * Date: February-16-2017
	 ********************************************************************************************************************/

	public void createCasePriority()
	{
		sleepFor(8000);
		setXpath("Priorityselect_RadioBtn", "PrioritySelection");
		String PriorityValue=setXpath("Priorityselect_RadioBtn", "PrioritySelection");
		waitForElementTime(By.xpath(setXpath("Priorityselect_RadioBtn", "PrioritySelection")), 100);
		boolean isChecked=getDriver().findElement(By.xpath(PriorityValue)).isSelected();
		boolean isEnabled=getDriver().findElement(By.xpath(PriorityValue)).isEnabled();
		boolean isVisible=getDriver().findElement(By.xpath(PriorityValue)).isDisplayed();
		if(isVisible&&isEnabled)
		{
			if(!isChecked)
			{
				getDriver().findElement(By.xpath(PriorityValue)).click();
				getDetailedReport().WriteLog(Status.PASS, "Field Details: verfying text: "+PriorityValue+ ". Expected Button/Link  click", "Actual text is  present .", getDriver());
			}

			if(TestDataManage.getData("PrioritySelection").contains("P1"))
			{
				type(TestDataManage.getObjectProperty("BussinessImpacted_Txtarea"), TestDataManage.getData("BussinessImpacted"));
				type(TestDataManage.getObjectProperty("Downtime_Txtarea"), TestDataManage.getData("Downtime"));
			}
			else if (TestDataManage.getData("PrioritySelection").contains("P2"))
			{
				type(TestDataManage.getObjectProperty("BussinessImpacted_Txtarea"), TestDataManage.getData("BussinessImpacted"));
			}
		}
		waitForPageReady();

	}


	/********************************************************************************************************************
	 * Method : updatecase
	 * Description: Validate update  case note 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void createCaseSetPriorityLevel()
	{
		openCase();
		waitForElement(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"));
		type(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"), TestDataManage.getData("ProblemSummary"));
		createCasePriority();
		fillCaseAndContactPage();
		type(TestDataManage.getObjectProperty("Casenote_textarea"), TestDataManage.getData("CaseNote"));
		click("UpdateCase_Btn");
		waitForStale(TestDataManage.getObjectProperty("UpdateCase_Btn"));
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("UpdatedNote_textarea"), TestDataManage.getData("CaseNote"));

	}
	/********************************************************************************************************************
	 * Method : openCase
	 * Description: To open a new case 
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void openCase()
	{
		waitForElement(TestDataManage.getObjectProperty("Opencase_Link"));
		click("Opencase_Link");

	}


	/********************************************************************************************************************
	 * Method : createCasePriorityLevel1
	 * Description: To set the case priority
	 * Author: Sreejith
	 * Date: February-16-2017
	 ********************************************************************************************************************/

	public void createCasePriorityLevel1()
	{
		pause(3000);
		setXpath("Priorityselect_RadioBtn", "PrioritySelection");
	}
	

	/********************************************************************************************************************
	 * Method : verifyChatSetPriorityLevel1
	 * Description: To set priority 1 for verifying the chat icon
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void verifyChatSetPriorityLevel1()
	{
		
		waitForElement(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"));
		type(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"), TestDataManage.getData("ProblemSummary"));
		createCasePriority();
		

	}
	/********************************************************************************************************************
	* Method : verifyPriorityP1Message
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Alfred Dcruz
	* Date: Feb-14-2017
	********************************************************************************************************************/
	public void verifyPriorityP1Message()
	{
		waitForPageReady();
		//Verify user is in Case and Contact Page		
		waitForElement(TestDataManage.getObjectProperty("PriorityP1Message_Lbl"));
		if(isElementPresent("PriorityP1Message_Lbl")==true){
			getDetailedReport().WriteLog(Status.PASS, " Expected: Priority P1 Message should be displayed", "Actual: Message Displayed. ", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, " Expected: Priority P1 Message should be displayed", "Actual: Message not displayed. ", getDriver());
		}
		waitForPageReady();
		
	}
	
	/********************************************************************************************************************
	* Method : clickCancelChat
	* Description: To click the Cancel link in chat form
	* Author: Salba
	* Date: Feb-28-2017
	********************************************************************************************************************/
	public void clickCancelChat(){
		waitForPageLoad();
		click("CancelChat_Link");
		waitForPageLoad();
		if(isElementPresent("CancelChat_Link")){
			if(getElement("CancelChat_Link").isDisplayed()){
				getDetailedReport().WriteLog(Status.FAIL, " Expected: Chat form should close", "Actual: Chat form not closed. ", getDriver());
		}
		
		}else{
			getDetailedReport().WriteLog(Status.PASS, " Expected: Chat form should close", "Actual: Chat form closed. ", getDriver());
		}
		
	}
	
	/********************************************************************************************************************
	 * Method : updatecase
	 * Description: to close a  case  with update note
	 * Author: Sreejith
	 * Date: Feb-15-2017
	 ********************************************************************************************************************/
	public void closeCaseSetPriorityLevel()
	{
		//openCase();
		sleepFor(8000);
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueCaseCreation_Link")))
		{
			click(TestDataManage.getObjectProperty("ContinueCaseCreation_Link"));
		}
		sleepFor(8000);
		isDisplayedWait(TestDataManage.getObjectProperty("Opencase_Link"));
		if(isElementPresent(TestDataManage.getObjectProperty("Opencase_Link")))
		{
		click("Opencase_Link");
		}
		pause(10000);
		waitForElement(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"));
		type(TestDataManage.getObjectProperty("ProblemSummary_Txtarea"), TestDataManage.getData("ProblemSummary"));
		createCasePriority();
		fillCaseAndContactPage();
		

	}
	
}
