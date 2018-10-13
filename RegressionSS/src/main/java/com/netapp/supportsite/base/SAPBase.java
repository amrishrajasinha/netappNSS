package com.netapp.supportsite.base;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.ust.sarf.reports.DetailedReport.Status;
/**
 * Class : SAPBase
 * @author : UST Global
 */
import com.ust.sarf.testdata.TestDataManage;

public class SAPBase extends Base
{
	  
	   public void enterCredentials() 
	   {
		   waitForElement(TestDataManage.getObjectProperty("UserName_Txtbox"));
		   type(TestDataManage.getObjectProperty("UserName_Txtbox"), TestDataManage.getData("UserName"));
		   type(TestDataManage.getObjectProperty("Password_Txtbox"), TestDataManage.getData("Password"));
		   click("Login_Btn");
		   waitForPageLoad();
		   pause(4000);
		   if(isElementPresent(TestDataManage.getObjectProperty("CancelExsistingLogin_Chkbox"))==true)
		   {
			   //unCheck(TestDataManage.getObjectProperty("CancelExsistingLogin_Chkbox"));
			   click("LoginContinue_Btn");
			   
		   }
	       
	   }
	   
	   public void searchTransaction(String CaseNumber) throws Exception 
	   {
		   switchToFrameByName("CRMApplicationFrame");
		  switchToFrameByName("FRAME_APPLICATION");
		   switchToFrameByName("WorkAreaFrame1");
		   waitForElement(TestDataManage.getObjectProperty("TransactionSearch_Txtbox"));
		   type(TestDataManage.getObjectProperty("TransactionSearch_Txtbox"), CaseNumber);
		   click("TransactionSearchGO_Btn");
	   }
	   
