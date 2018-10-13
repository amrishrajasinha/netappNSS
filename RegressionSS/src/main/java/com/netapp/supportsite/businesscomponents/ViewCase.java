package com.netapp.supportsite.businesscomponents;
/**
 * Class : ViewCase
 * @author : UST Global
 */

import org.junit.Test;
import com.netapp.supportsite.base.ViewCaseBase;

public class ViewCase extends ViewCaseBase {
	
	/********************************************************************************************************************
	 * Method : openNewCase
	 * Description: Click Open a New Case and proceed
	 * Author: Salba
	 * Date: February-13-2017
	 ********************************************************************************************************************/
	public void openNewCase(){
		clickOpenANewCase();
	}
	
	/********************************************************************************************************************
	 * Method : searchBySelectDropdown
	 * Description: Search Case using the First type of search with select dropdown
	 * Author: Salba
	 * Date: February-13-2017
	 ********************************************************************************************************************/

	public void searchBySelect(){
		searchByCriteria1();
		
	}
	/********************************************************************************************************************
	 * Method : searchByStatus
	 * Description: Search Case using the Second type of search with Status dropdown
	 * Author: Salba
	 * Date: February-13-2017
	 ********************************************************************************************************************/
	
	public void searchByStatus(){
		searchByCriteria2();
		
	}
	
	/********************************************************************************************************************
	 * Method : verifySearchResultDisplayedForSearch1
	 * Description: Validate table listed for last 7 days search for View Case
	 * Author: Alfred dcruz
	 * Date: MAR-9-2017
	 ********************************************************************************************************************/
	public void verifySearchResultDisplayedForSearch1(){
		searchByCriteria1();
		verifySearchResultIsDisplayed();
	}
	
	/********************************************************************************************************************
	 * Method : validateSearchCriteria2ForLast7Days
	 * Description: Validate table listed for last 7 days search for View Case
	 * Author: Alfred dcruz
	 * Date: February-13-2017
	 ********************************************************************************************************************/
	public void verifySearchResultDisplayed(){
		searchByCriteria2();
		verifySearchResultIsDisplayed();
	}
	
	

	/********************************************************************************************************************
	 * Method : searchCaseAndNavigateToDetailPage
	 * Description: Search Case using the First type of search with select dropdown
	 * Author: Tony George
	 * Date: February-16-2017
	 ********************************************************************************************************************/
	@Test
	public void searchCaseAndNavigateToDetailPage()
	{
		searchByCriteria1();
		validateCaseNumber();
	}

	/********************************************************************************************************************
	 * Method : searchClusterSerialNumberAndVerify
	 * Description: Search Cluster SerialNumber and verify first row in table
	 * Author: Tony George
	 * Date: February-16-2017
	 ********************************************************************************************************************/
	@Test
	public void searchClusterSerialNumberAndVerify()
	{
		searchByCriteria1();
		//compareClusterSerialNos();
	}
	
	/********************************************************************************************************************
	 * Method : browseSerialNumberForDifferentCountriesOrState
	 * Description: Search Cluster SerialNumber and verify first row in table
	 * Author: Tony George
	 * Date: February-16-2017
	 ********************************************************************************************************************/
	@Test
	public void browseSerialNumberForDifferentCountriesOrState()
	{
		waitForPageLoad();
		selectViewCaseSearchForDifferentCountriesOrState();
		
	}

	/********************************************************************************************************************
	* Method : verifyChatIconPresence
	* Description: Verify Chat icon Present for the scenario. 
	* Author: Rajmohan Dhanapal
	* Date: Feb-21-2017
	********************************************************************************************************************/
	public void verifyChatIconPresence()
	{
		searchByCriteria1();// Searches using Case Number and hence directly navigated to Case Page
		validateChatIconPresence();
	}
	
 	/********************************************************************************************************************
 	* Method : verifyChatIconNotPresence
 	* Description: Verify Chat icon not Present for the scenario. 
 	* Author: Rajmohan Dhanapal
 	* Date: Feb-21-2017
 	********************************************************************************************************************/
 	public void verifyChatIconNotPresence()
 	{
 		searchByCriteria1();// Searches using Case Number and hence directly navigated to Case Page
 		validateChatIconNotPresence();
 	}
 	/********************************************************************************************************************
 	* Method : validateCriteria1WithRunTimeCaseNo
 	* Description: validate Criteria1 With Run Time CaseNo 
 	* Author: Harish
 	* Date: Feb-22-2017
 	********************************************************************************************************************/
 	public void validateCriteria1WithRunTimeCaseNo()
 	{
 		searchCriteria1WithRunTimeCaseNo();
 	}
 	/********************************************************************************************************************
 	* Method : emailResults
 	* Description: To email the search Results
 	* Author: Tony George
 	* Date: Mar-13-2017
 	********************************************************************************************************************/
 	public void emailResults()
 	{
 		emailSearchCriteriaResults();
 	}
 	/********************************************************************************************************************
 	* Method : SelectSerialNumberFromTableAndVerifyChatIcon
 	* Description: To select a serial number from the list and verify chat icon
 	* Author: Tony George
 	* Date: Mar-22-2017
 	********************************************************************************************************************/
 	public void selectSerialNumberFromTableAndVerifyChatTimming()
 	{
 		searchByCriteria2();
		verifySearchResultIsDisplayed();
		selectCaseFromViewList();
		validateChatIconPresence();
		//VerifyChatHours();
 	}
 	
 	/********************************************************************************************************************
 	* Method : verifyChatIntakeForm
 	* Description: To verify the chat intake form
 	* Author: Tony George
 	* Date: Mar-30-2017
 	********************************************************************************************************************/
 	public void searchCaseNumberAndVerifyChatIntakeForm()
 	{
 		searchByCriteria1();
		validateChatIconPresence();
 		OpenChatIntakeForm();
 		VerifyChatIntakeFormFields();
 	}

 	/********************************************************************************************************************
 	* Method : verifyChatIntakeForm
 	* Description: To verify the chat intake form
 	* Author: Tony George
 	* Date: Mar-30-2017
 	********************************************************************************************************************/
 	public void verifyCancelChatInatakeFormFunctionality()
 	{
 		searchByCriteria1();
		validateChatIconPresence();
 		OpenChatIntakeForm();
 		cancelChatIntakeForm();
 		
 	}

 	/********************************************************************************************************************
 	* Method : searchCaseNumberAndVerifyChatIntakeFormEditFieldsAndVerify
 	* Description: To verify the chat intake form
 	* Author: Alfred
 	* Date: Mar-30-2017
 	********************************************************************************************************************/
 	public void searchCaseNumberAndVerifyChatIntakeFormEditFieldsAndVerify()
 	{
 		searchByCriteria1();
		validateChatIconPresence();
 		OpenChatIntakeForm();
 		VerifyChatIntakeFormFields();
 		editChatIntakeForm();
 	}




}
