package com.netapp.supportsite.base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.googlecode.sqlsheet.Driver;

import org.openqa.selenium.support.ui.Select;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;
import com.ust.sarf.utils.Config;
import com.ust.sarf.utils.SeleniumHelper;


public class Base  extends SeleniumHelper {


	/********************************************************************************************************************
	 * Method : waitForPageReady
	 * Description: Waits till the page is completely loaded
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void waitForPageReady() {
		waitForPageLoad();
	}


	/********************************************************************************************************************
	 * Method : verifyTitle
	 * Description: Waits for the specified page title is displayed 
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void verifyTitle(String title) {
		waitForTitle(title);
	}


	/********************************************************************************************************************
	 * Method : openNewBrowserWindow
	 * Description: To open a new browser window 
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void openNewBrowserWindow() {
		getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "n"));
	}

	/********************************************************************************************************************
	 * Method : switchToNewWindow
	 * Description: To switch the control to the new widow opened 
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/
	public String switchToNewWindow(){
		// Store the current window handle
		String winHandleBefore = getDriver().getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle);			
		}
		return winHandleBefore;
	}

	
	/********************************************************************************************************************
	 * Method : verifyText
	 * Description: To get the text of an element and verifies it matched with the expected 
	 * Author: Charles
	 * Modifed : Salba Balakrishnan
	 * Modified:Sreejith
	 * Date: September-2-2016
	 * Date:Feb-23-2016
	 ********************************************************************************************************************/

	public boolean verifyText(By by, String expected) {
		expected = expected.trim();
		String actual = getDriver().findElement(by).getText();
		if(actual.equals(expected))
		{	 
			getDetailedReport().WriteLog(Status.PASS, "Field Details: verfying text: "+expected+ ". Expected Button/Link  click", "Actual text is  present .", getDriver());
			return true;
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Field Details: verfying text: "+expected+ ". Expected Button/Link  click", "Actual text is not present .", getDriver());

			return false;
		}
	}
	/********************************************************************************************************************
	 * Method : verifyByValue
	 * Description: To click and element and get the value of an element and verifies it matched with the expected 
	 * Author: Charles
	 * Modifed : Salba Balakrishnan
	 * Date: September-2-2016
	 ********************************************************************************************************************/
	public void verifyValue(By by, String expected) {
		expected = expected.trim();
		click(by);
		verifyProperties(by, "value", expected);

	}
	/********************************************************************************************************************
	 * Method : verifyTextContains
	 * Description: To get the text of an element and verifies it contained the expected 
	 * Author: Charles
	 * Modifed : Salba Balakrishnan
	 * Date: September-2-2016
	 ********************************************************************************************************************/

	public void verifyTextContains(By by, int index, String expected) {

		verifyPropertyContains(by, index, "text", expected.trim());

	}