		/********************************************************************************************************************
		* Method : VerifyTransactionDetailPage
		* Description: Validate the Transaction Detail Page in SAP login
		* Author: Rajmohan Dhanapal
		* Date: Feb-23-2017
		 * @throws Exception 
		********************************************************************************************************************/
	   public void VerifyTransactionDetailPage(String CaseNumber) throws Exception 
	   {
		   switchToTopFrame();
		   switchToFrameByName("CRMApplicationFrame");
		   switchToFrameByName("FRAME_APPLICATION");
		   switchToFrameByName("WorkAreaFrame2");
		   isDisplayedWait(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"));
		   waitForElement(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"));
		   verifyContainsText(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"), CaseNumber);
		   verifyContainsText(TestDataManage.getObjectProperty("ValidateSerialNumber_Txt"), TestDataManage.getData("ValidateSerialNumber"));
		   verifyGetValueText(TestDataManage.getObjectProperty("ValidateCatogery1_Txt"), TestDataManage.getData("ValidateCatogery1"));
		   verifyGetValueText(TestDataManage.getObjectProperty("ValidateCatogery2_Txt"), TestDataManage.getData("ValidateCatogery2"));
	   }
	   
	   /********************************************************************************************************************
		* Method : VerifyTransactionDetailPage
		* Description: Validate the Transaction Detail Page in SAP login
		* Author: Rajmohan Dhanapal
		* Date: Feb-23-2017
		********************************************************************************************************************/
	   public String GetCaseNumber() 
	   {
		   String caseNum= getText(TestDataManage.getObjectProperty("CaseNumber_Txt"));
			return caseNum;
	   }

	   /********************************************************************************************************************
		* Method : navigateToMenu
		* Description: Click Left Menu in SAP
		* Author: Alfred Dcruz
		* Date: Mar-07-2017
	 * @throws Exception 
		********************************************************************************************************************/
	   public void navigateToMenu() throws Exception 
	   {
		   switchToTopFrame();
		   switchToFrameByName("CRMApplicationFrame");
		   switchToFrameByName("FRAME_APPLICATION");
		   switchToFrameByName("WorkAreaFrame1");
		   String Menu = TestDataManage.getData("LeftMenu");
		   String LeftMenu = TestDataManage.getObjectValue("LeftMenu_Lnk");
		   String clickLeftMenu = LeftMenu.replace("%s", Menu);
		   waitForElementTime(By.xpath(clickLeftMenu),100);
		   click(By.xpath(clickLeftMenu));
		   sleepFor(10000);
	   }   
	   
	   /********************************************************************************************************************
		* Method : selectDropDownsearchFor
		* Description: Select a Search For Criteria
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
	 * @throws Exception 
		********************************************************************************************************************/
		public void selectDropDownsearchFor() throws Exception
		{
			waitForPageLoad();
			switchToTopFrame();
			switchToFrameByName("CRMApplicationFrame");
			switchToFrameByName("FRAME_APPLICATION");
			switchToFrameByName("WorkAreaFrame1");
			
			String data = TestDataManage.getData("SearchFor");
			waitForElementTime(TestDataManage.getObjectProperty("SearchFor_DrpDwn"), 100);
			click(TestDataManage.getObjectProperty("SearchFor_DrpDwn"));
			if(data.contains("Category")){
				data = "Category";
			}else if(data.contains("SysConfig")){
				data = "SysConfig";
			}else if(data.contains("Part")){
				data = "Part";
			}else{
				System.out.println("Search Dropdown Not found --- FAIL");
			}
			
			String dropdownXpathForSearchFor = TestDataManage.getObjectValue("SearchForCriteriaInDropdown_Lnk");
			dropdownXpathForSearchFor = dropdownXpathForSearchFor.replace("%s", data);
			getDriver().findElement(By.xpath(dropdownXpathForSearchFor)).click();
			sleepFor(3000);
		}
		
		/********************************************************************************************************************
		* Method : selectDropDownsearchFor
		* Description: Select a Search For Criteria
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
		 * @throws Exception 
		********************************************************************************************************************/
		public void selectSubCriteriaSearchFor() throws Exception
		{
			switchToTopFrame();
			switchToFrameByName("CRMApplicationFrame");
			switchToFrameByName("FRAME_APPLICATION");
			switchToFrameByName("WorkAreaFrame1");
			waitForPageLoad();
			String subCriteria = TestDataManage.getData("SubCriteriaField");
			String condition = TestDataManage.getData("Condition");
			
			if(subCriteria.contains("CATEGORY_ID")){
				String subCategoryFieldXpath = TestDataManage.getObjectValue("SubCategoryField_Lbl").replace("%s", subCriteria);
				waitForElementTime(TestDataManage.getObjectProperty("SearchForSubCriteriaField_DrpDwn"), 100);
				click(TestDataManage.getObjectProperty("SearchForSubCriteriaField_DrpDwn"));
				click(By.xpath(subCategoryFieldXpath));
				sleepFor(8000);
				waitForElementTime(TestDataManage.getObjectProperty("SearchForSubCriteriaValue_DrpDwn"), 100);
				click(TestDataManage.getObjectProperty("SearchForSubCriteriaValue_DrpDwn"));
				String subCategoryValueXpath = TestDataManage.getObjectValue("SubCategoryValue_Lbl").replace("%s", TestDataManage.getData("SubCriteriaValue"));
				getDriver().findElement(By.xpath(subCategoryValueXpath)).click();
				sleepFor(8000);
				click(TestDataManage.getObjectProperty("Search_Btn"));
				sleepFor(80000);
				waitUntilElementNotVisible(By.xpath("//div[@id='submitInProgress']"));
			}
				else if(subCriteria.contains("PRODUCT_ID")||subCriteria.contains("SYSCONFIG_STRING"))
				{
				String subCategoryFieldXpath = TestDataManage.getObjectValue("SubCategoryField_Lbl").replace("%s", subCriteria);
				waitForElementTime(TestDataManage.getObjectProperty("SearchForSubCriteriaField_DrpDwn"), 100);
				click(TestDataManage.getObjectProperty("SearchForSubCriteriaField_DrpDwn"));
				click(By.xpath(subCategoryFieldXpath));
				sleepFor(4000);
				waitForElementTime(TestDataManage.getObjectProperty("SearchForSubCriteriaValue_DrpDwn"), 100);
				type(TestDataManage.getObjectProperty("SearchForSubCriteriaValue_DrpDwn"), TestDataManage.getData("SubCriteriaValueArea"));
				sleepFor(4000);
				if(TestDataManage.getData("Condition")!=null)
				{
					String conditionFieldXpath = TestDataManage.getObjectValue("SubCategoryField_Lbl").replace("%s", condition);
					waitForElementTime(TestDataManage.getObjectProperty("SearchForSubCriteriaCondition_DrpDwn"), 100);
					click(TestDataManage.getObjectProperty("SearchForSubCriteriaCondition_DrpDwn"));
					click(By.xpath(conditionFieldXpath));
					sleepFor(4000);
				}
				click(TestDataManage.getObjectProperty("Search_Btn"));
				sleepFor(80000);
				pause(5000);
				waitUntilElementNotVisible(By.xpath("//div[@id='submitInProgress']"));
				}
			
			// Add more if else for more categories.
			
			else{
				getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Search criteria should be available in dropdown.", "Search criteria not available - FAIL", getDriver());
			}
		}
		
		/********************************************************************************************************************
		* Method : getPartInformation
		* Description: TO get part information.
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
		********************************************************************************************************************/
		public ArrayList<String> getPartInformation()
		{
			String MktgPN_Lbl,MfgPN_Lbl,CompIdentifier_Lbl,EndofHW_Lbl,Description_Lbl,Category_Lbl,
			Platform_Lbl,DiskShelfType_Lbl,MinRevOntap_Lbl,MinRevNetCache_Lbl,FirmwareDisk_Lbl,
			SysConfigOut_Lbl,Dependencies_Lbl,AlternateParts_Lbl,WarningNote_Lbl,Notes_Lbl,CustomerOrderable_lbl,
			QualDevONTAP_Lbl;
			ArrayList<String> verifyInfoList = new ArrayList<String>();
			waitForPageLoad();
			waitForElementTime(TestDataManage.getObjectProperty("MktgPN_Lbl"), 100);
			MktgPN_Lbl = getText(TestDataManage.getObjectProperty("MktgPN_Lbl")).trim();
			verifyInfoList.add(MktgPN_Lbl);
			MfgPN_Lbl = getText(TestDataManage.getObjectProperty("MfgPN_Lbl")).trim();
			verifyInfoList.add(MfgPN_Lbl);
			CompIdentifier_Lbl = getText(TestDataManage.getObjectProperty("CompIdentifier_Lbl")).trim();
			verifyInfoList.add(CompIdentifier_Lbl);
			EndofHW_Lbl = getText(TestDataManage.getObjectProperty("EndofHW_Lbl")).trim();
			verifyInfoList.add(EndofHW_Lbl);
			Description_Lbl = getText(TestDataManage.getObjectProperty("Description_Lbl")).trim();
			verifyInfoList.add(Description_Lbl);
			Category_Lbl = getText(TestDataManage.getObjectProperty("Category_Lbl")).trim();
			verifyInfoList.add(Category_Lbl);
			Platform_Lbl = getText(TestDataManage.getObjectProperty("Platform_Lbl")).trim();
			verifyInfoList.add(Platform_Lbl);
			DiskShelfType_Lbl = getText(TestDataManage.getObjectProperty("DiskShelfType_Lbl")).trim();
			verifyInfoList.add(DiskShelfType_Lbl);
			MinRevOntap_Lbl = getText(TestDataManage.getObjectProperty("MinRevOntap_Lbl")).trim();
			verifyInfoList.add(MinRevOntap_Lbl);
			MinRevNetCache_Lbl = getText(TestDataManage.getObjectProperty("MinRevNetCache_Lbl")).trim();
			verifyInfoList.add(MinRevNetCache_Lbl);
			FirmwareDisk_Lbl = getText(TestDataManage.getObjectProperty("FirmwareDisk_Lbl")).trim();
			verifyInfoList.add(FirmwareDisk_Lbl);
			SysConfigOut_Lbl = getText(TestDataManage.getObjectProperty("SysConfigOut_Lbl")).trim();
			verifyInfoList.add(SysConfigOut_Lbl);
			Dependencies_Lbl = getText(TestDataManage.getObjectProperty("Dependencies_Lbl")).trim();
			verifyInfoList.add(Dependencies_Lbl);
			AlternateParts_Lbl = getText(TestDataManage.getObjectProperty("AlternateParts_Lbl")).trim();
			verifyInfoList.add(AlternateParts_Lbl);
			WarningNote_Lbl = getText(TestDataManage.getObjectProperty("WarningNote_Lbl")).trim();
			verifyInfoList.add(WarningNote_Lbl);
			Notes_Lbl = getText(TestDataManage.getObjectProperty("Notes_Lbl")).trim();
			verifyInfoList.add(Notes_Lbl);
			CustomerOrderable_lbl = getText(TestDataManage.getObjectProperty("CustomerOrderable_lbl")).trim();
			verifyInfoList.add(CustomerOrderable_lbl);
			QualDevONTAP_Lbl = getText(TestDataManage.getObjectProperty("QualDevONTAP_Lbl")).trim();
			verifyInfoList.add(QualDevONTAP_Lbl);

			return verifyInfoList;
		}
		
		/********************************************************************************************************************
		* Method : getPartNumber
		* Description: TO get part number.
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
		********************************************************************************************************************/
		public String getPartNumber()
		{
			waitForPageLoad();
			waitForElementTime(TestDataManage.getObjectProperty("MktgPN_Lbl"), 100);
			String partNumber = getText(TestDataManage.getObjectProperty("MktgPN_Lbl"));
			return partNumber;
		}
		
		/********************************************************************************************************************
		* Method : clickOnPartNumberSAP
		* Description: TO click on part number.
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
		 * @throws Exception 
		********************************************************************************************************************/
		public void clickOnPartNumberSAP(String PartNumber) throws Exception
		{
			switchToTopFrame();
			switchToFrameByName("CRMApplicationFrame");
			switchToFrameByName("FRAME_APPLICATION");
			switchToFrameByName("WorkAreaFrame1");
			sleepFor(120);
			int count = 0;
			String xpathForPartNumber = TestDataManage.getObjectValue("PartNumberSAP_Lnk").replace("%s", PartNumber.trim());
			waitForPageLoad();
			for(int i=0; i <10; i++){
				if(isElementPresent(By.xpath(xpathForPartNumber)))
				{
					getDriver().findElement(By.xpath(xpathForPartNumber)).click();
					count = count+1;
					break;
				}
				else if (isElementPresent(TestDataManage.getObjectProperty("Forward_Lnk"))){
					click(TestDataManage.getObjectProperty("Forward_Lnk"));
					Thread.sleep(5000);
				}
				/*else{
					getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Part number should be visible for criteria search.", "Part number not available - FAIL", getDriver());
					break ;
				}*/
			}
			if(count==0){
				getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Part number should be visible for criteria search.", "Part number not available - FAIL", getDriver());
			}
		}
		
		/********************************************************************************************************************
		* Method : clickOnPartNumberSAP
		* Description: TO click on part number.
		* Author: Alfred Dcruz
		* Date: Mar-06-2017
		 * @throws Exception 
		********************************************************************************************************************/
		public void validatePartInformation(ArrayList<String> partNumberInformation) throws Exception
		{
			switchToTopFrame();
			switchToFrameByName("CRMApplicationFrame");
			switchToFrameByName("FRAME_APPLICATION");
			switchToFrameByName("WorkAreaFrame1");
			waitForPageLoad();
			int count =0;
			waitForElementTime(TestDataManage.getObjectProperty("ProductIDSAP_Lbl"),200);
			String ProductIDSAP, DescriptionSAP, BaseCategorySAP, PlatformSAP;
			ProductIDSAP = getText(TestDataManage.getObjectProperty("ProductIDSAP_Lbl")).trim();
			DescriptionSAP = getText(TestDataManage.getObjectProperty("DescriptionSAP_Lbl")).trim();
			BaseCategorySAP = getText(TestDataManage.getObjectProperty("BaseCategorySAP_Lbl")).trim();
			PlatformSAP = getText(TestDataManage.getObjectProperty("PlatformSAP_Lbl")).trim();
			
			for (String string : partNumberInformation) {
	               if(string.contains(ProductIDSAP)||string.contains(DescriptionSAP)||string.contains(BaseCategorySAP)||string.contains(PlatformSAP)){
	                   ++count;
	               }
			}
	               if(count<3){
	            	   getDetailedReport().WriteLog(Status.FAIL, "Case invalid. Part information should match.", "Part number not matching - FAIL", getDriver());
			}else{
				getDetailedReport().WriteLog(Status.PASS, "Case valid. Part information should match.", "Part number information matching - PASS", getDriver());
			}
		}
		
		
		
		
		

		/********************************************************************************************************************
		* Method : VerifyTransactionDetailPage
		* Description: Validate the Transaction Detail Page in SAP login
		* Author: Sreejith
		* Date: Mar-23-2017
		 * @throws Exception 
		********************************************************************************************************************/
	   public void VerifyTransactionDetailPage_Logistices(String CaseNumber) throws Exception 
	   {
		   switchToTopFrame();
		   switchToFrameByName("CRMApplicationFrame");
		   switchToFrameByName("FRAME_APPLICATION");
		   switchToFrameByName("WorkAreaFrame2");
		   isDisplayedWait(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"));
		   waitForElement(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"));
		   verifyContainsText(TestDataManage.getObjectProperty("DetailsPageHeader_Txt"), CaseNumber);
		   verifyContainsText(TestDataManage.getObjectProperty("ValidateSerialNumber_Txt"), TestDataManage.getData("ValidateSerialNumber"));
		   
	   }
	   
}





