package com.netapp.supportsite.base;


import org.openqa.selenium.JavascriptExecutor;
import com.ust.sarf.testdata.TestDataManage;

/**
 * Class : LoginBase
 * @author : UST Global
 */

public class LoginBase extends Base {

	  /********************************************************************************************************************
 	* Method : EnterCredentials
 	* Description: To enter the username and password
 	* Author: Salba Balakrishnan
 	* Date:August-25 -2016
 	********************************************************************************************************************/
   
   public void enterCredentials() 
   {
	   waitForElement(TestDataManage.getObjectProperty("UserName"));
	   type(TestDataManage.getObjectProperty("UserName"), TestDataManage.getData("UserName"));
	   type(TestDataManage.getObjectProperty("Password"), TestDataManage.getData("Password"));
       
   }

	

       /********************************************************************************************************************
     	* Method : verifyTitle
     	* Description: To verify the title of the Login page
     	* Author: Salba Balakrishnan
     	* Date:August-25 -2016
     	********************************************************************************************************************/
       
       public void verifyTitle() 
       {
    	  try
    	  {
    	  // waitForElementTime(TestDataManage.getObjectProperty("LoginPage_Title"),180);
    	   waitForTitle(TestDataManage.getObjectValue("LoginPage_Title", "TEXT"));
    	  }
    	  catch(Exception e)
    	  {
    		  //System.exit(1); 
    	  }
       
       
       }

   /********************************************************************************************************************
   	* Method : submit
   	* Description: To click the Submit button
   	* Author: Salba Balakrishnan
   	* Date:August-25 -2016
   	********************************************************************************************************************/

       public void submit() 
       {
    	pause(8000);
    	click("Login_Button");
        //APPLICATION LOAD ISSUE 
        waitForPageLoad();
        pause(5000);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
 	   for (int i=0; i<200; i++){ 
 		  
 		   //To check page ready state.
 		   if (js.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")){
 		    System.out.println("Page is ready ");
 			   break;
 		   }
 		    else{
 		    	System.out.println("Waiting for the page to load");
 		    	pause(10000);
 		    }
 	   }   
      
                  
              
       }
       
       /********************************************************************************************************************
      	* Method : verifyTitleHome
      	* Description: To verify the title of the home page
      	* Author: Salba Balakrishnan
      	* modified:Sreejith
      	* Date:November-14-2016
      	********************************************************************************************************************/
       
       public void verifyTitleHome() 
       {
    	   	System.out.println("Started to verify  title");
              waitForTitle(TestDataManage.getObjectValue("HomePage_Title","TEXT"));
       }
      
       /********************************************************************************************************************
     	* Method : verifyTitleHome
     	* Description: To verify the title of the home page
     	* Author: Salba Balakrishnan
     	* modified:Sreejith
     	* Date:November-14-2016
     	********************************************************************************************************************/
      
      public void navigateToLoginPage() 
      {
    	  waitForElement(TestDataManage.getObjectProperty("Login_Link"));
    	  click("Login_Link");
      }
   
   
   
}
