package com.netapp.supportsite.base;
/**
 * Class : ViewCaseBase
 * @author : UST Global
 */
import org.openqa.selenium.By;

import com.ust.sarf.exception.SARFException;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class ViewCaseBase extends Base{

	/********************************************************************************************************************
	 * Method : clickOpenANewCase
	 * Description: To click on link Open a New case
	 * Author: Salba
	 * Date: February-13-2017
	 ********************************************************************************************************************/

	public void clickOpenANewCase(){
		waitForPageLoad();
		click("OpenANewCase_Link");
		waitForPageLoad();
	}

	/********************************************************************************************************************
	 * Method : searchByCriteria1
	 * Description: To search View case page by Search Criteria 1
	 * Author: Salba
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void searchByCriteria1(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("SelectCriteria_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("SelectCriteria_Drpdwn"), TestDataManage.getData("SelectCriteria"));
		setTextBox("SearchValue", "Value_Txtbox");
		selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAll_DrpDwn"), TestDataManage.getData("ShowMeAll"));
		sleepFor(3000);
		click("Go_Btn");
		waitForStale(TestDataManage.getObjectProperty("Go_Btn"));
		waitForPageLoad();
		pause(4000);
		//Verifying searchResult is displayed 
		verifySearchResultIsDisplayed();

	}


	/********************************************************************************************************************
	 * Method : searchByCriteria2
	 * Description: To search view case by Criteria 2
	 * Author: Alfred Dcruz
	 * Date: February-13-2017
	 ********************************************************************************************************************/

	public void searchByCriteria2(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ShowMeAllForViewCase_Drpdwn"));
		chooseDropDown("ShowMeAll", "ShowMeAllForViewCase_Drpdwn");
		chooseDropDown("Status", "StatusForViewCase_Drpdwn");
		chooseDropDown("Country", "CountriesForViewCase_Drpdwn");
		if ( !getDriver().findElement(By.xpath(setXpath("StateProvince_Checkbox", "State/Province"))).isSelected() )
		{
			getDriver().findElement(By.xpath(setXpath("StateProvince_Checkbox", "State/Province"))).click();
			getDetailedReport().WriteLog(Status.PASS, "Click Element: "+"StateProvince_Checkbox", "Element Clicked ", getDriver());
			waitForPageLoad();
		}
		click(TestDataManage.getObjectProperty("Go2_Btn"));
		waitForPageLoad();

	}

	/********************************************************************************************************************
	 * Method : validateListTableDisplayedForSearch
	 * Description: Verify Search Results is Displayed
	 * Author: Salba
	 * Modified : Rajmohan Dhanapal
	 * Comment : modified the logic
	 * Date: February-23-2017
	 ********************************************************************************************************************/
	public void verifySearchResultIsDisplayed(){
		waitForPageLoad();
		if(!isDisplayedWait(TestDataManage.getObjectProperty("ChatCaseinfo_Text"))){
			waitForElementTime(TestDataManage.getObjectProperty("ListTableForSearch_Table"),300);
			if(isElementPresent("NoRecordsFound_ErrMsg")){
				getDetailedReport().WriteLog(Status.FAIL, "Verify the columns in the Search Result", 
						"There were no results found for your search. Please check the search criteria selected above and try your search again.", getDriver());
			}else{
				getDetailedReport().WriteLog(Status.PASS, "Verify Search Results are displayed", "Search Results are displayed", getDriver());
			}
		}else {
			getDetailedReport().WriteLog(Status.PASS, "Verify Search Results are displayed", "User navigated to Case Page", getDriver());

		}	

	}

	/********************************************************************************************************************
	 * Method : selectViewCaseSearchForDifferentCountriesOrState
	 * Description: View All cases by Search Criteria 2 for View Case. 
	 * Author: Alfred Dcruz
	 * Date: Jan-9-2017
	 ********************************************************************************************************************/
	public void selectViewCaseSearchForDifferentCountriesOrState()
	{
		String ObjectForSelectingStateOrProvince;
		String stateOrProvince = TestDataManage.getData("State/Province");
		String country = TestDataManage.getData("Country");

		String countryArray[] = country.split("\\|");
		String stateOrProvinceArray[] = stateOrProvince.split("\\|");

		for(int i=0; i<countryArray.length; i++){
			for(int j=0; j<stateOrProvinceArray.length; j++){
				if(stateOrProvince.contains("All")){
					ObjectForSelectingStateOrProvince = "//label[contains(text(),'" + stateOrProvinceArray[j] + "')]/following::input[@type='checkbox'][1]";
				}else{
					ObjectForSelectingStateOrProvince = "//label[contains(text(),'" + stateOrProvinceArray[j] + "')]/following::input[@type='checkbox'][1]/preceding::input[1]";
				}
				waitForElement(TestDataManage.getObjectProperty("ShowMeAllForViewCase_Drpdwn"));
				selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAllForViewCase_Drpdwn"), TestDataManage.getData("ShowMeAll"));
				selectbyVisibleText(TestDataManage.getObjectProperty("StatusForViewCase_Drpdwn"), TestDataManage.getData("Status"));
				selectbyVisibleText(TestDataManage.getObjectProperty("CountriesForViewCase_Drpdwn"), countryArray[i]);
				if(!getDriver().findElement(By.xpath(ObjectForSelectingStateOrProvince)).isSelected()){
					getDriver().findElement(By.xpath(ObjectForSelectingStateOrProvince)).click();
				}
				getDriver().findElement(TestDataManage.getObjectProperty("Go2_Btn")).click();
				waitForPageLoad();
				verifySearchResultIsDisplayed();
			}
		}
	}


	/********************************************************************************************************************
	 * Method : ValidateTableListForSearchCriteria2
	 * Description: View All cases by Search Criteria 1 for View Case. 
	 * Author: Tony George
	 * Date: Feb-16-2017
	 ********************************************************************************************************************/
	public void validateCaseNumber()
	{
		waitForElement(TestDataManage.getObjectProperty("CaseNumber_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("CaseNumber_Txt"), TestDataManage.getData("SearchValue"));
	}
	/********************************************************************************************************************
	 * Method : compareClusterSerialNos
	 * Description: Verify the Search Results based on CLuster No. Verifying all search results have the same cluster number  
	 * Author: Tony George
	 * Date: Feb-16-2017
	 ********************************************************************************************************************/
	public void compareClusterSerialNos()
	{

		waitForElement(By.xpath("//table/tbody/tr[2]/th[1]"));
		for(int i=1; i<=20; i++)
		{
			//String test=getDriver().findElement(By.xpath("//table/tbody/tr[2]/th["+i+"]")).getText();
			if(getDriver().findElement(By.xpath("//table/tbody/tr[2]/th["+i+"]")).getText().equalsIgnoreCase("Cluster Serial Number"))
			{
				for(int j=2;j<=7;j++)
				{
					if(isElementPresent(By.xpath("//table/tbody/tr["+j+"]/td["+i+"]")))
					{
						verifyContainsText(By.xpath("//table/tbody/tr["+j+"]/td["+i+"]"), TestDataManage.getData("SearchValue"));
					}
					else
					{
						break;
					}

				}
				break;
			}
		}

	}
	/********************************************************************************************************************
	 * Method : setViewCaseBySearchCriteriaAndValidate
	 * Description: To select View Case By Search Criteria 1 and Validate
	 * Author: Harish
	 * Date: February-21-2017
	 ********************************************************************************************************************//*

	public void setViewCaseBySearchCriteriaAndValidate(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("SelectForViewCaseMethod_Drpdwn"));
		selectbyVisibleText(TestDataManage.getObjectProperty("SelectForViewCaseMethod_Drpdwn"), TestDataManage.getData("Select"));
		type(TestDataManage.getObjectProperty("EnterValueForViewCase_Textbx"), TestDataManage.getData("Value"));
		selectbyVisibleText(TestDataManage.getObjectProperty("ShowMeAllForViewCaseMethod_Drpdwn"), TestDataManage.getData("ShowMeAll"));
		click(TestDataManage.getObjectProperty("Go_btn"));
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("CaseNo_Txt"));
		VerifyContainsText(TestDataManage.getObjectProperty("CaseNo_Txt"), TestDataManage.getData("SearchValue"));

	}*/

	/********************************************************************************************************************
	 * Method : searchCriteria1WithRunTimeCaseNo
	 * Description: To search using Criteria 1 , but use the Case No as the one user had created at the run time
	 * Author: Harish
	 * Date: February-21-2017
	 ********************************************************************************************************************/

	public void searchCriteria1WithRunTimeCaseNo(){
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("SelectForViewCaseMethod_Drpdwn"));
		chooseDropDown("SelectCriteria", "SelectCriteria_Drpdwn");
		type(TestDataManage.getObjectProperty("Value_Txtbox"), CreateCaseBase.CaseNo.trim());
		chooseDropDown("ShowValues","ShowMeAll_DrpDwn");
		click(TestDataManage.getObjectProperty("Go_btn"));
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("CaseNo_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("CaseNo_Txt"), CreateCaseBase.CaseNo.trim());
	}

	/********************************************************************************************************************
	 * Method : validateChatIconPresence
	 * Description: Verify Chat icon Present for the scenario. 
	 * Author: Rajmohan Dhanapal
	 * Date: Feb-21-2017
	 ********************************************************************************************************************/
	public void validateChatIconPresence()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ChatCaseinfo_Text"));
		waitForElement(TestDataManage.getObjectProperty("LiveChatIconImage_Lnk"));
		verifyElementDisplayed("LiveChatIconImage_Lnk","Chat Icon");
	}

	/********************************************************************************************************************
	 * Method : validateChatIconNotPresence
	 * Description: Verify Chat icon not Present for the scenario. 
	 * Author: Rajmohan Dhanapal
	 * Date: Feb-21-2017
	 ********************************************************************************************************************/
	public void validateChatIconNotPresence()
	{
		waitForPageLoad();
		waitForElement(TestDataManage.getObjectProperty("ChatCaseinfo_Text"));
		verifyElementNotPresent("LiveChatIconImage_Lnk");
	}

	/********************************************************************************************************************
	 * Method : EmailSearchCriteriaResults
	 * Description: To email the search results
	 * Author: Tony George
	 * Date: Mar-13-2017
	 ********************************************************************************************************************/
	public void emailSearchCriteriaResults()
	{
		waitForElement(TestDataManage.getObjectProperty("EmailTheseResults_link"));
		click("EmailTheseResults_link");
		waitForElement(TestDataManage.getObjectProperty("EmailAddress_TxtBox"));
		String Emailaddress=getDriver().findElement(TestDataManage.getObjectProperty("EmailAddress_TxtBox")).getAttribute("value").trim();
		click("EmailSubmit_btn");
		sleepFor(8000);
		waitForElement(TestDataManage.getObjectProperty("EmailConfirmation_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("EmailConfirmation_Text"), Emailaddress);



	}
	/********************************************************************************************************************
	 * Method : selectCaseFromViewList
	 * Description: To select the case from viewlist
	 * Author: Tony George
	 * Date: Mar-13-2017
	 ********************************************************************************************************************/
	public void selectCaseFromViewList()
	{
		int flag=0;
		String serialNumber=TestDataManage.getData("SearchValue");
		By SerialLink=By.linkText(serialNumber);
		waitForElementTime(TestDataManage.getObjectProperty("ListTableForSearch_Table"),300);

		if(isElementPresent(TestDataManage.getObjectProperty("PageCount_Txt"))){ // Check for Page count is present in UI or not 
			String PageCount=getText(TestDataManage.getObjectProperty("PageCount_Txt")).replace("of ", "");
			int count=Integer.parseInt(PageCount);
			for(int i=1;i<=count;i++)
			{
				if(isElementPresent(SerialLink))
				{
					click(SerialLink);
					switchToNewWindow();
					flag=1;
					break;
				}
				click(By.xpath("//*[text()='"+(i+1)+"']"));
				waitForPageLoad();
				waitForElementTime(TestDataManage.getObjectProperty("ListTableForSearch_Table"),300);

			}
		}else{
			if(isElementPresent(SerialLink))
			{
				click(SerialLink);
				switchToNewWindow();
				flag=1;
			}

		}
		if(flag==1)
		{
			getDetailedReport().WriteLog(Status.PASS, "Case Valid:Should click on the serial number "+serialNumber+" from the list", "clicked on the serial number "+serialNumber+" from the list", getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Case Invalid:Should click on the serial number "+serialNumber+" from the list", "Serial Number : "+serialNumber+" not present in the list", getDriver());
			throw new SARFException("Serial Number : "+serialNumber+" not present in the list");
		}
	}


	/********************************************************************************************************************
	 * Method : VerifyChatHours
	 * Description: Verify the chat hours in view case
	 * Author: Tony George
	 * Date: March-22-2017
	 ********************************************************************************************************************/
	public void VerifyChatHours()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatTime_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("ChatTime_Text"), TestDataManage.getData("ChatHours"));

	}

	/********************************************************************************************************************
	 * Method : OpenChatIntakeForm
	 * Description: To open the chat intake form
	 * Author: Alfred
	 * Date: Mar-13-2017 
	 ********************************************************************************************************************/
	public void OpenChatIntakeForm()
	{
		waitForElement(TestDataManage.getObjectProperty("LiveChat_Lnk"));
		click("LiveChat_Lnk");
		pause(5000);
		boolean isEnabled=getDriver().findElement(TestDataManage.getObjectProperty("ChatMessageAllow_Lbl")).isDisplayed();
		if(isEnabled == true){

			waitForElement(TestDataManage.getObjectProperty("ChatIconAllowContinue_Btn"));
			click("ChatIconAllowContinue_Btn");
		}else{
			waitForElement(TestDataManage.getObjectProperty("ChatContinue_Button"));
			click("ChatContinue_Button");
		}
	}
	/********************************************************************************************************************
	 * Method : VerifyChatIntakeFormFields
	 * Description: To verify all the fields in the chat intake form
	 * Author: Tony George
	 * Date: March-15-2017
	 ********************************************************************************************************************/
	public void VerifyChatIntakeFormFields()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		verifyElementDisplayed("ChatFirstName_TextBox", "FirstName_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatLastName_TextBox", "LastName_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatEmailAddress_TextBox", "Email_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatSerNumber_TextBox", "Serial Number Textbox");
		verifyElementDisplayed("ChatCaseNumber_TextBox", "Case Number Textbox");
		verifyElementDisplayed("ChatIntakeProductArea_Select", "Case Number Textbox");
		checkDefaultDropdownValue("ChatIntakeProductArea_Select", "-- Select One --");
	}
	/********************************************************************************************************************
	 * Method : cancelChatIntakeForm
	 * Description: To click on cancel button for the chat intake form
	 * Author: Tony George
	 * Date: March-30-2017
	 ********************************************************************************************************************/
	public void cancelChatIntakeForm()
	{
		click("ChatIntakeCancel_Btn");
		pause(4000);

		/*if(getElement("ChatFirstName_TextBox").isDisplayed()==false)
		{
			getDetailedReport().WriteLog(Status.PASS, "Expected :Chat intake form should be closed on clicking the close button", "Actual:Chat intake form is closed on clicking the cancel button", getDriver()); 	
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Expected :Chat intake form should be closed on clicking the close button", "Actual:Chat intake form is not closed on clicking the cancel button", getDriver()); 	
		}*/
		verifyElementDisplayed("ChatCaseinfo_Text", "Case Info Text");
	}

	/********************************************************************************************************************
	 * Method : editChatIntakeForm
	 * Description: To verify all the fields in the chat intake form
	 * Author: Alfred
	 * Date: March-15-2017
	 ********************************************************************************************************************/
	public void editChatIntakeForm()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		type(TestDataManage.getObjectProperty("ChatFirstName_TextBox"), "FirstName Edit");
		type(TestDataManage.getObjectProperty("ChatLastName_TextBox"), "LastName Edit");
		type(TestDataManage.getObjectProperty("ChatEmailAddress_TextBox"), "email@test.com");
	}
}
