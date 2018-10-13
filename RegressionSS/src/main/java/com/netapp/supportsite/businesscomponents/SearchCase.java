package com.netapp.supportsite.businesscomponents;

/**
 * Class : SearchCase
 * @author : UST Global
 */

import org.junit.Test;
import com.netapp.supportsite.base.SearchCaseBase;

public class SearchCase extends SearchCaseBase
{
	
	/********************************************************************************************************************
	 * Method : searchAndCreateCase
	 * Description: Method to Search and Create a case 
	 * Author: Salba
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchAndCreateCase(){
		searchProductAffected();
		describeTheProblemForCase();
		continueCaseCreation();		
				
	}
	/********************************************************************************************************************
	 * Method : browseAndCreateCase
	 * Description: Method to browse and Create a case
	 * Author: Salba
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void browseAndCreateCase(){
		browseProductAffected();
		describeTheProblemForCase();
		continueCaseCreation();	
		
	}
	
	/********************************************************************************************************************
	 * Method : searchAndCreateReviewCase
	 * Description: Create case for Chat icon present
	 * Author: Rajmohan Dhanapal
	 * Date: February-10-2017
	 ********************************************************************************************************************/

	public void searchAndCreateReviewOrDuplicateCase()
	{
		searchProductAffected();
		describeTheProblemForCase();
		clickContinueButton();
		fillExtraInformationPage();
	}
	
	/********************************************************************************************************************
	 * Method : browseSelectFirstSerialAndCreateCase
	 * Description: Method to browse and Create a case
	 * Author: Salba
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void browseSelectFirstSerialAndCreateCase(){
		setBrowseProductAffected();
		verifySearchResultColumns();
		selectFirstSerialNumberFromBrowseList();
		describeTheProblemForCase();
		continueTillCaseCreation();	
		
	}
		
	/********************************************************************************************************************
	 * Method : browseAndcreateDuplicateCase
	 * Description: Method to create a dupliacte case - Case creation with Duplicate Case page
	 * Author: Salba
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void browseAndCreateReviewOrDuplicateCase(){
		browseProductAffected();
		describeTheProblemForCase();
		clickContinueButton();
		fillExtraInformationPage();
			
	}
	
	
	/********************************************************************************************************************
	 * Method : searchProductAffected
	 * Description: To search the affected project
	 * Author: Tony George
	 * Date: February-9-2017
	 ********************************************************************************************************************/
	@Test
	public void searchProductAffected()
	{
		searchForProductAffected();
		verifySearchResultColumns();
		selectSearchResult();
	}


	/********************************************************************************************************************
	 * Method : browseProductAffected
	 * Description: To select from the list
	 * Author: Tony George
	 * Date: February-9-2017
	 ********************************************************************************************************************/
	@Test
	public void browseProductAffected()
	{
		setBrowseProductAffected();
		verifySearchResultColumns();
		selectSerialNumberFromBrowseList();

	}
	
	/********************************************************************************************************************
	 * Method : validateSerialNumberNotDisplayedForUser
	 * Description: To select from the list
	 * Author: Tony George
	 * Date: February-9-2017
	 ********************************************************************************************************************/
	@Test
	public void validateSerialNumberNotDisplayedForUser()
	{
		setBrowseProductAffected();
		validateSerialNumberNotDisplayed();

	}
	
	/********************************************************************************************************************
	 * Method : problemDescription
	 * Description: Describe the problem
	 * Author: Tony George
	 * Date: February-10-2017
	 ********************************************************************************************************************/
	@Test
	public void problemDescription()
	{
		describeTheProblemForCase();

	}

	// Commneting as impemeted by other methods
	/********************************************************************************************************************
	 * Method : continueWithCaseCreation
	 * Description: To continue till the case creation page is reached
	 * Author: Tony George
	 * Date: February-10-2017
	 ********************************************************************************************************************//*
	@Test
	public void continueWithCaseCreation()
	{
		fillAgreementPage();
		continueWithCreatingCase();

	}*/

	
	/********************************************************************************************************************
	 * Method : verifySearchResult
	 * Description: Method to only search for the Product Affected
	 * Author: Salba
	 * Date: February-13-2017
	 ********************************************************************************************************************/

	public void verifySearchResult(){
		searchForProductAffected();
		verifySearchResultColumns();
	}
	
