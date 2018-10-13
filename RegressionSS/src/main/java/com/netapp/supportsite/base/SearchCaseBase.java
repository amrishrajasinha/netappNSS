package com.netapp.supportsite.base;
/**
 * Class : SearchCaseBase
 * @author : UST Global
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.netapp.supportsite.businesscomponents.GPS;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class SearchCaseBase extends Base
{

	/********************************************************************************************************************
	 * Method : setbrowseProductAffected
	 * Description: To Browse the product affected and click Go Button
	 * Author: Alfred Dcruz
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void setBrowseProductAffected()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("Browse_Btn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Browse_Btn"), TestDataManage.getData("Search|BrowseCriteria"));
		click("Go_Btn");
		waitForPageReady();
	}

		
	/********************************************************************************************************************
	 * Method : selectFirstSerialNumberFromBrowseList
	 * Description: To Browse the product affected and click Go Button
	 * Author: Alfred Dcruz
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void selectFirstSerialNumberFromBrowseList()
	{
		waitForPageReady();
		//waitForElementTime(TestDataManage.getObjectProperty("NextPage_Link"),300);
		waitForElementTime(TestDataManage.getObjectProperty("GoFirstFromBrowseList_Btn"),300);
		click("GoFirstFromBrowseList_Btn");
	}
	
	/********************************************************************************************************************
	 * Method : validateSerialNumberNotDisplayed
	 * Description: To Validate Serial number not available for the user.
	 * Author: Alfred Dcruz
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void validateSerialNumberNotDisplayed()
	{
		waitForElementTime(TestDataManage.getObjectProperty("SerialNumberSearchNotFound_Lbl"), 120);
		if(isElementPresent(TestDataManage.getObjectProperty("SerialNumberSearchNotFound_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Serial Number should not be listed for User", "Serial number not displayed: Error Displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "Serial Number should not be listed for User", "Serial number displayed - FAIL", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : searchForSerialNumberForCreateCase
	 * Description: To Search for a serial number to select
	 * Author: Alfred Dcruz
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void searchForProductAffected()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("SerialNumber_Txtbox"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Search_Drpdwn"), TestDataManage.getData("Search|BrowseCriteria"));
		type(TestDataManage.getObjectProperty("SerialNumber_Txtbox"), TestDataManage.getData("SerialNumber"));
		click("Go_Btn");
		pause(5000);
		waitForPageReady();
	
	}
	
	/********************************************************************************************************************
	 * Method : verifyDeclinedPageForCreateCase
	 * Description: To Search for a serial number to select
	 * Author: Alfred Dcruz
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void verifyDeclinedPageForCreateCase()
	{
		waitForPageReady();
		waitForElementTime(TestDataManage.getObjectProperty("DeclinedLable_Lbl"), 60);
		if(isElementPresent(TestDataManage.getObjectProperty("DeclinedLable_Lbl"))){
			getDetailedReport().WriteLog(Status.PASS, "Declined Label should be displayed", "Declined Label displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Declined Label should be displayed", "Declined Label not displayed - FAIL", getDriver());
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyBrowserDropdown
	* Description: To verify the presence of verify drop down window
	* Author: Sreejith
	* Date: Feb-15-2017
	********************************************************************************************************************/
	public void verifyBrowserDropdown()
	{
		waitForPageReady();
		if(isElementPresent(TestDataManage.getObjectProperty("Browse_Btn"))){
			getDetailedReport().WriteLog(Status.PASS, "verfying the presence of browse drop down", "Browser Drop down is displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "verfying the presence of browse drop down", "Browser Drop down is not  displayed", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : selectSearchResult
	 * Description: To click on the Select link against the Search Result
	 * Author: Salba
	 * Date: Jan-13-2017
	 ********************************************************************************************************************/
	public void selectSearchResult(){
		waitForPageReady();
		waitForElementTime(TestDataManage.getObjectProperty("Select_Link"),60);
		click("Select_Link");
		getDetailedReport().WriteLog(Status.PASS,"Selecting a  Serial number ", "Serial number selected is  : "+TestDataManage.getData("SerialNumber"),getDriver());
		waitForPageLoad();

	}

	/********************************************************************************************************************
	 * Method : clickCreateCaseAnywayLink
	 * Description: To click on the Select link against the Search Result
	 * Author: Alfred
	 * Date: Jan-13-2017
	 ********************************************************************************************************************/
	public void clickCreateCaseAnywayLink(){
		waitForPageReady();
		waitForElementTime(TestDataManage.getObjectProperty("CreatecaseAnyway_link"),60);
		click("CreatecaseAnyway_link");
	}
		
	/********************************************************************************************************************
	 * Method : selectSerialNumberFromBrowseList
	 * Description: To select required serial number from listed table
	 * Author: Alfred Dcruz
	 * Modified : Salba ( added break statements )
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	/*public void selectSerialNumberFromBrowseList()
	{		
		waitForPageLoad();
		int count=0, i=10;
		String serialNo = TestDataManage.getData("SerialNumber");
		//waitForElementTime(TestDataManage.getObjectProperty("Location_Lbl"),200);
		waitForElementTime(By.xpath("//*[contains(text(),'Records')]"),200);
		waitForPageLoad();
		// Searching the serial number is present in the page
		while(isElementPresent(By.xpath(setXpath("SerialNumberToSelect_Lnk","SerialNumber"))) == false){
			if(waitForClickable(TestDataManage.getObjectProperty("NextPage_Link")) && i>0)
			{
				click("NextPage_Link");
				waitForPageReady();
				try {
					waitForElementTime(By.xpath(setXpath("SerialNumberToSelect_Lnk","SerialNumber")), 10);
				} catch (Exception e) {

				}
				i--;
			}
			else{
				getDetailedReport().WriteLog(Status.FAIL,"Searched for Serial number : "+serialNo+" . ", "Serial number : "+serialNo+" not found",getDriver());
				count = -1;
				break;
				
			}
		}

		// Clicking the Select against the Serial number
		if(count == 0){
			for(int j=1;j<25;j++){

				//String serial_number = getText(By.xpath("//tr["+j+"]/td[2]/span/span[@class='margin9 wrapText wrapContent']"));
				String serial_number = getText(By.xpath(String.format(TestDataManage.getObjectValue("SerialNo_Text", "XPATH"), j)));
				if(serial_number.equals(TestDataManage.getData("SerialNumber")))
				{
					By selectXpath = By.xpath(String.format(TestDataManage.getObjectValue("Select_SerialNumber_Link","XPATH"), j));
					//By selectXpath = By.xpath(String.format("//*[text()='%s']/ancestor::td[1]/preceding-sibling::td[1]//a",serialNo));
					click(selectXpath);
					getDetailedReport().WriteLog(Status.PASS,"Selecting a  Serial number ", "Serial number selected is  : "+serialNo,getDriver());
					break;
				}
			}
		}
		waitForPageLoad();

	}
	*/
	/********************************************************************************************************************
	 * Method : selectSerialNumberFromBrowseList
	 * Description: To select required serial number from listed table
	 * Author: Salba
	 * Date: February-21-2017
	 ********************************************************************************************************************/
	public void selectSerialNumberFromBrowseList()
	{		
		waitForPageLoad();
		String serialNo = TestDataManage.getData("SerialNumber").trim();
		pause(4000);
		//waitForElementTime(TestDataManage.getObjectProperty("Location_Lbl"),200);
		waitForElementTime(TestDataManage.getObjectProperty("Records_Text"),200);
		waitForPageLoad();
		boolean serialNoFound = false; 
		By serialNoXpath =By.xpath(String.format(TestDataManage.getObjectValue("SerialNo_Text","XPATH"),serialNo));
		// Searching the serial number is present in the page
		while(!serialNoFound)
		{
			isDisplayedWait(serialNoXpath);
			// Checking Serial Number is present
			if(isElementPresent(serialNoXpath)){
				serialNoFound = true;
				By selectXpath = By.xpath(String.format(TestDataManage.getObjectValue("SerialNo_SelectLink"),serialNo));
				click(selectXpath);
				getDetailedReport().WriteLog(Status.PASS,"Searched for Serial number : "+serialNo+" . ",
						"Clicked the Serial number : "+serialNo+" .",getDriver());
			}else if(isElementPresent("NextPage_Link")){
				// Checking the NextPage link is present and it is enabled
				if(!getDriver().findElement(TestDataManage.getObjectProperty("NextPage_Link")).getAttribute("class").toLowerCase().contains("disabled")){
						click("NextPage_Link");
						getDetailedReport().WriteLog(Status.PASS,"Searched for Serial number : "+serialNo+" . ",
								"Serial number : "+serialNo+" not found, Navigating to Next Page",getDriver());
						waitForStale(TestDataManage.getObjectProperty("NextPage_Link"));
						waitForPageLoad();
								
				}else{// Searched all pages . But data not found
					getDetailedReport().WriteLog(Status.FAIL,"Searched for Serial number "+serialNo+" in all Pages", 
							"Serial number : "+serialNo+" not found",getDriver());
					break;
				}
			}else {
				getDetailedReport().WriteLog(Status.FAIL,"Searched for Serial number "+serialNo+" .", 
						"Serial number : "+serialNo+" not found",getDriver());
				break;
			}
		}
		waitForPageLoad();
	}

	/********************************************************************************************************************
	 * Method : describeTheProblemForCase
	 * Description: Describe the case by answering the Questions and commenting reason for the case.
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void describeTheProblemForCase()
	{
		switchToNewWindow();
		chooseDropDown("Catogery1", "Question1_Drpdwn");
		chooseDropDown("Catogery2", "Question2_Drpdwn");
		chooseDropDown("Catogery3", "Question3_Drpdwn");
		type(TestDataManage.getObjectProperty("Description_Txtarea"), TestDataManage.getData("Description"));
		click("ProblemGo_Btn");
		pause(2000);
		waitForPageLoad();
	}

	/********************************************************************************************************************
	 * Method : problemDescriptionForCreateCaseAnyway
	 * Description: Describe the case by answering the Questions and commenting reason for the case.
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void problemDescriptionForCreateCaseAnyway()
	{
		sleepFor(5000);
		switchToNewWindow();
		chooseDropDown("Catogery1", "Question1_Drpdwn");
		chooseDropDown("Catogery2", "Question2_Drpdwn");
		chooseDropDown("Catogery3", "Question3_Drpdwn");
		type(TestDataManage.getObjectProperty("Description_Txtarea"), TestDataManage.getData("Description"));
		type(TestDataManage.getObjectProperty("ProductNumber_Txtarea"), TestDataManage.getData("ProductNumber"));
		type(TestDataManage.getObjectProperty("OSversion_Txtarea"), TestDataManage.getData("OSVersion"));
		click("ProblemGo_Btn");
		waitForPageLoad();
	}
	
	/********************************************************************************************************************
	 * Method : problemDescriptionForCreateCaseAnyway
	 * Description: Describe the case by answering the Questions and commenting reason for the case.
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void verifyProblemDescriptionForCreateCaseAnyway()
	{
		waitForElement(TestDataManage.getObjectProperty("Question1_Drpdwn"));
		switchToNewWindow();
		if(isElementPresent(TestDataManage.getObjectProperty("Question1_Drpdwn")) && isElementPresent(TestDataManage.getObjectProperty("Description_Txtarea"))){
			getDetailedReport().WriteLog(Status.PASS, "Problem Description Page should be displayed with all fields", "Required is displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Problem Description Page should be displayed with all fields", "Required is not  displayed", getDriver());
		}		
		waitForPageLoad();
	}
	/********************************************************************************************************************
	 * Method : veriifySearchResultColumns
	 * Description: Verify the column names in the Search Result
	 * Author: Salba
	 * Date: Jan-10-2017
	 ********************************************************************************************************************/
	public void verifySearchResultColumns(){
		waitForPageLoad();
		// Wait till result table is displayed
		String searchResultLocator = TestDataManage.getObjectValue("SearchResultColumnNames_Table");
		pause(5000);
		waitForElementTime(By.xpath(String.format(searchResultLocator ,"2")), 240);

		if(isElementPresent("NoSearchResultErrorMessage_Text")){
			getDetailedReport().WriteLog(Status.FAIL, "Verify the columns in the Search Result", 
					"There were no results found for your search. Please check the search criteria selected above and try your search again.", getDriver());
		}else{

			// Setting the header names to be searched 
			String[] columnNames = {"Serial Number", "Cluster Serial Number", "Cluster Name", "Location", "System Name",
					"Product Number", "OS Version", "Auto Support Status", "Group"};
			int j =0;
			boolean status = true ;
			for(int i= 2; i<=9; i++){
				if(!verifyText(By.xpath(String.format(searchResultLocator,i)), columnNames[j++])){
					getDetailedReport().WriteLog(Status.FAIL, "Verify the columns in the Search Result", "Column "+columnNames[j-1]+"is not present", getDriver());
					status = false;
				}
			}
			if(status){
				getDetailedReport().WriteLog(Status.PASS, "Verify the columns in the Search Result", "Search results contain the following columns:"
						+ "- Serial Number \n"
						+ "- Cluster Serial Number \n"
						+ "- Cluster Name \n"
						+ "- Location \n"
						+ "- System Name \n"
						+ "- Product Number \n"
						+ "- OS Version \n"
						+ "- AutoSupport Status \n"
						+ "- Group", getDriver());
			}
		}
		waitForPageLoad();
	}



	//Commneting - Use clickContinueButton() method
	/*	*//********************************************************************************************************************
	 * Method : fillAgreementPage
	 * Description: Click radio button for selecting Agreement and Click Continue.
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************//*
	public void fillAgreementPage()
	{
		 Write code for selecting Agreement for payment if required for test case 

		waitForPageLoad();
		try {
			waitForElementTime(TestDataManage.getObjectProperty("ContinueAgreement_Btn"), 60);
		} catch (Exception e) {
		}
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueAgreement_Btn"))){
		waitForElement(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
		click(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
		}
	}*/

	/********************************************************************************************************************
	 * Method : clickContinueButton
	 * Description: Generic method to click Cintinue Button
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void clickContinueButton()
	{
		waitForPageLoad();
		//waitForElement(TestDataManage.getObjectProperty("Continue_Btn"));
		isDisplayedWait(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueWithCreation_Btn")))
		{
		click("ContinueWithCreation_Btn");
		}
		//waitForElement(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
		//click("ContinueWithCreation_Btn");
		//click("Continue_Btn");
		waitForPageLoad();
	}



	/********************************************************************************************************************
	 * Method : fillExtraInformationPage
	 * Description: Click Continue for Extra Information page and navigate to Case and Contact Page.
	 * Author: Rajmohan Dhanapal
	 * Date: Jan-10-2017
	 ********************************************************************************************************************/
	public void fillExtraInformationPage()
	{
		waitForPageLoad();
		isDisplayedWait(TestDataManage.getObjectProperty("Continue_ExtraInformation_Button"));
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_ExtraInformation_Button"))){
		click("Continue_ExtraInformation_Button");
		}
		waitForPageLoad();
	}
	
	/********************************************************************************************************************
	 * Method : continueCaseCreation
	 * Description: Click Continue for Extra Information page and navigate to Case and Contact Page.
	 * Author: Rajmohan Dhanapal
	 * Date: Jan-10-2017
	 ********************************************************************************************************************/
	public void continueCaseCreation(){

		// Code for Duplicate Case page / Extra information page 
		waitForPageLoad();
		By continueXpath = TestDataManage.getObjectProperty("Continue_Btn");
		waitForElementTime(continueXpath, 60);
		WebElement continueButton = getElement(continueXpath );
		click(continueXpath);
		// Wait till navigated to next Page - Checking next page is Expired Contract 
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.stalenessOf(continueButton));	
		}catch(Exception e){

		}
		waitForPageLoad();
		if(isElementPresent("ContinueExpiredContract_Btn")){
			WebElement continueExpiredButton = getElement(TestDataManage.getObjectProperty("ContinueExpiredContract_Btn"));
			clickExpiredContract();
			// Wait till navigated to next Page - Checking next page is Fill Extra Information Page
			try{
				WebDriverWait wait = new WebDriverWait(getDriver(), 10);
				wait.until(ExpectedConditions.stalenessOf(continueExpiredButton));	
			}catch(Exception e){

			}
			waitForPageLoad();
		}
		
		if(isElementPresent("Continue_ExtraInformation_Button")){
			click("Continue_ExtraInformation_Button");
			waitForStale(TestDataManage.getObjectProperty("Continue_ExtraInformation_Button"));
			waitForPageLoad();
		}

	}
	
	/********************************************************************************************************************
	 * Method : continueTillCaseCreation
	 * Description: Click Continue for Extra Information page and navigate to Case and Contact Page.
	 * Author: Alfred (Donot delete)
	 * Date: Jan-10-2017
	 ********************************************************************************************************************/
	public void continueTillCaseCreation(){

		waitForPageLoad();
		pause(10000);
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"))){
			click(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
			pause(12000);
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("ContinueAgreement_Btn"))){
			click(TestDataManage.getObjectProperty("ContinueAgreement_Btn"));
			pause(12000);
		}
		waitForPageLoad();
		if(isElementPresent(TestDataManage.getObjectProperty("Continue_ExtraInformation_Button"))){
			waitForElement(TestDataManage.getObjectProperty("Continue_ExtraInformation_Button"));
			click("Continue_ExtraInformation_Button");
		}
	}
	/********************************************************************************************************************
	 * Method : VerifyExpiredNotification
	 * Description: Verify the expired notification text
	 * Author: Tony George
	 * Date: Feb-16-2017
	 ********************************************************************************************************************/
	public void VerifyExpiredNotification()
	{
		waitForPageLoad();
		pause(10000);
		waitForElement(TestDataManage.getObjectProperty("ExpiredServiceNotification_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("DeclinedSupportAggrement_Text"), "Our records indicate that this product (serial # "+TestDataManage.getData("SerialNumber")+" ) does not have an active support agreement.To purchase or renew an agreement on-line, go to theService Contractspage.");
		verifyContainsText(TestDataManage.getObjectProperty("SubmitCase_Text"), "If you feel you have received this message in error, and that this product does have an active support agreement please select the second option below. You will be allowed to submit your case/rma, but it will be put on hold until the agreement issue is resolved. A NetApp representative will contact you shortly.");
		
	}
	

	
	/********************************************************************************************************************
	 * Method : setExpiredContract
	 * Description: set the values in Expired Contract 
	 * Author: Rajmohan Dhanapal
	 * Date: Feb-22-2017
	 ********************************************************************************************************************/
	public void setExpiredContract()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ContinueExpiredContract_Btn"));
		checkMultipleCheckbox("ExpiredContracSupport_Checkbox", TestDataManage.getData("ExpiredContracSupportCheckbox"));
		waitForPageLoad();
		click("ContinueExpiredContract_Btn");
		waitForPageLoad();
	}
	
	/********************************************************************************************************************
	 * Method : setServiceAgreement
	 * Description: set the values in Service Agreement
	 * Author: Rajmohan Dhanapal
	 * Date: Feb-22-2017
	 ********************************************************************************************************************/
	public void setServiceAgreement(){
		setTextBox("BillingCompany","BillingCompany_Input");
		setTextBox("BillingAddress","BillingAddress_Input");
		setTextBox("BillingCity","BillingCity_Input");
		setTextBox("BillingState","BillingState_Input");
		setTextBox("BillingZip","BillingZip_Input");
		chooseDropDown("BillingCountry", "BillingCountry_Select");
		setTextBox("BillingTitle","BillingTitle_Input");
		waitForPageLoad();
		click("Agree_Button");
		
	}
	
	/********************************************************************************************************************
	 * Method : extraInfoContinue
	 * Description: click continue from extra information  required page
	 * Author: Sreejith
	 * Date: Feb-21-2017
	 ********************************************************************************************************************/
	public void extraInfoContinue()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ExtraInfoCntn_Btn"));
		//waitForElement(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
		//click("ContinueWithCreation_Btn");
		click("ExtraInfoCntn_Btn");
		waitForPageLoad();
	}
	/********************************************************************************************************************
	 * Method : describeTheProblemForCreatecaseAnyway
	 * Description: to create a case anyway
	 * Author: Sreejith
	 * Date: Feb-22-2017
	 ********************************************************************************************************************/
	public void describeTheProblemForCreatecaseAnyway()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("CreatecaseAnyway_link"));
		//waitForElement(TestDataManage.getObjectProperty("ContinueWithCreation_Btn"));
		//click("ContinueWithCreation_Btn");
		click("CreatecaseAnyway_link");
		waitForPageLoad();
		switchToNewWindow();
		
		chooseDropDown("Catogery1", "Question1_Drpdwn");
		chooseDropDown("Catogery2", "Question2_Drpdwn");
		chooseDropDown("Catogery3", "Question3_Drpdwn");
		type(TestDataManage.getObjectProperty("ProductNumber_Txtarea"), TestDataManage.getData("ProductNumber"));
		type(TestDataManage.getObjectProperty("OSversion_Txtarea"), TestDataManage.getData("OSVersion"));
		type(TestDataManage.getObjectProperty("Description_Txtarea"), TestDataManage.getData("Description"));
		click("ProblemGo_Btn");
		waitForPageLoad();
		
	}
	
	/********************************************************************************************************************
	 * Method : verifySearchResultColumnsNoResults
	 * Description: Verify the column names in the no Search Result
	 * Author: Sreejith
	 * Date: Jan-10-2017
	 ********************************************************************************************************************/
	public void verifySearchResultColumnsNoResults(){
		waitForPageLoad();
		// Wait till result table is displayed
		String searchResultLocator = TestDataManage.getObjectValue("SearchResultColumnNames_Table");
		waitForElementTime(By.xpath(String.format(searchResultLocator ,"2")), 240);

//		if(isElementPresent("NoSearchResultErrorMessage_Text")){
//			getDetailedReport().WriteLog(Status.FAIL, "Verify the columns in the Search Result", 
//					"There were no results found for your search. Please check the search criteria selected above and try your search again.", getDriver());
//		}else{

			// Setting the header names to be searched 
			String[] columnNames = {"Serial Number", "Cluster Serial Number", "Cluster Name", "Location", "System Name",
					"Product Number", "OS Version", "Auto Support Status", "Group"};
			int j =0;
			boolean status = true ;
			for(int i= 2; i<=9; i++){
				if(!verifyText(By.xpath(String.format(searchResultLocator,i)), columnNames[j++])){
					getDetailedReport().WriteLog(Status.FAIL, "Verify the columns in the Search Result", "Column "+columnNames[j-1]+"is not present", getDriver());
					status = false;
				}
			}
			if(status){
				getDetailedReport().WriteLog(Status.PASS, "Verify the columns in the Search Result", "Search results contain the following columns:"
						+ "- Serial Number \n"
						+ "- Cluster Serial Number \n"
						+ "- Cluster Name \n"
						+ "- Location \n"
						+ "- System Name \n"
						+ "- Product Number \n"
						+ "- OS Version \n"
						+ "- AutoSupport Status \n"
						+ "- Group", getDriver());
			}
			waitForPageLoad();
		}

	/********************************************************************************************************************
	 * Method : clickContinueButton
	 * Description: Generic method to  fill  expired contract page 
	 * Author: Sreejith
	 * Date: feb-16-2017
	 ********************************************************************************************************************/
	public void clickExpiredContract()
	{
		
		pause(10000);
		waitForElement(TestDataManage.getObjectProperty("ContinueExpiredContract_Btn"));
		click("ContinueExpiredContract_Btn");
		waitForPageLoad();
				
	}
	
	/********************************************************************************************************************
	 * Method : setBrowseProductAffectednNoResults
	 * Description: To Browse the product with no results
	 * Author: Sreejith
	 * Date: Jan-7-2017
	 ********************************************************************************************************************/
	public void setBrowseProductAffectednNoResults()
	{
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("SerialNumber_Txtbox"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Search_Drpdwn"), TestDataManage.getData("Search|BrowseCriteria"));
		type(TestDataManage.getObjectProperty("SerialNumber_Txtbox"), TestDataManage.getData("SerialNumber"));
		click("Go_Btn");
		waitForPageReady();
		//Verifies search gives you a result or not . Also waits till the results are populated
		
	}
	

	/********************************************************************************************************************
	* Method : verifyBrowserDropdown
	* Description: To verify the presence of verify drop down window
	* Author: Sreejith
	* Date: Feb-15-2017
	********************************************************************************************************************/
	public void verifyPresenceBrowserDropdown()
	{
		waitForPageReady();
		if(isElementPresent(TestDataManage.getObjectProperty("Browse_Btn"))){
			getDetailedReport().WriteLog(Status.FAIL, "verfying the presence of browser drop down", "Browser Drop down is displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.PASS, "verfying the presence of browser drop down", "Browser Drop down is not displayed", getDriver());
		}
	}

	
	
	/********************************************************************************************************************
	* Method : verifyASP
	* Description: To verify the presence of ASP page
	* Author: Sreejith
	* Date: Mar-27-2017
	********************************************************************************************************************/
	public void verifyASP()
	{
		waitForElement(TestDataManage.getObjectProperty("ViewArticles_Link"));
		if(isElementPresent(TestDataManage.getObjectProperty("ViewArticles_Link"))){
			getDetailedReport().WriteLog(Status.PASS, "verifying the presence of ASP page", "View article link  is   available", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "verifying the presence of ASP page", "View article link is not available", getDriver());
		}
	}
	/********************************************************************************************************************
	 * Method : describeTheProblemForDifferentCaseAndVerifyGLUEName
	 * Description: Describe the case by answering the Questions and commenting reason for the case.
	 * Author: Alfred Dcruz
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void describeTheProblemForDifferentCaseAndVerifyGLUEName()
	{
		int i=0;
		waitForPageReady();
		sleepFor(5000);
		String Catogery1 = TestDataManage.getData("Catogery1");
		String Catogery2 = TestDataManage.getData("Catogery2");
		String Catogery3 = TestDataManage.getData("Catogery3");
		String GlueName = TestDataManage.getData("GlueName");
		
		String Catogery1Array[] = Catogery1.split("\\|");
		String Catogery2Array[] = Catogery2.split("\\|");
		String Catogery3Array[] = Catogery3.split("\\|");
		String GlueNameArray[] = GlueName.split("\\|");
		switchToNewWindow();
		waitForElement(TestDataManage.getObjectProperty("Question1_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question1_Drpdwn"), Catogery1Array[i]);
		sleepFor(3000);
		waitForElement(TestDataManage.getObjectProperty("Question2_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question2_Drpdwn"), Catogery2Array[i]);
		sleepFor(3000);
		waitForElement(TestDataManage.getObjectProperty("Question3_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("Question3_Drpdwn"), Catogery3Array[i]);
		type(TestDataManage.getObjectProperty("Description_Txtarea"), TestDataManage.getData("Description"));
		click("ProblemGo_Btn");
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ChangeDescribeProblem_Lnk"));
		click(TestDataManage.getObjectProperty("ChangeDescribeProblem_Lnk"));
		waitForPageLoad();
		for(i=0; i<Catogery1Array.length; i++){
			waitForElement(TestDataManage.getObjectProperty("Question1Change_Drpdwn"));
			selectbyVisibleText(TestDataManage.getObjectProperty("Question1Change_Drpdwn"), Catogery1Array[i]);
			sleepFor(3000);
			waitForElement(TestDataManage.getObjectProperty("Question2Change_Drpdwn"));
			selectbyVisibleText(TestDataManage.getObjectProperty("Question2Change_Drpdwn"), Catogery2Array[i]);
			sleepFor(3000);
			waitForElement(TestDataManage.getObjectProperty("Question3Change_Drpdwn"));
			selectbyVisibleText(TestDataManage.getObjectProperty("Question3Change_Drpdwn"), Catogery3Array[i]);
			type(TestDataManage.getObjectProperty("DescriptionChange_Txtarea"), TestDataManage.getData("Description"));
			click("ProblemGoChange_Btn");
			waitForPageLoad();
			String windowHandle = getDriver().getWindowHandle();
			verifyDescribeAProblemForGLUEURL(GlueNameArray[i]);
			GPS glueObj = new GPS();
			glueObj.VerifyChatIconAvailableHours();
			getDriver().close();
			getDriver().switchTo().window(windowHandle);
			waitForElement(TestDataManage.getObjectProperty("ChangeDescribeProblem_Lnk"));
			click(TestDataManage.getObjectProperty("ChangeDescribeProblem_Lnk"));
			waitForPageLoad();
		}
	}
	
	/********************************************************************************************************************
	* Method : verifyDescribeAProblemForGLUEURL
	* Description: To verify the presence of verify drop down window
	* Author: Alfred
	* Date: Feb-15-2017
	 * @param glueName 
	********************************************************************************************************************/
	public void verifyDescribeAProblemForGLUEURL(String glueName)
	{
		waitForElement(TestDataManage.getObjectProperty("ClickHere_Lnk"));
		click(TestDataManage.getObjectProperty("ClickHere_Lnk"));
		waitForPageLoad();
		switchToNewWindow();
		waitForPageLoad();
		String verifyHeaderGlueName = TestDataManage.getObjectValue("VerifyGlueName_Lnk");
		verifyHeaderGlueName = verifyHeaderGlueName.replace("%s", glueName);
		if(isElementPresent(By.xpath(verifyHeaderGlueName))){
			getDetailedReport().WriteLog(Status.PASS, "Expected Glue Name should match the required search", "Expected is displayed", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Expected Glue Name should match the required search", "Expected is not displayed", getDriver());
		}
	}

}
