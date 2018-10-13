package com.netapp.supportsite.base;

import org.openqa.selenium.By;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

/**
 * Class : RequestAPartBase
 * @author : UST Global
 */
public class RequestAPartBase extends Base 
{
	public static String PartRequestCaseNum;

	/********************************************************************************************************************
	 * Method : SearchBasedonCriteria
	 * Description: To search for the details based on DropDown 1 and text box
	 * Author: Tony George
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void searchDetails()
	{
		waitForElement(TestDataManage.getObjectProperty("EnterValue_Txtbox"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Criteria_Drpdwn1"), TestDataManage.getData("SearchBy"));
		type(TestDataManage.getObjectProperty("EnterValue_Txtbox"), TestDataManage.getData("Value"));
		click("Go_Btn");
		waitForPageReady();

	}

	/********************************************************************************************************************
	 * Method : SearchBasedonCriteria
	 * Description: To search for the details based on the dropdown 2 
	 * Author: Tony George
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void searchDetailsByCategory()
	{
		waitForElement(TestDataManage.getObjectProperty("Criteria_Drpdwn2"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Criteria_Drpdwn2"), TestDataManage.getData("SearchBy"));
		click("Go2_Btn");
		pause(5000);
		waitForPageReady();
	}

	/********************************************************************************************************************
	 * Method : browseByMyCustomer
	 * Description: To search for the details based on My Customer dropdown
	 * Author: Tony George
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void browseByMyCustomer()
	{
		waitForElement(TestDataManage.getObjectProperty("MyCustomerSearch_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("MyCustomerSearch_Drpdwn"), TestDataManage.getData("SearchBy"));
		click("GoMyCustomerSearch_Btn");
		waitForPageReady();

	}

	/********************************************************************************************************************
	 * Method : clickGoForPartNumber
	 * Description: To search for the details based on the criteria
	 * Author: Tony George
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void clickGoForPartNumber()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("SelectedPartNumberGo_Btn"));
		click("SelectedPartNumberGo_Btn");
		waitForPageReady();

	}

	/********************************************************************************************************************
	 * Method : verifyInvalidSystemorHostError
	 * Description: To search for the details based on the criteria without entering any value for list.
	 * Author: Alfred Dcruz
	 * Date: Feb-9-2017 
	 ********************************************************************************************************************/
	public void verifyInvalidSystemorHostError()
	{
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("InvalidSystemOrHostError_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Invalid System/Host Error should be displayed", "Error displayed succesfully", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Invalid System/Host Error should be displayed", "Error not dosplayed - FAIL", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : verifySupportErrorDisplayedForSearch
	 * Description: To search for the details based on the criteria without entering any value for list.
	 * Author: Alfred Dcruz
	 * Date: Feb-9-2017 
	 ********************************************************************************************************************/
	public void verifySupportErrorDisplayedForSearch()
	{
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("SupportError_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Suport Error Page should be displayed", "Error displayed succesfully", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Suport Error Page should be displayed", "Error not displayed - FAIL", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : validateTitleExpiredContract
	 * Description: To Verify Expired Contract Serial Number URL
	 * Author: Alfred Dcruz
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void validateTitleExpiredContract()
	{
		waitForPageLoad();
		String url = getCurrentUrl();
		if(url.contains("expiredContract")){
			getDetailedReport().WriteLog(Status.PASS, "Expected: Title should contain Expired Contract", "Actual: URL contains expired contract ", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Expected: Title should contain Expired Contract", "Actual: URL does not contain expired contract ", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : ClickOnGoFromDetailsTable
	 * Description: To click on the go button from the details table
	 * Author: Alfred Dcruz(Not Duplicate for Continue, Donot Delete Since required for middle page verification)
	 * Date: Jan-20-2017
	 ********************************************************************************************************************/
	public void clickOnCreateNewCaseButton()
	{
		waitForElementTime(TestDataManage.getObjectProperty("CreateNewCase_Btn"),60);
		if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))){
			waitForElement(TestDataManage.getObjectProperty("CreateNewCase_Btn"));
			click("CreateNewCase_Btn");
		}

	}

	/********************************************************************************************************************
	 * Method : clickCreateNewCaseOrContinueButton
	 * Description: To create a new case for part request
	 * Author: Tony George
	 * Date: Jan-20-2017
	 ********************************************************************************************************************/
	public void clickCreateNewCaseOrContinueButton()
	{
		// Click on continue if Expired Serial number page is displayed.
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_Btn"))){
			if(getDriver().findElement(TestDataManage.getObjectProperty("Continue_Btn")).isDisplayed())
			{
				click(TestDataManage.getObjectProperty("Continue_Btn"));
			}
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))){
			if(getElement(TestDataManage.getObjectProperty("CreateNewCase_Btn")).isDisplayed()){
				waitForElement(TestDataManage.getObjectProperty("CreateNewCase_Btn"));
				click("CreateNewCase_Btn");
			}
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_Btn"))){
			if(getDriver().findElement(TestDataManage.getObjectProperty("Continue_Btn")).isDisplayed()){
				waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
				click("Continue_Btn");
			}
		}

	}
	/********************************************************************************************************************
	 * Method : clickCreateNewCaseOrContinueAgreementButton
	 * Description: To create a new case for part request
	 * Author: Alfred Dcruz
	 * Date: Jan-20-2017
	 ********************************************************************************************************************/
	public void clickCreateNewCaseOrContinueAgreementButton()
	{
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))){
			waitForElement(TestDataManage.getObjectProperty("CreateNewCase_Btn"));
			click("CreateNewCase_Btn");
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueAgreement_Btn"))){
			waitForElement(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
			click("ContinueAgreement_Btn");
		}

	}
	/********************************************************************************************************************
	 * Method : SearchPartsByCriteria
	 * Description: To search for parts by criteria
	 * Author: Tony George
	 * Date: Jan-20-2017
	 ********************************************************************************************************************//*
	public void searchPartsByCriteria()
	{
		waitForElement(TestDataManage.getObjectProperty("Catogery_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Catogery_Drpdwn"), TestDataManage.getData("Catogery"));
		if(!TestDataManage.getData("Keywords").equals("^"))
		{
			type(TestDataManage.getObjectProperty("Keyword_Txtbox"), TestDataManage.getData("Keywords"));
		}
		click("SearchByCatogeryFind_Btn");


	}*/

	/********************************************************************************************************************
	 * Method : clickGoForPartNumberAutoSupportONorOFF
	 * Description: To search for the details based on the criteria
	 * Author: Alfred Dcruz
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void clickGoForPartNumberAutoSupportONorOFF()
	{
		int i=1, clickSuccess = 0, maxLength = 200, location = 0;
		Boolean serialNotFound = false, serialFound = false;
		String autoSupportStatus = TestDataManage.getData("AutoSupportStatus");
		waitForPageLoad();
		do{
			for(i=location;i<=maxLength;i++){
				if(isElementPresent(By.xpath(String.format(TestDataManage.getObjectValue("AutoSupportStatus_Lbl"),Integer.toString(i))))){
					String statusFromList = getText(By.xpath(String.format(TestDataManage.getObjectValue("AutoSupportStatus_Lbl"),Integer.toString(i))));
					if(statusFromList.contains(autoSupportStatus)){
						getDriver().findElement(By.xpath(String.format(TestDataManage.getObjectValue("SerialNumberForAutoStatus_Btn"),Integer.toString(i)))).click();
						clickSuccess = 1;
						serialFound = true;
						break;
					}
				}
			}
			if(i>200 && isElementPresent(TestDataManage.getObjectProperty("ShowMoreRecord_Lnk"))){
				click(TestDataManage.getObjectProperty("ShowMoreRecord_Lnk"));
				location = location + 200;
				maxLength = maxLength + location;
				serialNotFound = false;
			}else{
				serialNotFound = true;
			}
		}while(serialNotFound == false && serialFound != true);
		if(clickSuccess!=1){
			getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Go for required criteria should be clicked.", "Click did not happen - FAIL", getDriver());
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
		String serialnumber=TestDataManage.getData("Value");
		getDriver().findElement(By.xpath(setXpath(TestDataManage.getObjectValue("SubmitRequest_Btn"),serialnumber)));
		getDriver().findElement(By.xpath(setXpath(TestDataManage.getObjectValue("SubmitRequest_Btn"),serialnumber))).click();
		pause(4000);
		waitForPageLoad();
		waitForPageReady();
		if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))==true)
		{
			click("CreateNewCase_Btn");
		}

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
		if(isDisplayedWait(TestDataManage.getObjectProperty("Continue_Btn")))
		{
			click("Continue_Btn");
		}
		/*else
			getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Continue Button for Contract", "Actual Continue Button is not present.", getDriver()); 
		 */
	}

	/********************************************************************************************************************
	 * Method : VerifyChatIconNotPresent
	 * Description: To accept the expired agreement 
	 * Author: Alfred Dcruz
	 * Date: Feb-14-2017 
	 ********************************************************************************************************************/
	public void VerifyChatIconNotPresent()
	{
		waitForPageReady();
		pause(7000);
		if(!isElementPresent(TestDataManage.getObjectProperty("Chat_Icon"))){
			getDetailedReport().WriteLog(Status.PASS, "Element Not present: Chat Icon. Expected Element should not  be present", "Actual element not present.", getDriver()); 
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Chat Icon. Expected Element should not  be present", "Actual element is present.", getDriver()); 
		}
	}

	/********************************************************************************************************************
	 * Method : VerifyChatIconPresent
	 * Description: To accept the expired agreement 
	 * Author: Alfred Dcruz
	 * Date: Feb-14-2017 
	 ********************************************************************************************************************/
	public void verifyChatIconPresent()
	{
		waitForPageReady();
		waitForElementTime(TestDataManage.getObjectProperty("Chat_Icon"), 60);
		if(isElementPresent(TestDataManage.getObjectProperty("Chat_Icon"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: Chat Icon. Expected Element should be present", "Actual element is present.", getDriver()); 
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Chat Icon. Expected Element should be present", "Actual element is not present.", getDriver()); 
		}
	}

	/*  Duplicate	*//********************************************************************************************************************
	 * Method : searchCriteriaDirectly
	 * Description: To search for the details based on the criteria without entering any value for list.
	 * Author: Alfred Dcruz
	 * Date: Feb-9-2017 
	 ********************************************************************************************************************//*
	public void searchCriteriaDirectly()
	{
		waitForElement(TestDataManage.getObjectProperty("SelectByCatogeryDirect_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("SelectByCatogeryDirect_Drpdwn"), TestDataManage.getData("SearchBy"));
		click("ShowAllSerialNumberGo_Btn");
		waitForElement(TestDataManage.getObjectProperty("Details_Table"));
	}*/
	/********************************************************************************************************************
	 * Method : VerifyChatIconNotPresent
	 * Description: To accept the expired agreement 
	 * Author: Tony George
	 * Date: Feb-14-2017 
	 ********************************************************************************************************************/
	public void verifyChatIconAndHoverText()
	{
		waitForPageLoad();
		waitForPageReady();
		if(isDisplayedWait(TestDataManage.getObjectProperty("Chat_Icon"))){
			waitForElement(TestDataManage.getObjectProperty("Chat_Icon"));
			String hovertext=getDriver().findElement(By.xpath("//img[@id='chatImage']")).getAttribute("title");
			if(hovertext.contains(TestDataManage.getData("ChatHoverText")))
			{
				getDetailedReport().WriteLog(Status.PASS, "The text "+TestDataManage.getData("ChatHoverText")+"should be present when hovered on the chat icon","The text "+TestDataManage.getData("ChatHoverText")+"is present when hovered on the chat icon" ,getDriver());	
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "The text "+TestDataManage.getData("ChatHoverText")+"should be present when hovered on the chat icon","The text "+TestDataManage.getData("ChatHoverText")+"is not present when hovered on the chat icon" ,getDriver());	
			}
		}else
			getDetailedReport().WriteLog(Status.FAIL, "Expected : The chat icon should be present .","Actual : Chat icon is not present ." ,getDriver());	

	}
	/********************************************************************************************************************
	 * Method : VerifySearchRMANotPreset
	 * Description: To verify that the user have no access to the RMA search
	 * Author: Tony George
	 * Date: Feb-17-2017 
	 ********************************************************************************************************************/
	public void verifyRMASearchNotPreset()
	{
		waitForPageLoad();
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("RequestRMA_Btn"));
		if(verifyElementNotPresent("EnterValue_Txtbox")==true)
		{
			getDetailedReport().WriteLog(Status.PASS, "User should not have access to search RMA","User is not having access to search RMA" ,getDriver());	
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "User should not have access to search RMA","User is  having access to search RMA" ,getDriver());		
		}


	}
	/********************************************************************************************************************
	 * Method : VerifySearchRMANotPreset
	 * Description: To verify that the user have no access to view RMA
	 * Author: Tony George
	 * Date: Feb-17-2017 
	 ********************************************************************************************************************/
	public void verifyUserNotAbleToViewRMA()
	{
		waitForPageLoad();
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("RequestRMA_Btn"));
		if(verifyElementNotPresent("SelectByCatogeryDirect_Drpdwn")==true)
		{
			getDetailedReport().WriteLog(Status.PASS, "User should not have access to view RMA","User is not having access to view RMA" ,getDriver());	
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "User should not have access to view RMA","User is  having access to view RMA" ,getDriver());		
		}


	}


	/********************************************************************************************************************
	 * Method : OpenChatIntakeForm
	 * Description: To open the chat intake form
	 * Author: Tony George
	 * Date: Feb-21-2017 
	 ********************************************************************************************************************/
	public void openChatIntakeForm()
	{
		if(isDisplayedWait(TestDataManage.getObjectProperty("Chat_Icon"))){
			click("Chat_Icon");
			waitForElement(TestDataManage.getObjectProperty("ContinueChat_Btn"));
			click("ContinueChat_Btn");
		}else
			getDetailedReport().WriteLog(Status.FAIL, "Expected : Chat icon to be present . ", "Actual : Chat icon not present . ", getDriver());



	}

	/********************************************************************************************************************
	 * Method : VerifyChatIntakeForm
	 * Description: To verify the chat intake form
	 * Author: Tony George
	 * Date: Feb-21-2017 
	 ********************************************************************************************************************/
	public void verifyChatIntakeForm()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatIntakeSerial_Txtbox"));
		verifyElementIsDisable("ChatIntakeSerial_Txtbox");
		verifyContainsValue(TestDataManage.getObjectProperty("ChatIntakeSerial_Txtbox"), TestDataManage.getData("Value"));
		verifyElementEnabled("ChatIntakeFirstName_Txtbox");
		verifyContainsValue(TestDataManage.getObjectProperty("ChatIntakeFirstName_Txtbox"), TestDataManage.getData("FirstName"));
		verifyElementEnabled("ChatIntakeLastName_Txtbox");
		verifyContainsValue(TestDataManage.getObjectProperty("ChatIntakeLastName_Txtbox"), TestDataManage.getData("LastName"));
		verifyElementEnabled("ChatIntakeEmail_Txtbox");
		verifyContainsValue(TestDataManage.getObjectProperty("ChatIntakeEmail_Txtbox"), TestDataManage.getData("Email"));
		clearTextBox("ChatIntakeEmail_Txtbox");
		type(TestDataManage.getObjectProperty("ChatIntakeEmail_Txtbox"), "netapp@test.com");
		verifyElementNotPresent("ChatIntakeProductArea_Select");
		verifyElementNotPresent("ChatIntakeCaseCatogery_Select");
		verifyContainsText(TestDataManage.getObjectProperty("ChatIntakeChatNote_Txt"), TestDataManage.getData("ChatNote"));
	}



	/********************************************************************************************************************
	 * Method : clickSerialNumberFromBrowseListForRequestAPart
	 * Description: To search for the details based on the criteria
	 * Author: Alfred Dcruz
	 * Modified:Tony George
	 * Date: Jan-20-2017 
	 ********************************************************************************************************************/
	public void clickSerialNumberFromBrowseListForRequestAPart()
	{
		String serialNumber = TestDataManage.getData("Value");
		
		
		while(isElementPresent(TestDataManage.getObjectProperty("ShowMoreRecord_Lnk")))
		{
			click(TestDataManage.getObjectProperty("ShowMoreRecord_Lnk"));
			waitForPageLoad();	
			pause(4000);
		}	
		for(int i=1;i<=500;i++)
		{
			if(isElementPresent(By.xpath(String.format(TestDataManage.getObjectValue("SerialNumberBrowseList_Lbl"),Integer.toString(i)))))
			{

				String statusFromList = getText(By.xpath(String.format(TestDataManage.getObjectValue("SerialNumberBrowseList_Lbl"),Integer.toString(i))));
				if(statusFromList.contains(serialNumber))
				{
					getDriver().findElement(By.xpath(String.format(TestDataManage.getObjectValue("GoForSerialBrowse_Btn"),Integer.toString(i)))).click();
					waitForPageLoad();
					pause(2000);
					if(isElementPresent(TestDataManage.getObjectProperty("CreateNewCase_Btn"))==true)
					{
						//click("CreateNewCase_Btn");
						clickCreateNewCaseOrContinueButton();
					}
					getDetailedReport().WriteLog(Status.PASS, "Case invalid. Go for required criteria should be clicked.", "Click  happened - PASS", getDriver());
					break;
				}
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Go for required criteria should be clicked.", "Click did not happen - FAIL", getDriver());
				break;
			}
		}
	}


	/********************************************************************************************************************
	 * Method : OpenChatIntakeForm
	 * Description: To open the chat intake form
	 * Author: Tony George
	 * Date: Feb-21-2017 
	 ********************************************************************************************************************/
	public void clickOnChatbuttonAndVerifyNewTab()
	{
		String winbefore=getDriver().getWindowHandle();
		waitForElement(TestDataManage.getObjectProperty("Chat_Btn"));
		click("Chat_Btn");
		pause(4000);
		switchToNewWindow();
		getDriver().getWindowHandle();
		verifyTitle("Support Live Chat");
		getDriver().switchTo().window(winbefore);	


	}
	/********************************************************************************************************************
	 * Method : SelectSiteAndClickFindRMA
	 * Description: To Select the site and find RMA
	 * Author: Tony George
	 * Date: Feb-23-2017
	 ********************************************************************************************************************/
	public void selectSiteAndClickFindRMA()
	{
		waitForElement(TestDataManage.getObjectProperty("SelectSite_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("SelectSite_Drpdwn"), TestDataManage.getData("SiteName"));
		click("RequestRMA_Btn");
	}
	/********************************************************************************************************************
	 * Method : VerifyDetailsTable
	 * Description: To verify the Details table
	 * Author: Tony George
	 * Date: Feb-24-2017
	 ********************************************************************************************************************/
	public void verifyDetailsTable()
	{
		verifyContainsText(TestDataManage.getObjectProperty("Search_Text"), "To submit an RMA, please first query the affected system using the search options below.");
		checkMultipleElementDisplayed("Details_Table","SerialNumberDetails");
		verifyContainsText(TestDataManage.getObjectProperty("SerialNumber_DetailsTableTxt"), TestDataManage.getData("Value"));
		verifyOptionPresentInDropDown("RequestTypeDetailsTable_Drpdwn","Replacement");
		verifyOptionPresentInDropDown("RequestTypeDetailsTable_Drpdwn","Dead On Arrival");
	}

}