	/********************************************************************************************************************
	 * Method : clickIfContainsData
	 * Description: To click an element if it contains the data specified 
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void clickIfContainsData(String data){
		String elementLocator = "//*[contains(text(),'%s')]";
		if(data != null && data != ""){
			data = String.format(elementLocator, data);
			click(By.xpath(data));
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+data+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());
		}

	}

	/********************************************************************************************************************
	 * Method : clickByData
	 * Description: To click an element if the text of the element matches the data specifed  
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void clickByData(String data){
		String elementLocator = "//*[text()='%s']";
		data = data.trim();
		if(data != null && data != ""){
			data = String.format(elementLocator, data);
			waitForClickable(getElement(By.xpath(data)));
			click(By.xpath(data));
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+data+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());
		}

	}

	/********************************************************************************************************************
	 * Method : selectbyVisibleText
	 * Description: To set the value from a Select combobox based on the text  
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/

	public void selectbyVisibleText(By elementLocator, String text){
		if(text!=null && text!="" && text!="^"){
			Select s = new Select(getDriver().findElement(elementLocator));
			s.selectByVisibleText(text);
			getDetailedReport().WriteLog(Status.PASS, "Field Details: By.xpath: "+elementLocator+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());

		}
	}

	/********************************************************************************************************************
	 * Method : waitForStale
	 * Description: Wait for a particular element to become stale / Wait till navigated to next page or page refreshed
	 * Author: Salba
	 * Date: Feb-22-2016
	 ********************************************************************************************************************/	
	public void waitForStale(By elementLocator){
		WebElement element = getDriver().findElement(elementLocator);
		long waitTime = Long.parseLong(Config.getConfig("WebDriverWaitSeconds"));
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
			wait.until(ExpectedConditions.stalenessOf(element));	
		}catch(Exception e){

		}
	}




	/********************************************************************************************************************
	 * Method : waitForElement
	 * Description: To wait for an element, till it is displayed , polling in every 100ms  
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/



	public WebElement waitForElement(final By ObjId){
		try{    new FluentWait<WebDriver>(getDriver()).
			withTimeout(60, TimeUnit.SECONDS).
			pollingEvery(100,TimeUnit.MILLISECONDS).
			until(new Predicate<WebDriver>() {

				public boolean apply(WebDriver driver) {
					try{
						Boolean booFlag= driver.findElement(ObjId).isDisplayed();
						//  System.out.println("I am wait ");
						if(booFlag)
							return true;
						else
							return false;
					}
					catch(Exception e)
					{
						return false;
					}
				}
			}
					);
		}catch(Exception e){
			e.printStackTrace();
			throw new WebDriverException("Unable to locate ELement : "+ObjId+" . \n"+e.getMessage());

		}
		return getDriver().findElement(ObjId);

	}

	/********************************************************************************************************************
	 * Method : bypassZscaler
	 * Description: UST Proxy Setup : Method to bypass the UST proxy settings  
	 * Author: Salba Balakrishnan
	 * Date: August-25 -2016
	 ********************************************************************************************************************/


	public void bypassZscaler(){
		System.out.println("Bypass Zscaler is turned ON");
		pause(10000);
		boolean zsclarbtn= isElementPresent(By.xpath("//input[@value='I Accept']"));
		if(zsclarbtn)
			getDriver().findElement(By.xpath("//input[@value='I Accept']")).click();

	}

	/********************************************************************************************************************
	 * Method : getElement
	 * Description: To find  the WebElement based on the input elementLocator and return it  
	 * Author: Salba Balakrishnan
	 * Date: September-2-2016
	 ********************************************************************************************************************/

	public WebElement getElement(By elementLocator){
		waitForElement(elementLocator);
		return(getDriver().findElement(elementLocator));


	}

	/********************************************************************************************************************
	 * Method : isDisplayedWait
	 * Description: To Wait max 70 seconds for the element and return true if not will return false
	 * Author: Rajmohan
	 * Date: Oct-27-2016
	 ********************************************************************************************************************/
	public boolean isDisplayedWait(By elementLocator){
		final By ObjId = elementLocator;
		//final By ObjId = TestDataManage.getObjectProperty(elementLocatorText);
		try{    new FluentWait<WebDriver>(getDriver()).
			withTimeout(25, TimeUnit.SECONDS).
			pollingEvery(100,TimeUnit.MILLISECONDS).
			until(new Predicate<WebDriver>() {
				public boolean apply(WebDriver driver) {
					try{
						Boolean booFlag;
						booFlag= driver.findElement(ObjId).isDisplayed();
						if(booFlag)
							return booFlag;
						else
							return booFlag;
					}
					catch(Exception e)
					{
						return false;
					}
				}
			}
					);
		}catch(Exception e){
			return false;
		}
		return true;

	}

	/********************************************************************************************************************
	 * Method : getElement
	 * Description: To find  the WebElement based on the input elementLocatorText and return it  
	 * Author: Salba Balakrishnan
	 * Date: September-2-2016
	 ********************************************************************************************************************/


	public WebElement getElement(String elementLocatorText){
		By elementLocator = TestDataManage.getObjectProperty(elementLocatorText);
		waitForElement(elementLocator);
		return(getDriver().findElement(elementLocator));

	}



	/********************************************************************************************************************
	 * Method : getElements
	 * Description: To find the list of WebElements based on the input elementLocator and return it  
	 * Author: Salba Balakrishnan
	 * Date: August-25-2016
	 ********************************************************************************************************************/


	public List<WebElement> getElements(By elementLocator){
		//waitForElement(elementLocator);
		return(getDriver().findElements(elementLocator));

	}

	/********************************************************************************************************************
	 * Method : getElement
	 * Description: To find a WebElement from a list of WebElements based on the input elementLocator and index and return it  
	 * Author: Salba Balakrishnan
	 * Date: September-2-2016
	 ********************************************************************************************************************/


	public WebElement getElement(By elementLocator, int index){
		waitForElement(elementLocator);
		return(getDriver().findElements(elementLocator).get(index));

	}

	/********************************************************************************************************************
	 * Method : handlingPopups
	 * Description: To handle the pop ups in the Services page by clicking OK button
	 * Author: Anoop Babu
	 * Date: September-1-2016
	 ********************************************************************************************************************/

	public void handlingPopups(By objId){

		boolean isVisible= getDriver().findElements(objId).size() > 0;
		if(isVisible)
		{							
			waitForElement(objId);
			waitForClickable(objId);
			//Added is Displayed logic to click only if visisble
			if(getElement(objId).isDisplayed())			
				getElement(objId).click();
		}

	}

	/********************************************************************************************************************
	 * Method : compareDropdownValues
	 * Description: To compare the values in a dropdown with the user provided values
	 * Author: Salba Balakrishnan
	 * Date: September-1-2016
	 ********************************************************************************************************************/
	public boolean compareDropdownValues(By selectLocator,String selectOption, String[] data){
		//String[] data = TestDataManage.getData(colName).trim().split("[|]");
		Select dropdown = new Select(getElement(selectLocator));
		List<WebElement> options = dropdown.getOptions();
		//Getting the dropdown values from UI
		String[] dropdownData= null;
		for(int i=0;i<options.size();i++){
			if(selectOption.equalsIgnoreCase("text")){
				dropdownData[i] = options.get(i).getText();
			}else if(selectOption.equalsIgnoreCase("value")){
				dropdownData[i] = options.get(i).getAttribute("value");
			}
		}
		// Comparing the excel values and dropdown values
		boolean dataFound = false;
		for(int i=0;i<data.length;i++){
			for(int j=0;j<dropdownData.length;j++){
				if(data[i].equalsIgnoreCase(dropdownData[j])){
					dataFound = true;
					break;
				}
			}
			if(!dataFound)
				return false; 
		}

		return true;

	}



	/********************************************************************************************************************
	 * Method : selectbyText
	 * Description: To set the value from a Select combobox based on the text  
	 * Author: Rajmohan Dhanapal
	 * Date: September-09 -2016
	 ********************************************************************************************************************/

	public void selectbyText(By elementLocator, String text){
		if(text!=null && text!=""){
			getDriver().findElement(elementLocator).click();
			WebElement Select=getDriver().findElement(elementLocator);
			System.out.println(Select.getSize());
			List<WebElement> ListDetails=Select.findElements(By.tagName("option"));
			for(WebElement List:ListDetails){
				System.out.println(List.getText());
				if(List.getText().equalsIgnoreCase(text)){
					List.click();
				}

			}
			getDetailedReport().WriteLog(Status.PASS, "Field Details: By.xpath: "+elementLocator+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());

		}
	}



	/********************************************************************************************************************
	 * Method : IsElementPresent
	 * Description: Checks if the element is present in the page 
	 * Author: Salba Balakrishnan
	 * Date: September-26-2016
	 ********************************************************************************************************************/	
	public boolean isElementPresent(By elementLocator){
		try{
			getDriver().findElement(elementLocator);
		}catch(org.openqa.selenium.NoSuchElementException e){
			return false;
		}
		
		return true ; 
	}

	/********************************************************************************************************************
	 * Method : IsElementPresent
	 * Description: Checks if the element is present in the page 
	 * Author: Salba Balakrishnan
	 * Date: September-26-2016
	 ********************************************************************************************************************/	
	public boolean isElementPresent(String ORlocator){
		try{
			getDriver().findElement(TestDataManage.getObjectProperty(ORlocator));
		}catch(org.openqa.selenium.NoSuchElementException e){
			return false;
		}
		return true ; 
	}
	/********************************************************************************************************************
	 * Method : isClicked
	 * Description: Checks if the element is clicked in the page 
	 * Author: Salba Balakrishnan
	 * Date: October-5-2016
	 ********************************************************************************************************************/	
	public boolean isClicked(String elementLocatorText){
		try{
			WebElement element  = getElement(TestDataManage.getObjectProperty(elementLocatorText));
			if(element.getAttribute("checked").equalsIgnoreCase("true")){
				return true;
			}else
				return false;
		}catch(Exception e){
			//e.printStackTrace();
			//System.out.println(elementLocatorText+" is not clicked");
		}
		return false;
	}

	/********************************************************************************************************************
	 * Method : isChecked
	 * Description: Checks if the element is checked using xpath in the page 
	 * Author: Rajmohan Dhanapal
	 * Date: Nov-8-2016
	 ********************************************************************************************************************/	
	public boolean isChecked(String elementXpathLocatorText){
		try{
			WebElement element  = getElement(By.xpath(elementXpathLocatorText));
			if(element.getAttribute("checked")!=null && element.getAttribute("checked").equalsIgnoreCase("true"))
				return true;
			else if(element.getAttribute("src")!=null && element.getAttribute("src").contains("selected")){
				return true;
			}else if(element.isSelected()){
				return true;
			}
		}catch(Exception e){

		}
		return false;

	}
	/********************************************************************************************************************
	 * Method : isAttributePresent
	 * Description: Checks if the element has a specific attribute
	 * Author: Salba Balakrishnan
	 * Date: Jan-11-2017
	 ********************************************************************************************************************/	

	public boolean isAttributePresent(WebElement element, String attribute){
		try{
			element.getAttribute(attribute);
			return true;

		}catch(Exception e){
			//e.printStackTrace();
			//System.out.println(elementLocatorText+" is not clicked");
		}
		return false;
	}
	/********************************************************************************************************************
	 * Method : clickIfNotClicked
	 * Description: This methof will check if the element is clicked and if not will click again
	 * Author: Salba Balakrishnan
	 * Date: October-5-2016
	 ********************************************************************************************************************/	
	public void clickIfNotClicked(String elementLocatorText){
		if(!isClicked(elementLocatorText)){
			getElement(TestDataManage.getObjectProperty(elementLocatorText)).click();
		}
	}

	/********************************************************************************************************************
	 * Method : chooseDropDown
	 * Description: Added common method to select the drop down
	 * Author: Rajmohan
	 * Date: Oct-15-2016
	 ********************************************************************************************************************/
	public void chooseDropDown(String testInput, String objRep){
		testInput = testInput.trim();
		if(columnExist(testInput)){
			if(!TestDataManage.getData(testInput).equals("^"))
			{
				waitForElement(TestDataManage.getObjectProperty(objRep));
				selectbyVisibleText(TestDataManage.getObjectProperty(objRep), TestDataManage.getData(testInput).trim());
				//	getElement(TestDataManage.getObjectProperty(objRep)).sendKeys(Keys.ENTER);
				waitForPageReady();
			}
		}


	}

	/********************************************************************************************************************
	 * Method : setTextBox
	 * Description: Added common method to Enter in text box
	 * Author: Rajmohan
	 * Date: Oct-15-2016
	 ********************************************************************************************************************/
	public void setTextBox(String testInput,String objRep){
		testInput = testInput.trim();

		if(columnExist(testInput)){	
			if(!TestDataManage.getData(testInput).equals("^"))
			{
				waitForElement(TestDataManage.getObjectProperty(objRep));
				getElement(TestDataManage.getObjectProperty(objRep)).clear();      
				type(TestDataManage.getObjectProperty(objRep), TestDataManage.getData(testInput).trim());       
				// getDriver().findElement(By.xpath("//div[(@id='AppBodyHeader')]/table/tbody/tr/td/div/img")).click();
				getElement(TestDataManage.getObjectProperty(objRep)).sendKeys(Keys.ENTER);
			}
		}

	}

	/********************************************************************************************************************
	 * Method : clickElement
	 * Description: Added common method to click the Web Element
	 * Author: Rajmohan
	 * Date: Oct-15-2016
	 ********************************************************************************************************************/
	public void clickElement(String testInput,String objRep){
		testInput = testInput.trim();

		if(columnExist(testInput)){	
			if(!TestDataManage.getData(testInput).equals("^"))
			{
				waitForElement(TestDataManage.getObjectProperty(objRep));
				click(objRep);		
			}
		}	
	}

	/********************************************************************************************************************
	 * Method : checkBoxClick
	 * Description: Added common method to check the check box
	 * Author: Rajmohan
	 * Updated on : Nov-03-2016
	 * Date: Oct-15-2016
	 ********************************************************************************************************************/
	public void checkBoxClick(String testInput,String objRep){
		testInput = testInput.trim();

		if(columnExist(testInput)){	
			String testData = TestDataManage.getData(testInput).trim();
			if(!testData.equalsIgnoreCase("^"))
			{
				if(testData.equalsIgnoreCase("UNCHECKED")){
					if(isClicked(objRep))
					{

						waitForElement(TestDataManage.getObjectProperty(objRep));
						waitForClickable(getElement(TestDataManage.getObjectProperty(objRep)));
						click(objRep);
						getElement(TestDataManage.getObjectProperty(objRep)).sendKeys(Keys.ENTER);

					}
				}
				else{
					if(!isClicked(objRep))
					{

						waitForElement(TestDataManage.getObjectProperty(objRep));
						waitForClickable(getElement(TestDataManage.getObjectProperty(objRep)));
						click(objRep);
						getElement(TestDataManage.getObjectProperty(objRep)).sendKeys(Keys.ENTER);

					}

				}
				waitForPageReady();
			}
		}

	}

	/********************************************************************************************************************
	 * Method : columnExist
	 * Description: Method to check column Exist in the Test case sheet
	 * Author: Salba
	 * Date : Nov-04-2016
	 ********************************************************************************************************************/

	public boolean columnExist(String colName){
		try {
			colName = colName.trim();
			if(TestDataManage.ColumnExist(colName)){
				return true;
			}

		} catch (SQLException e) {

			throw new RuntimeException("Verify TestCase sheet Field Name : "
					+ colName + " .  Field Name " + colName
					+ " does not exist in Test Case sheet");
		}
		return false;

	}

	/********************************************************************************************************************
	 * Method : checkMultipleCheckbox
	 * Description: Common function to select multiple check boxes which separated by | symbol
	 * Author: Rajmohan
	 * Date: Nov-8-2016
	 ********************************************************************************************************************/
	public void checkMultipleCheckbox(String getObjectRep, String checkBoxItems){
		if(checkBoxItems.contains("|")){
			String[] softwareType = checkBoxItems.split("[|]");
			int len = softwareType.length;
			for(int i=0;i<len;i++ ){
				waitForPageLoad();
				String data = softwareType[i];
				if(data != null && data != ""){
					data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
					if(!isChecked(data)){
						waitForClickable(getElement(By.xpath(data)));
						//clickElementUsingJS(By.xpath(data));
						click(By.xpath(data));
						getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+data+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());
					}
				}
			}
		}else{
			String data = checkBoxItems;
			data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
			if(!isChecked(data)){
				waitForClickable(getElement(By.xpath(data)));
				//clickElementUsingJS(By.xpath(data));
				click(By.xpath(data));
				getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+data+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());
			}
		}
	}



	/********************************************************************************************************************
	 * Method : setTextField
	 * Description: Added common method to enter the value in text filed with dynamic xpath
	 * Author: Sobhana P.
	 * Date: Nov-04-2016
	 ********************************************************************************************************************/
	public void setTextField(String elementXpath,String excelColumn){
		excelColumn=excelColumn.trim();
		if (columnExist(excelColumn)) {
			if (!TestDataManage.getData(excelColumn).equals("^")) {
				waitForElement(By.xpath(elementXpath));
				getElement(By.xpath(elementXpath)).sendKeys(Keys.chord(Keys.CONTROL, "a"),TestDataManage.getData(excelColumn).trim() + Keys.ENTER);
				getDetailedReport().WriteLog(Status.PASS,
						"Field Details: Set Text for: " + elementXpath
						+ ". Expected Set Text",
						"Actual Set the Text.", getDriver());
			}
		} 
	}

	/********************************************************************************************************************
	 * Method : clickRadioButton(With dynamic xpath)
	 * Description: Added common method to click a radio button with dynamic xpath
	 * Author: Sobhana P.
	 * Date: Nov-08-2016
	 ********************************************************************************************************************/

	public void clickOption(String elementXpath,String excelColumn){
		excelColumn=excelColumn.trim();
		if (columnExist(excelColumn)) {
			if (!TestDataManage.getData(excelColumn).equals("^")) {
				waitForElement(By.xpath(elementXpath));
				if(!getElement(By.xpath(elementXpath)).isSelected())
					clickElementUsingJS(By.xpath(elementXpath));
				//getElement(By.xpath(elementXpath)).click();
				getDetailedReport().WriteLog(Status.PASS,
						"Field Details: Click By Text: " + elementXpath
						+ ". Expected Button/Link  click",
						"Actual Button/Link  clicked  .", getDriver());
			}
		} 

	}

	/********************************************************************************************************************
	 * Method : setMultipleTextbox
	 * Description: Common function to enter values multiple text boxes which separated by | symbol
	 * Author: Rajmohan
	 * Date: Nov-16-2016
	 ********************************************************************************************************************/
	public void setMultipleTextbox(String getObjectRep, String getTextTypes){
		if(getTextTypes.contains("|")){
			String[] softwareType = getTextTypes.split("[|]");
			int len = softwareType.length;
			for(int i=0;i<len;i++ ){
				waitForPageLoad();
				String inputTextValue = softwareType[i].split("=")[1];
				String elementXpath = softwareType[i].split("=")[0];
				System.out.println(inputTextValue+" "+elementXpath);
				if(elementXpath != null && elementXpath != ""){
					elementXpath = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), elementXpath);
					System.out.println(elementXpath);
					waitForElement(By.xpath(elementXpath));
					getElement(By.xpath(elementXpath)).sendKeys(Keys.chord(Keys.CONTROL, "a"),inputTextValue + Keys.ENTER);
					getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+elementXpath+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());

				}
			}
		}else{
			String inputTextValue = getTextTypes.split("=")[1];
			String elementXpath = getTextTypes.split("=")[0];
			System.out.println(inputTextValue+elementXpath);
			elementXpath = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), elementXpath);
			waitForElement(By.xpath(elementXpath));
			getElement(By.xpath(elementXpath)).sendKeys(Keys.chord(Keys.CONTROL, "a"),inputTextValue + Keys.ENTER);
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Click By Text: "+elementXpath+ ". Expected Button/Link  click", "Actual Button/Link  clicked  .", getDriver());

		}
	}

	/********************************************************************************************************************
	 * Method : setMultipleTextbox
	 * Description: Clicking element using JavascriptExecutor
	 * Author: Sobhana P.
	 * Date: Dec-26-2016
	 ********************************************************************************************************************/
	public void clickElementUsingJS(By elementXpath){
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", getDriver().findElement(elementXpath));
		getDetailedReport().WriteLog(Status.PASS, "Field Details:  By.xpath: "+elementXpath+" . Expected Button/Link  click  .","   Actual Button/Link  clicked  .", getDriver());

	}
	/********************************************************************************************************************
	 * Method : selectDropDown
	 * Description: Select by visisble text from a dropdown based on the xpath locator and input value from data sheet
	 * Author: Salba Balakrishnan
	 * Date: Jan-16-2017
	 ********************************************************************************************************************/
	public void selectDropDown(String excelCol, String xpathLocator){
		excelCol = excelCol.trim();
		if(columnExist(excelCol)){
			if(!TestDataManage.getData(excelCol).equals("^"))
			{
				waitForElement(By.xpath(xpathLocator));
				selectbyVisibleText(By.xpath(xpathLocator), TestDataManage.getData(excelCol).trim());
				waitForPageReady();
			}
		}


	}
	/********************************************************************************************************************
	 * Method : setXpath
	 * Description: Creates an xpath by replacing the %s in the field in OR with value in Test Data excel
	 * Author: Salba Balakrishnan
	 * Date: Jan-19-2017
	 ********************************************************************************************************************/
	public String setXpath(String objRep, String excelCol){
		String xpath = "";
		if(columnExist(excelCol)){
			xpath = String.format(TestDataManage.getObjectValue(objRep,"XPATH"), TestDataManage.getData(excelCol).trim());
		}
		return xpath;

	}

	/********************************************************************************************************************
	 * Method : clickWarningYes
	 * Description: To identify if it a warning page and click Yes
	 * Author: Salba Balakrishnan
	 * Date: Jan-23-2017
	 ********************************************************************************************************************/
	public void clickWarningYes(){
		waitForPageReady();
		String warningHeader = "//h1[contains(text(),'Warning:')]";
		if(getElement(By.xpath(warningHeader)).isDisplayed()){
			click(By.xpath("//button[@title='Confirm Action']"));
			waitForPageReady();
		}
	}



	/********************************************************************************************************************
	 * Method : SwitchToFrameByName
	 * Description: Switch to new frame by name of the frame
	 * Author: Tony George
	 * Date: December-9-2016
	 * @throws Exception 
	 ********************************************************************************************************************/	
	public boolean switchToFrameByName(String frameName) throws Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			//getDriver().switchTo().frame(frameName);

			return true;
		}
		catch(Exception e)
		{
			/*getDetailedReport().WriteLog(Status.FAIL,
					"Waited for the frame : "+frameName ,
					"Frame not present", getDriver());
			throw e; */
			return true;
		}


	}


	/********************************************************************************************************************
	 * Method : VerifyElementNotPresent
	 * Description: Element is not present in the page
	 * Author: Tony George
	 * Date: December-9-2016
	 ********************************************************************************************************************/	
	public boolean verifyElementNotPresent(String elementLocator)
	{
		try{
			if(isElementPresent(elementLocator)==false)
			{
				getDetailedReport().WriteLog(Status.PASS, "Verifying "+elementLocator+ "is not present", elementLocator+" is not present.", getDriver()); 
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Verifying "+elementLocator+ "is not present", elementLocator+" is present.", getDriver()); 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	/********************************************************************************************************************
	 * Method : verifyAlertText
	 * Description: To verify the alert text and accept the alert
	 * Author: Tony George
	 * Date: December-13-2016
	 ********************************************************************************************************************/	
	public boolean verifyAlertTextAndAccept(String ExpectedAlertText)
	{
		try
		{
			pause(2000);
			Alert alert = getDriver().switchTo().alert();
			String alertText=alert.getText();
			if(alertText.contains(ExpectedAlertText))
			{
				getDetailedReport().WriteLog(Status.PASS,"Verify Alert Text: Expected Alert text : "+ExpectedAlertText," Expected Alert text is present",getDriver());	

			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL,"Verify Alert Text: Expected Alert text : "+ExpectedAlertText," Alert Text Present is "+alertText,getDriver());

			}
			alert.accept();
			return true;


		}	
		catch(Exception e)
		{

			return false;
		}

	}



	/********************************************************************************************************************
	 * Method : ClickSubmenu
	 * Description: To move to the main menu and click the submenu
	 * Author: Tony George
	 * Date: Jan-18-2017
	 ********************************************************************************************************************/
	public void clickSubmenu(String MainMenuLocator,String SubMenu)
	{
		Actions action = new Actions(getDriver());
		WebElement element  = getElement(TestDataManage.getObjectProperty(MainMenuLocator));
		action.moveToElement(element).perform();
		By locator=By.xpath("//span[text()='"+SubMenu+"']");
		click(locator);
	}



	/********************************************************************************************************************
	 * Method : checkMultipleElementDisplayed
	 * Description: Common function to validate the multiple elements separated by | symbol
	 * Author: Rajmohan
	 * Date: Feb-07-2016
	 ********************************************************************************************************************/
	public void checkMultipleElementDisplayed(String getObjectRep, String testInput)
	{
		String getElementTypes = TestDataManage.getData(testInput).trim();
		if(!getElementTypes.equalsIgnoreCase("^"))
		{
			if(getElementTypes.contains("|")){
				String[] elementType = getElementTypes.split("[|]");
				int len = elementType.length;
				for(int i=0;i<len;i++ ){
					waitForPageLoad();
					String data = elementType[i];
					if(data != null && data != ""){
						data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
						WebElement element=getDriver().findElement(By.xpath(data));
						moveToElement(By.xpath(data));
						if(element.isDisplayed())	
						{
							getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected "+elementType[i]+" should be Displyaed", "Actual "+elementType[i]+" Displayed ."+ " "+data, getDriver());
						}
						else
						{
							getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected "+elementType[i]+" should be Displyaed", "Actual "+elementType[i]+" is not Displayed ."+ " "+data, getDriver());
						}
					}
				}

			}else{
				String data = getElementTypes;
				data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
				WebElement element=getDriver().findElement(By.xpath(data));
				if(element.isDisplayed())	
				{
					getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected "+getElementTypes+" should be Displyaed", "Actual "+getElementTypes+" Displayed ."+ " "+data, getDriver());
				}
				else
				{
					getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected "+getElementTypes+" should be Displyaed", "Actual "+getElementTypes+" is not Displayed ."+ " "+data, getDriver());
				}
			}
		}
	}

	/********************************************************************************************************************
	 * Method : isElementPresentXpath
	 * Description: Checks if the element is present in the page 
	 * Author: Rajmohan Dhanapal
	 * Date: Mar-09-2016
	 ********************************************************************************************************************/	
	public boolean isElementPresentXpath(String elementLocator){
		try{
			getDriver().findElement(By.xpath(elementLocator));
		}catch(org.openqa.selenium.NoSuchElementException e){
			return false;
		}
		return true ; 
	}

	/********************************************************************************************************************
	 * Method : checkMultipleElementPresent
	 * Description: Common function to validate the elements not present Validation
	 * Author: Rajmohan
	 * Date: Mar-09-2016
	 ********************************************************************************************************************/
	public void checkMultipleElementPresent(String getObjectRep, String testInput){
		String getElementTypes = TestDataManage.getData(testInput).trim();
		if(!getElementTypes.equalsIgnoreCase("^"))
		{
			if(getElementTypes.contains("|")){
				String[] elementType = getElementTypes.split("[|]");
				int len = elementType.length;
				for(int i=0;i<len;i++ ){
					waitForPageLoad();
					String data = elementType[i];
					if(data != null && data != ""){
						data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
						if(isElementPresentXpath(data))	
						{
							getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected "+elementType[i]+" should be present", "Actual "+elementType[i]+" Present ."+ " "+data, getDriver());
						}
						else
						{
							getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected "+elementType[i]+" should be present", "Actual "+elementType[i]+" is not Present ."+ " "+data, getDriver());
						}
					}
				}

			}			
			else{
				String data = getElementTypes;
				data = String.format(TestDataManage.getObjectValue(getObjectRep, "xpath"), data);
				if(isElementPresentXpath(data))	
				{
					getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected "+getElementTypes+" should be present", "Actual "+getElementTypes+" present ."+ " "+data, getDriver());
				}
				else
				{
					getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected "+getElementTypes+" should be present", "Actual "+getElementTypes+" is not present ."+ " "+data, getDriver());
				}
			}
		}
	}

	/********************************************************************************************************************
	 * Method : verifyElementDisplayed
	 * Description: Common function to validate the elements Validation
	 * Author: Rajmohan
	 * Date: Feb-07-2016
	 ********************************************************************************************************************/
	public void verifyElementDisplayed(String getObjectRep, String field){
		if(isElementPresent(By.xpath(TestDataManage.getObjectValue(getObjectRep, "xpath")))){
			WebElement element=getDriver().findElement(By.xpath(TestDataManage.getObjectValue(getObjectRep, "xpath")));
			if(element.isDisplayed())	
			{
				getDetailedReport().WriteLog(Status.PASS, "Expected "+field+" should be Displyaed", "Actual "+field+"  Displayed ."+ " "+TestDataManage.getObjectProperty(getObjectRep), getDriver());
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Expected "+field+" should be Displyaed", "Actual given "+field+" is not Displayed ."+ " "+TestDataManage.getObjectProperty(getObjectRep), getDriver());
			}
		}else{
			getDetailedReport().WriteLog(Status.FAIL, "Expected "+field+" should be Displyaed", "Actual given "+field+" is not Present ."+ " "+TestDataManage.getObjectProperty(getObjectRep), getDriver());
		}

	}

	/********************************************************************************************************************
	 * Method : waitForClickable
	 * Description: To wait upto the Element is clickable
	 * Author: Alfred Dcruz
	 * Date: September-05 -2016
	 ********************************************************************************************************************/	

	public boolean waitForClickable(By ObjId){

		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), 60 );
			wait.until(ExpectedConditions.elementToBeClickable(ObjId));
			return true;
		}
		catch(Exception e)
		{

			return false;
		}
	}


	
	/********************************************************************************************************************
	 * Method : waitForElement
	 * Description: To wait for an element, till it is displayed , polling in every 100ms for an amount of time. 
	 * Author: Alfred Dcruz
	 * Date: August-25 -2016
	 ********************************************************************************************************************/



	public WebElement waitForElementTime(final By ObjId, int time){
		try{    new FluentWait<WebDriver>(getDriver()).
			withTimeout(time, TimeUnit.SECONDS).
			pollingEvery(100,TimeUnit.MILLISECONDS).
			until(new Predicate<WebDriver>() {

				public boolean apply(WebDriver driver) {
					try{
						Boolean booFlag= driver.findElement(ObjId).isDisplayed();
						//  System.out.println("I am wait ");
						if(booFlag)
							return true;
						else
							return false;
					}
					catch(Exception e)
					{
						return false;
					}
				}
			}
					);
		}catch(Exception e){
			e.printStackTrace();
			throw new WebDriverException("Unable to locate ELement : "+ObjId+" . \n"+e.getMessage());

		}
		return getDriver().findElement(ObjId);

	}

	/********************************************************************************************************************
	 * Method : CheckDropdownSortList
	 * Description: Added common method validate Drop down list sorted or not
	 * Author: Rajmohan
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void CheckDropdownSortList(String getObjectRep){
		WebElement element = getElement(TestDataManage.getObjectProperty(getObjectRep));
		element.click();
		List<WebElement> dropDownvalues = element.findElements(By.tagName("option"));
		ArrayList<String> listValues = new ArrayList<String>();
		for(WebElement value : dropDownvalues) {
			System.out.println("values are"+ value.getText());
			listValues.add(value.getText());
		}
		boolean sortedOrNot = sortedOrNot(listValues);  
		if(sortedOrNot)	
		{
			getDetailedReport().WriteLog(Status.PASS, "Case valid. Expected given Drop Down Values Should be Sorted", "Actual given Drop Down Values are Sorted ." , getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Case Invalid. Expected given Drop Down Values Should be Sorted", "Actual given Drop Down Values are not Sorted .", getDriver());
		}

	}

	/********************************************************************************************************************
	 * Method : sortedOrNot
	 * Description: To verify whether the arraylist is sorted or Not
	 * Author: Rajmohan
	 * Date: February-20-2016
	 ********************************************************************************************************************/

	public boolean sortedOrNot(ArrayList<String> dropDownValues) {
		int temp =0;
		for(int i=1; i<dropDownValues.size()-1;i++) {
			if(i+1 != dropDownValues.size() )
				System.out.println(dropDownValues.get(i).toUpperCase());
			System.out.println(i);
			System.out.println(dropDownValues.get(i+1).toUpperCase());

			temp = dropDownValues.get(i).toUpperCase().compareTo(dropDownValues.get(i+1).toUpperCase());
			System.out.println(temp);
			if(temp>1) 
				return false;
		}
		return true; 
	}

	public void checkDefaultDropdownValue(String getObjectRep, String expected){
		WebElement element = getElement(TestDataManage.getObjectProperty(getObjectRep));
		String selectedOption = new Select(element).getFirstSelectedOption().getText();
		if(selectedOption.contains(expected))
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text present", getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text not present", getDriver());
		}
	}


	/********************************************************************************************************************
	 * Method : verifyContainsText
	 * Description: To verify whether the element contains the text
	 * Author: Tony George
	 * Date: November 25-2016
	 ********************************************************************************************************************/

	public void verifyContainsText(By by, String expected)
	{
		waitForElement(by);
		String Text=getDriver().findElement(by).getText().trim().replace("\n", "");
		String ExpectedText=expected.trim().replace("\n", "");
		if(Text.contains(ExpectedText))
		{
			getDetailedReport().WriteLog(Status.PASS, "Case valid:Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text present", getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Case Inavlid:Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text not present", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : VerifyGetValueText
	 * Description: To verify whether the element contains the Value 
	 * Author: Rajmohan Dhanapal
	 * Date: Feb 23-2017
	 ********************************************************************************************************************/

	public void verifyGetValueText(By by, String expected)
	{
		waitForElement(by);
		String Text=getDriver().findElement(by).getAttribute("value");
		if(Text.contains(expected.trim().replace("\n", "")))
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text present", getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Field Details: Verify text: "+expected+ ". Expected Text present", "Actual "+expected+" text not present", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : clearTextBox
	 * Description: Added common method to clear the text box
	 * Author: Rajmohan
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void clearTextBox(String objRep){
		waitForElement(TestDataManage.getObjectProperty(objRep));
		getElement(TestDataManage.getObjectProperty(objRep)).clear();  
		getElement(TestDataManage.getObjectProperty(objRep)).sendKeys(Keys.ENTER);
	}

	/********************************************************************************************************************
	 * Method : verifyElementIsDisable
	 * Description: Added common method to check the element is disable
	 * Author: Rajmohan
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void verifyElementIsDisable(String objRep){
		waitForElement(TestDataManage.getObjectProperty(objRep));
		if(!getElement(TestDataManage.getObjectProperty(objRep)).isEnabled()){
			getDetailedReport().WriteLog(Status.PASS, "Expected "+objRep+" should be disabled", "Actual "+objRep+" is disabled", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Expected "+objRep+" should be disabled", "Actual "+objRep+" is not disabled", getDriver());
		}
	}


	/********************************************************************************************************************
	 * Method : VerifyContainsValue
	 * Description: To verify whether the element contains a value
	 * Author: Tony George
	 * Date: Feb 21-2016
	 ********************************************************************************************************************/

	public void verifyContainsValue(By by, String expected)
	{
		waitForElement(by);
		String Text=getDriver().findElement(by).getAttribute("value").trim();
		if(Text.contains(expected.trim()))
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Verify the text contains value: "+expected+ ". Expected value present", "Actual "+expected+" value present", getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Field Details: Verify value: "+expected+ ". Expected value present", "Actual "+expected+" value not present", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : VerifyValuePresent
	 * Description: To verify the value present in element
	 * Author: Tony George
	 * Date: Mar-08-2016
	 ********************************************************************************************************************/

	public void verifyValuePresent(By by, String expected)
	{
		waitForElement(by);
		String text=getDriver().findElement(by).getAttribute("value");
		if(text.equalsIgnoreCase(expected))
		{
			getDetailedReport().WriteLog(Status.PASS, "Field Details: Verify text present is: "+expected, "Actual text :  "+text, getDriver());
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Field Details: Verify text present is: "+expected, "Actual text :  "+text+ " .Does not match with the expected", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : verifyElementIsDisable
	 * Description: To verify whether an element is enabled
	 * Author: Tony George
	 * Date: Feb 21-2016
	 ********************************************************************************************************************/
	public void verifyElementEnabled(String objRep)
	{
		waitForElement(TestDataManage.getObjectProperty(objRep));
		if(getElement(TestDataManage.getObjectProperty(objRep)).isEnabled()){
			getDetailedReport().WriteLog(Status.PASS, "Expected the given Element should be enabled", "Actual "+TestDataManage.getObjectProperty(objRep)+" is enabled", getDriver());
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL, "Expected the given Element should be enabled", "Actual "+TestDataManage.getObjectProperty(objRep)+" is not enabled", getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : VerifyOptionPresentInDropDown
	 * Description: To verify whether the option is present in the drop down
	 * Author: Tony George
	 * Date: Feb 24-2016
	 ********************************************************************************************************************/
	public void verifyOptionPresentInDropDown(String objRep,String Value)
	{
		int flag=0;
		WebElement DropDown = getElement(TestDataManage.getObjectProperty(objRep));
		Select select = new Select(DropDown);  
		List<WebElement> allOptions = select.getOptions(); 
		for(WebElement we:allOptions)  
		{
			if(we.getText().equals(Value))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			getDetailedReport().WriteLog(Status.PASS, "Verify option "+Value+" is present in the dropdown", "Option "+Value+" is present in the dropdown", getDriver()); 

		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Verify option "+Value+" is present in the dropdown", "Option "+Value+" is not present in the dropdown", getDriver()); 
		}


	}

	/********************************************************************************************************************
	 * Method : verifyMutipleOptionPresentInDropDown
	 * Description: To verify mulptiple options present in the dropdown
	 * Author: Tony George
	 * Date: March-15-2016
	 ********************************************************************************************************************/
	public void verifyMutipleOptionPresentInDropDown(String objRep,String Options)
	{

		String dropDownList = TestDataManage.getData(Options).trim();
		if(dropDownList.contains("|"))
		{
			String[] dropDownValue = dropDownList.split("[|]");
			int len = dropDownValue.length;
			for(int i=0;i<len;i++ )
			{
				String data = dropDownValue[i];
				verifyOptionPresentInDropDown(objRep,data);

			}

		}


	}

	/********************************************************************************************************************
	 * Method : clickMultipleLinksAndVerifyNaviagatedURL
	 * Description: To click on the multiple link and verify the navigated URL
	 * Author: Tony George
	 * Date: Mar-03-2016
	 ********************************************************************************************************************/
	public void clickMultipleLinksAndVerifyNaviagatedURL(String link,String URL)
	{
		String getlinks = TestDataManage.getData(link).trim();
		String[] LinkList = getlinks.split("[|]");

		String getUrls = TestDataManage.getData(URL).trim();
		String[] UrlList = getUrls.split("[|]");
		int len = LinkList.length;

		for(int i=0;i<LinkList.length;i++)
		{
			String test=LinkList[i];
			By Locator=By.linkText(LinkList[i]);
			waitForElement(Locator);
			click(Locator);
			waitForPageLoad();
			String NavigatedURL = getDriver().getCurrentUrl();
			if(NavigatedURL.equalsIgnoreCase(UrlList[i]))
			{
				getDetailedReport().WriteLog(Status.PASS,"Need to navigate to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link" ,"Navigated to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link", getDriver()); 
			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL,"Need to navigate to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link" ,"Did not Navigate to the "+UrlList[i]+" after clicking the"+LinkList[i]+" link", getDriver()); 
			}
			getDriver().navigate().back();
		}
	}
	/********************************************************************************************************************
	 * Method : clickLinkAndVerifyNaviagatedURL
	 * Description: To click on a  link and verify the navigated URL
	 * Author: Tony George
	 * Date: Mar-07-2016
	 ********************************************************************************************************************/
	public void clickLinkAndVerifyNaviagatedURL(String ObjectIdentifier,String URL)
	{
		By locator=TestDataManage.getObjectProperty(ObjectIdentifier);
		String ExpectedURL=TestDataManage.getData(URL);
		waitForElement(locator);
		click(locator);
		waitForPageLoad();
		pause(5000);
		String NavigatedURL = getDriver().getCurrentUrl();
		if(NavigatedURL.equalsIgnoreCase(ExpectedURL))
		{
			getDetailedReport().WriteLog(Status.PASS,"Case valid:Need to navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link" ,"Navigated to the "+URL+" after clicking the"+ObjectIdentifier+" link", getDriver()); 
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL,"Case Invalid:Need to navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link" ,"Did not Navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link", getDriver()); 
		}
		getDriver().navigate().back();
	}

	/********************************************************************************************************************
	 * Method : verifyPageTitle
	 * Description: Verify thr Page title
	 * Author: Rajmohan Dhanapal
	 * Date: Marc-08-2016
	 ********************************************************************************************************************/

	public void verifyPageTitle(String title) {
		if(getDriver().getTitle().equalsIgnoreCase(title)){
			getDetailedReport().WriteLog(Status.PASS,"Page title should match with Expcted Title "+title ,"Page title matched with Expcted Title"+getDriver().getTitle(), getDriver()); 
		}
		else{
			getDetailedReport().WriteLog(Status.FAIL,"Page title should match with Expcted Title "+title ,"Page title is no match with Expcted Title"+getDriver().getTitle(), getDriver());
		}
	}

	/********************************************************************************************************************
	 * Method : clickLinkAndVerifyNaviagatedURLContainsText
	 * Description: To click on a  link and verify the navigated URL contains text
	 * Author: Tony George
	 * Date: Mar-20-2016
	 ********************************************************************************************************************/
	public void clickLinkAndVerifyNaviagatedURLInNewWindow(String ObjectIdentifier,String URL)
	{
		By locator=TestDataManage.getObjectProperty(ObjectIdentifier);
		String ExpectedURL=TestDataManage.getData(URL);
		waitForElement(locator);
		click(locator);
		waitForPageLoad();
		String WinhandleBefore=switchToNewWindow();
		String NavigatedURL = getDriver().getCurrentUrl();
		if(NavigatedURL.contains(ExpectedURL))
		{
			getDetailedReport().WriteLog(Status.PASS,"Case Valid:Need to navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link" ,"Navigated to the "+URL+" after clicking the"+ObjectIdentifier+" link", getDriver()); 
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL,"Case Invalid:Need to navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link" ,"Did not Navigate to the "+URL+" after clicking the"+ObjectIdentifier+" link", getDriver()); 
		}
		getDriver().close();
		getDriver().switchTo().window(WinhandleBefore);
	}
	/********************************************************************************************************************
	 * Method : waitUntilElementNotVisible
	 * Description: To wait until element is not visible
	 * Author: Tony George
	 * Date: November-11 -2017
	 ********************************************************************************************************************/	

	public boolean waitUntilElementNotVisible(By ObjId){

		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), 60 );
			wait.until(ExpectedConditions.invisibilityOfElementLocated(ObjId));
			return true;
		}
		catch(Exception e)
		{

			return false;
		}
	}

	}