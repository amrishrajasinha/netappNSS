package com.netapp.supportsite.base;
/**
 * Class : RequestAPartDetailsBase
 * @author : UST Global
 */

import java.io.IOException;

import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class RequestAPartDetailsBase extends Base{
	
	/********************************************************************************************************************
	* Method : AddOrder
	* Description: To add the order
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void addOrder()
	{
		waitForElementTime(TestDataManage.getObjectProperty("Qty_Txtbox"),60);	
		type(TestDataManage.getObjectProperty("Qty_Txtbox"),"1");
		click("AddToOrder_Txtbox");
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("FailureReason_Drpdwn"));
		
	}
	/********************************************************************************************************************
	* Method : submitOrder
	* Description: To submit the order
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	
	public void submitOrder(){
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("FailureReason_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("FailureReason_Drpdwn"), TestDataManage.getData("FailureReason"));
		if(isElementPresent(TestDataManage.getObjectProperty("ClusteredSytem_Drpdwn"))){
			selectbyVisibleText(TestDataManage.getObjectProperty("ClusteredSytem_Drpdwn"), TestDataManage.getData("ClusteredSystem"));
		}
		if(isElementPresent(TestDataManage.getObjectProperty("AutoSupportOFFReason_Drpdwn"))){
			selectbyVisibleText(TestDataManage.getObjectProperty("AutoSupportOFFReason_Drpdwn"), TestDataManage.getData("AutoSupportOFFReason"));
		}
		type(TestDataManage.getObjectProperty("PhoneNumber_Txtbox"), "PhoneNumber");
		//selectbyVisibleText(TestDataManage.getObjectProperty("AutoSupport_Drpdwn"), TestDataManage.getData("AutoSupportStatus"));
		//type(TestDataManage.getObjectProperty("Explanation_Txtbox"),"Test");
		if(isElementPresent(TestDataManage.getObjectProperty("DeliveryContact_Txt"))){
			type(TestDataManage.getObjectProperty("DeliveryContact_Txt"),TestDataManage.getData("PhoneNumber"));
		}
		if(isElementPresent(TestDataManage.getObjectProperty("DeliveryContactPhone_Txt"))){
			type(TestDataManage.getObjectProperty("DeliveryContactPhone_Txt"),TestDataManage.getData("PhoneNumber"));
		}
		click("DeferDelivery_Chkbox");
		selectbyVisibleText(TestDataManage.getObjectProperty("TimeZone_Drpdwn"), TestDataManage.getData("TimeZone"));
		type(TestDataManage.getObjectProperty("SpecialInstruction_Txtarea"), "FailureReason");
		click("Continue_Btn");
		waitForElement(TestDataManage.getObjectProperty("Submit_Btn"));
		click("Submit_Btn");
		
		waitForElement(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
		String PartRequestCaseNum= getText(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
		System.out.println("Part Request Case Number created: " + PartRequestCaseNum);
		getDetailedReport().WriteLog(Status.PASS, "Expected: Case Number Creation",
				"Actual: Generated case  number is " +PartRequestCaseNum, getDriver());
	}
	
	/********************************************************************************************************************
	* Method : isRootCaseAnalysisCheckboxNotDisplayed
	* Description: To validate RCA checkbox is not displayed
	* Author: Salba
	* Date: Jan-20-2017
	********************************************************************************************************************/
	
	public void isRootCaseAnalysisCheckboxNotDisplayed(){
		waitForPageReady();
		if(isElementPresent("RCA_Checkbox") && getElement("RCA_Checkbox").isDisplayed())
			getDetailedReport().WriteLog(Status.FAIL, "Expected: Root Case Analysis checbox should not be displayed ", "Actual: Root Case Analysis checkbox is displayed ", getDriver());
		else
			getDetailedReport().WriteLog(Status.PASS, "Expected: Root Case Analysis checbox should not be displayed ", "Actual: Root Case Analysis checkbox is not displayed ", getDriver());
		
			
	}
	
	/********************************************************************************************************************
	* Method : clickWhatIsThisLink
	* Description: To click the What is This link 
	* Author: Salba
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void clickWhatIsThisLink(){
		waitForPageReady();
		if(isElementPresent("What'sThis_Link")){
			click("What'sThis_Link");
			waitForPageReady();
			switchToNewWindow();
			if(isElementPresent("What'sThis_window_Text"))
				getDetailedReport().WriteLog(Status.PASS, "Expected: RMA Failure Analysis - What's This page opened in a new window ",
						"Actual: RMA Failure Analysis - What's This page opened in a new window ", getDriver());
			else
				getDetailedReport().WriteLog(Status.FAIL, "Expected: RMA Failure Analysis - What's This page opened in a new window ",
						"Actual: RMA Failure Analysis - What's This page not opened in a new window ", getDriver());
		}
	}
	/********************************************************************************************************************
	* Method : AddOrder
	* Description: To add the order for customer 
	* Author: Sreejith
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void addOrder_Customer()
	{
			waitForElementTime(TestDataManage.getObjectProperty("Qty_Txtbox"),60);	
			type(TestDataManage.getObjectProperty("Qty_Txtbox"),"1");		
			click("AddToOrder_Txtbox");
			pause(8000);
			waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
			if(isElementPresent(TestDataManage.getObjectProperty("FailureReason_Drpdwn")))
			{
				selectbyVisibleText(TestDataManage.getObjectProperty("FailureReason_Drpdwn"), TestDataManage.getData("FailureReason"));
			}
			/*waitForElement(TestDataManage.getObjectProperty("FailureReason_Drpdwn"));
			selectbyVisibleText(TestDataManage.getObjectProperty("FailureReason_Drpdwn"), TestDataManage.getData("FailureReason"));
			*/
			if(isElementPresent(TestDataManage.getObjectProperty("ClusteredSytem_Drpdwn")))
			{
				selectbyVisibleText(TestDataManage.getObjectProperty("ClusteredSytem_Drpdwn"), TestDataManage.getData("ClusteredSystem"));
			}
			if(isElementPresent(TestDataManage.getObjectProperty("Mobile_Txtbox")))
			{
				type(TestDataManage.getObjectProperty("Mobile_Txtbox"),TestDataManage.getData("PhoneNumber"));	
			}
			if(isElementPresent(TestDataManage.getObjectProperty("AutoSupport_Drpdwn")))
			{
				selectbyVisibleText(TestDataManage.getObjectProperty("AutoSupport_Drpdwn"), TestDataManage.getData("AutoSupportOFFReason"));
			}
			if(isElementPresent(TestDataManage.getObjectProperty("DeferDelivery_Chkbox")))
			{
				click("DeferDelivery_Chkbox");
			}
			if(isElementPresent(TestDataManage.getObjectProperty("DeliverTime_Drpdwn")))
			{
				selectbyVisibleText(TestDataManage.getObjectProperty("DeliverTime_Drpdwn"), TestDataManage.getData("DeliveryTime"));
			}
			
			waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));	
			click("Continue_Btn");
			if(isElementPresent(By.xpath("//*[contains(text(),'You have not completed all required fields or the information entered is not valid')]"))){
				getDetailedReport().WriteLog(Status.FAIL, "Expected: Submit Button  ",
						"Actual: Error : You have not completed all required fields or the information entered is not valid", getDriver());
			}else{
				waitForElement(TestDataManage.getObjectProperty("Submit_Btn"));
				click("Submit_Btn");
				waitForElement(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
				String PartRequestCaseNum= getText(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
				System.out.println("Part Request Case Number created: " + PartRequestCaseNum);
				getDetailedReport().WriteLog(Status.PASS, "Expected: Case Number Creation",
						"Actual: Generated case  number is " +PartRequestCaseNum, getDriver());
			}
	
			
	
	}	
}
