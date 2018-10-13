package com.netapp.supportsite.base;
/**
 * Class : PartBase
 * @author : UST Global
 */

import org.openqa.selenium.By;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class PartBase extends Base
{
	public static String PartRequestCaseNum;
	
	/********************************************************************************************************************
	* Method : SearchBasedonCriteria
	* Description: To search for the details based on the criteria
	* Author: Tony George
	* Date: Jan-20-2017 
	********************************************************************************************************************/
	public void searchDetails()
	{
		waitForElement(TestDataManage.getObjectProperty("EnterValue_Txtbox"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Criteria_Drpdwn"), TestDataManage.getData("SearchCriteria"));
		type(TestDataManage.getObjectProperty("EnterValue_Txtbox"), TestDataManage.getData("Data"));
		click("Go_Btn");
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));

	}
	
	/********************************************************************************************************************
	* Method : searchCriteriaDirectly
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void searchCriteriaDirectly()
	{
		waitForElement(TestDataManage.getObjectProperty("SelectByCatogeryDirect_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("SelectByCatogeryDirect_Drpdwn"), TestDataManage.getData("SearchCriteria"));
		click("ShowAllSerialNumberGo_Btn");
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	}

	/********************************************************************************************************************
	* Method : ClickOnGoFromDetailsTable
	* Description: To click on the go button from the details table
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void clickOnGoFromDetailsTable()
	{
		waitForElement(TestDataManage.getObjectProperty("DetailTableGo_Btn"));
		click("DetailTableGo_Btn");

	}
	/********************************************************************************************************************
	* Method : CreateNewCase
	* Description: To create a new case for part request
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void createNewCase()
	{
		// Click on continue if Expired Serial number page is displayed.
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_Btn"))){
			click(TestDataManage.getObjectProperty("Continue_Btn"));
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))){
		waitForElement(TestDataManage.getObjectProperty("CreateNewCase_Btn"));
		click("CreateNewCase_Btn");
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_Btn"))){
		waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
		click("Continue_Btn");
		}

	}
	/********************************************************************************************************************
	* Method : SearchPartsByCriteria
	* Description: To search for parts by criteria
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void searchPartsByCriteria()
	{
		waitForElement(TestDataManage.getObjectProperty("Catogery_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Catogery_Drpdwn"), TestDataManage.getData("Catogery"));
		if(!TestDataManage.getData("Keywords").equals("^"))
		{
			type(TestDataManage.getObjectProperty("Keyword_Txtbox"), TestDataManage.getData("Keywords"));
		}
		click("SearchByCatogeryFind_Btn");
		

	}

	/********************************************************************************************************************
	* Method : AddOrder
	* Description: To add the order
	* Author: Tony George
	* Date: Jan-20-2017
	********************************************************************************************************************/
	public void addOrder()
	{
		waitForElement(TestDataManage.getObjectProperty("Qty_Txtbox"));	
		type(TestDataManage.getObjectProperty("Qty_Txtbox"),TestDataManage.getData("Qty"));
		click("AddToOrder_Txtbox");
		waitForElement(TestDataManage.getObjectProperty("FailureReason_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("FailureReason_Drpdwn"), TestDataManage.getData("FailureReason"));
		type(TestDataManage.getObjectProperty("PhoneNumber_Txtbox"),"1234567");
		selectbyVisibleText(TestDataManage.getObjectProperty("AutoSupport_Drpdwn"), TestDataManage.getData("AutoSupportStatus"));
		type(TestDataManage.getObjectProperty("Explanation_Txtbox"),"Test");
		click("DeferDelivery_Chkbox");
		selectbyVisibleText(TestDataManage.getObjectProperty("TimeZone_Drpdwn"), TestDataManage.getData("TimeZone"));
		type(TestDataManage.getObjectProperty("SpecialInstruction_Txtarea"),"Test");
		click("Continue_Btn");
		waitForElement(TestDataManage.getObjectProperty("Submit_Btn"));
		click("Submit_Btn");
		
		waitForElement(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
		PartRequestCaseNum= getText(TestDataManage.getObjectProperty("RequestPartCaseNo_Txt"));
		System.out.println("Part Request Case Number created: " + PartRequestCaseNum);
	}

	/********************************************************************************************************************
	* Method : SearchPartRequestDetails
	* Description: To search for the part request details
	* Author: Tony George
	* Date: Jan-23-2017
	********************************************************************************************************************/
	public void searchPartRequestDetails()
	{
		
		waitForElement(TestDataManage.getObjectProperty("Criteria_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Criteria_Drpdwn"), TestDataManage.getData("SelectionCatogery"));
		type(TestDataManage.getObjectProperty("EnterValue_Txtbox"),PartRequestCaseNum);
		click("Go_Btn");
		

	}
	
	/********************************************************************************************************************
	* Method : browsePartFieldValidation
	* Description: Validate the fields in Browse Parts fields
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartFieldValidation(){
		checkMultipleElementDisplayed("BrowseParts_Field","BrowsePartsFields");
		verifyElementDisplayed("BrowseFindPart1_Button","Search by Part Number");
		verifyElementDisplayed("BrowseFindPart2_Button","Search by 'sysconfig' Output");
		verifyElementDisplayed("BrowseFindPart3_Button","Search by Category");
	}
	
	/********************************************************************************************************************
	* Method : browsePartSearchByPartNumber
	* Description: Search Part number using SearchByPartNumber 
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartSearchByPartNumber(){
		type(TestDataManage.getObjectProperty("FindByPartNO_Input"), TestDataManage.getData("BrowsePartsPartNumber"));
		click("BrowseFindPart1_Button");
	}

	/********************************************************************************************************************
	* Method : BrowsePartsColumnHeaderValidation
	* Description: Validate the searched fields Column headers
	* Author: Rajmohan
	* Date: Feb-07-2017
	********************************************************************************************************************/
	public void browsePartsColumnHeaderValidation(){
		checkMultipleElementDisplayed("BrowseParts_Field","BrowsePartsSearchColumnHeader");
		verifyElementDisplayed("BrowsePartsNewSearch_Button","Search Button");
	}

	public void validateSearchedValuesinBrowserParts(){
		String givenPartNumber = TestDataManage.getData("BrowsePartsPartNumber").trim();
		String validPartNumber;
		if(!givenPartNumber.equalsIgnoreCase("^")){
			if(givenPartNumber.contains("*")){
				validPartNumber = givenPartNumber.split("[*]")[0];
			}
			else{
				validPartNumber=givenPartNumber;
			}
			String partNumberCount=getText("BrowsePartsSearchCount_Text").trim();
			partNumberCount=partNumberCount.split("[:]")[1];
			partNumberCount=partNumberCount.trim();
			int countPartNumber = Integer.parseInt(partNumberCount);
			for(int i=1;i<=countPartNumber;i++){
				String data = String.format(TestDataManage.getObjectValue("BrowsePartsSearchResult_Text", "xpath"), i);
				if(getDriver().findElement(By.xpath(data)).getText().contains(validPartNumber)){
					getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected Given Value"+" "+validPartNumber, "Actual Value"+ " "+getDriver().findElement(By.xpath(data)).getText()+" Contains given value "+validPartNumber, getDriver());
				}
				else{
					getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected Given Value", "Actual Value"+ " "+getDriver().findElement(By.xpath(data)).getText(), getDriver());
				}
				
			}
	}
	}
	/********************************************************************************************************************
	* Method : searchCriteriaDirectly
	* Description: To search for the details based on the criteria without entering any value for list.
	* Author: Alfred Dcruz
	* Date: Feb-9-2017 
	********************************************************************************************************************/
	public void FindSerialNumberAndClickGo()
	{
		String serialnumber=TestDataManage.getData("Data");
		getDriver().findElement(By.xpath(setXpath(TestDataManage.getObjectValue("SubmitRequest_Btn"),serialnumber)));
		getDriver().findElement(By.xpath(setXpath(TestDataManage.getObjectValue("SubmitRequest_Btn"),serialnumber))).click();
		/*for(int i=110;i<=200;i++)
		{
			String SerialNumber=getDriver().findElement(By.xpath("//div[text()='Serial Number']/following::table["+i+"]")).getText();
			if(SerialNumber.contains(TestDataManage.getData("Data")))
			{
				getDriver().findElement(By.xpath("//div[text()='Serial Number']/following::table["+i+"]/following::input")).click();
				getDetailedReport().WriteLog(Status.PASS, "Click on GO Button", "Clicked on GO Button", getDriver());
			}
					
			
		}*/
	}

	/********************************************************************************************************************
	* Method : AcceptAgreement
	* Description: To accept the expired agreement 
	* Author: Tony George
	* Date: Feb-14-2017 
	********************************************************************************************************************/
	public void AcceptAgreement()
	{
		waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
		click("Continue_Btn");
		
	}

	/********************************************************************************************************************
	* Method : VerifyChatIconNotPresent
	* Description: To accept the expired agreement 
	* Author: Tony George
	* Date: Feb-14-2017 
	********************************************************************************************************************/
	public void VerifyChatIconNotPresent()
	{
		waitForPageLoad();
		waitForPageReady();
		verifyElementNotPresent("Chat_Icon");
		
	}








}