	/********************************************************************************************************************
	 * Method : verifyBrowseResult
	 * Description: Method to only Browse for the product affected 
	 * Author: Salba
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void verifyBrowseResult(){
		setBrowseProductAffected();
		verifySearchResultColumns();
	}
	
	
	/********************************************************************************************************************
	 * Method : searchAndReachCreateCasePage
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchAndReachCreateCasePage(){
		browseProductAffected();
		problemDescription();
		continueTillCaseCreation();		
				
	}
	
	/********************************************************************************************************************
	 * Method : searchSerialAndReachCreateCasePage
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchSerialAndReachCreateCasePage(){
		searchProductAffected();
		problemDescription();
		continueTillCaseCreation();		
				
	}
	
	/********************************************************************************************************************
	 * Method : validateDeclinedPageForCreateCase
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void validateDeclinedPageForCreateCase(){
		searchProductAffected();
		problemDescription();
		verifyDeclinedPageForCreateCase();
				
	}
	
	/********************************************************************************************************************
	 * Method : VerifyDeclinedSupport
	 * Description: To verify the declined support details
	 * Author: Tony George
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void VerifyExpiredSerialNumberNotification()
	{
		browseProductAffected();
		problemDescription();
		VerifyExpiredNotification();
				
	}
	
	
	/********************************************************************************************************************
	 * Method : searchAndCreateCaseForExpiredSerial
	 * Description: Create case for Expired Serial
	 * Author: Rajmohan Dhanapal
	 * Date: February-22-2017
	 ********************************************************************************************************************/

	public void searchAndCreateCaseForExpiredSerial()
	{
		searchProductAffected();
		describeTheProblemForCase();
		clickContinueButton();
		setExpiredContract();
		setServiceAgreement();
		fillExtraInformationPage();
	}
	
	
	
	/********************************************************************************************************************
	 * Method : searchAndCreateReviewCase
	 * Description: update case for selected serial number
	 * Author: Sreejith
	 * Date: February-10-2017
	 ********************************************************************************************************************/

	public void searchAndCreateDuplicateCase()
	{
		searchProductAffected();
		describeTheProblemForCase();
		clickContinueButton();
		clickExpiredContract();
		
	}
	
	/********************************************************************************************************************
	 * Method : verifyBrowserDropdown
	 * Description: to verify the presence of verify drop down window
	 * Author: Sreejith
	 * Date: February-15-2017
	 ********************************************************************************************************************/
	public void verifyBrowserDropdown(){
		verifyPresenceBrowserDropdown();
	}
	/********************************************************************************************************************
	 * Method : SearchCaseAnyway
	 * Description: Method to Search and Create a case 
	 * Author: sreejith
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchCaseAnyway(){
		setBrowseProductAffectednNoResults();
		verifySearchResultColumnsNoResults();
		describeTheProblemForCreatecaseAnyway();
		
	}
	
	/********************************************************************************************************************
	 * Method : searchAndReachCreateCasePage
	 * Description: Method to Search and Create a case 
	 * Author: sreejith
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void verifyChatPresentExpiredContractNumber(){
		browseProductAffected();
		describeTheProblemForCase();
		clickContinueButton();
		clickExpiredContract();
		extraInfoContinue();
	}
	
	/********************************************************************************************************************
	 * Method : searchAndReachCreateCasePage
	 * Description:verify ASp end user scenario
	 * Author: sreejith
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void VerifyASPEndUserScenario(){
		searchProductAffected();
		describeTheProblemForCase();
		verifyASP();
	}
	
	/********************************************************************************************************************
	 * Method : browseSelectFirstSerialAndVerifyDescribeProblem
	 * Description: Method to browse and Create a case
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void browseSelectFirstSerialAndVerifyDescribeProblem(){
		setBrowseProductAffected();
		verifySearchResultColumns();
		selectFirstSerialNumberFromBrowseList();
		describeTheProblemForDifferentCaseAndVerifyGLUEName();
	}
	
	/********************************************************************************************************************
	 * Method : searchAndReachCreateCasePageForInvalidSerialNumber
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchAndReachCreateCasePageForInvalidSerialNumber(){
		searchForProductAffected();
		clickCreateCaseAnywayLink();
		problemDescriptionForCreateCaseAnyway();
		continueTillCaseCreation();		
				
	}
	
	/********************************************************************************************************************
	 * Method : searchCreateCasePageForInvalidSerialNumberAndVerifyProblemDescription
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void searchCreateCasePageForInvalidSerialNumberAndVerifyProblemDescription(){
		searchForProductAffected();
		clickCreateCaseAnywayLink();
		verifyProblemDescriptionForCreateCaseAnyway();
	}
	
	/********************************************************************************************************************
	 * Method : BrowseCreateCasePageAndVerifyProblemDescription
	 * Description: Method to Search and Create a case 
	 * Author: Alfred
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void browseCreateCasePageAndVerifyProblemDescription(){
		setBrowseProductAffected();
		verifySearchResultColumns();
		selectFirstSerialNumberFromBrowseList();
		verifyProblemDescriptionForCreateCaseAnyway();
	}
	
	/********************************************************************************************************************
	 * Method : searchAndCreateNewCase
	 * Description: Search and create a new case
	 * Author: Sreejith
	 * Date: February-10-2017
	 ********************************************************************************************************************/

	public void searchAndCreateNewCase()
	{
		searchProductAffected();
		describeTheProblemForCase();
		//clickContinueButton();
		continueTillCaseCreation();
		
		
	}
	
}
